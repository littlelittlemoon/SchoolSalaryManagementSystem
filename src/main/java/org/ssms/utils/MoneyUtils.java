package org.ssms.utils;

import lombok.extern.slf4j.Slf4j;
import org.ssms.entity.*;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.result.HrAbsentMoney;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MoneyUtils {

    /**
     * 计算缺勤金额的方法
     *
     * @param absenceSetting
     * @param absentInfo
     * @param staffInfoView
     * @return
     */
    public static BigDecimal countAbsentMoneyDetail(AbsenceSetting absenceSetting, AbsentInfo absentInfo, StaffInfoView staffInfoView) {
        BigDecimal absentMoney = new BigDecimal(0);
        BigDecimal day = new BigDecimal(Double.valueOf(absentInfo.getAbsentDays()));
        BigDecimal monthDay = new BigDecimal(Double.valueOf(absenceSetting.getShouldDays()));
        BigDecimal dutySalary = new BigDecimal(staffInfoView.getDutySalary());
        BigDecimal titleSalary = new BigDecimal(staffInfoView.getTitleSalary());
        BigDecimal titleBaseSalary = new BigDecimal(staffInfoView.getTitleBaseSalary());
        BigDecimal monthSalary = dutySalary.add(titleBaseSalary).add(titleSalary);

        /**
         * 根据缺勤类型分别计算出缺勤扣除细则
         *
         * 缺勤扣款 = 缺勤天数 / 应到天数 * （基础工资）* 扣除比例
         */
        double dayTemp = day.divide(monthDay, 6, RoundingMode.HALF_UP).doubleValue();
        BigDecimal temp = new BigDecimal(dayTemp)
                .multiply(monthSalary).multiply(new BigDecimal(absenceSetting.getProportion()));
        absentMoney = absentMoney.add(temp);
        return absentMoney;
    }


    /**
     * 计算五险一金的方法
     *
     * @param staffInfoView
     * @param absentMoney
     * @return
     */
    public static Map<String, BigDecimal> countInsuranMoneyDetail(StaffInfoView staffInfoView, AbsentMoney absentMoney, InsuranceSetting insuranceSetting) {
        BigDecimal dutySalary = new BigDecimal(staffInfoView.getDutySalary());
        BigDecimal titleSalary = new BigDecimal(staffInfoView.getTitleSalary());
        BigDecimal titleBaseSalary = new BigDecimal(staffInfoView.getTitleBaseSalary());
        BigDecimal absentMon = new BigDecimal(absentMoney.getMoney());
        /**
         * 计算五险一金缴纳基数：（基本工资+职务工资+职称工资-缺勤扣款）*需要缴纳五险一金的工资比例
         */
        BigDecimal baseNum = dutySalary.add(titleSalary)
                .add(titleBaseSalary).subtract(absentMon)
                .multiply(new BigDecimal(insuranceSetting.getBaseRate()));
        Map<String, BigDecimal> result = new HashMap<>();
        /**
         * 医疗保险
         */
        BigDecimal medical = baseNum.multiply(new BigDecimal(insuranceSetting.getMedicalRate()));
        result.put("medical", medical);
        /**
         * 养老保险
         */
        BigDecimal aged = baseNum.multiply(new BigDecimal(insuranceSetting.getAgedRate()));
        result.put("aged", aged);
        /**
         * 失业保险
         */
        BigDecimal unemp = baseNum.multiply(new BigDecimal(insuranceSetting.getUnempRate()));
        result.put("unemp", unemp);
        /**
         * 公积金
         */
        BigDecimal accu = baseNum.multiply(new BigDecimal(insuranceSetting.getAccuRate()));

        result.put("accu", accu);
        result.put("base", baseNum);
        result.put("total", medical.add(aged).add(unemp).add(accu));

        return result;
    }

    /***
     * 交税基数 = 基本工资 + 职务工资 + 职称工资 - 缺勤扣款 - 五险一金扣款 - 3500
     */
    public static int getTaxBaseMoney(StaffInfoView staffInfoView, AbsentMoney absentMoney, Insurance insurance) {
        /**
         * 计算交税基数
         */
        BigDecimal baseMoney = new BigDecimal(staffInfoView.getTitleBaseSalary())
                .add(new BigDecimal(staffInfoView.getDutySalary()))
                .add(new BigDecimal(staffInfoView.getTitleSalary()))
                .subtract(new BigDecimal(insurance.getInsuranceTotal()))
                .subtract(new BigDecimal(absentMoney.getMoney()))
                .subtract(new BigDecimal(3500));

        return baseMoney.intValue();
    }

    /**
     * 根据人员信息计算交税金额
     *
     * @param staffInfoView
     * @param absentMoney
     * @param insurance
     * @return
     */
    public static Map<String, BigDecimal> countTaxMoneyDetail(StaffInfoView staffInfoView, AbsentMoney absentMoney, Insurance insurance,
                                                              TaxSetting taxSetting, double base) {
        Map<String, BigDecimal> result = new HashMap<>();

        BigDecimal baseMoney = new BigDecimal(base);
        BigDecimal taxRate = new BigDecimal(taxSetting.getRate());
        BigDecimal taxCaucl = new BigDecimal(taxSetting.getCalcuNum());

        /**
         * 扣税金额 = 适用税率 * 交税基数 - 速算扣除数
         */

        result.put("tax", baseMoney.multiply(taxRate).subtract(taxCaucl));
        result.put("taxRate", taxRate);
        result.put("taxCaucl", taxCaucl);
        result.put("baseMoney", baseMoney);

        return result;
    }

    /**
     * 计算应发工资和实发工资
     */
    public static Map<String, BigDecimal> countShouldRealPay(StaffInfoView staffInfoView, Tax tax, Insurance insurance, HrAbsentMoney absentMoney) {
        Map<String, BigDecimal> resultMap = new HashMap<>();

        /**
         * 应发工资 = 基本工资+职称工资+职务工资
         */
        BigDecimal shouldPay = new BigDecimal(staffInfoView.getDutySalary()).add(new BigDecimal(staffInfoView.getTitleSalary()))
                .add(new BigDecimal(staffInfoView.getTitleBaseSalary()));
        resultMap.put("shouldPay", shouldPay);

        /**
         * 实发工资 = 应发工资 - 五险一金扣款 - 缺勤扣款 - 交税金额
         */
        BigDecimal realPay = shouldPay.subtract(new BigDecimal(tax.getTaxTaxMoney())).subtract(new BigDecimal(insurance.getInsuranceTotal()))
                .subtract(new BigDecimal(absentMoney.getMoney()));
        resultMap.put("realPay", realPay);

        return resultMap;
    }
}
