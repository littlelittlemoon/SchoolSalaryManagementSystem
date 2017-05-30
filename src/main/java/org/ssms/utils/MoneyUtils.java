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
     * 根据原因算出缺勤金额的方法
     *
     * @param absenceSetting
     * @param absentInfo
     * @param staffInfoView
     * @return
     */
    public static BigDecimal countAbsentMoneyDetail(AbsenceSetting absenceSetting, AbsentInfo absentInfo, StaffInfoView staffInfoView) {
        BigDecimal totalAbsentMoney = new BigDecimal(0);
        BigDecimal day = new BigDecimal(Double.valueOf(absentInfo.getAbsentDays()));
        BigDecimal monthDay = new BigDecimal(Double.valueOf(absenceSetting.getShouldDays()));
        BigDecimal dutySalary = new BigDecimal(staffInfoView.getDutySalary());
        BigDecimal titleSalary = new BigDecimal(staffInfoView.getTitleSalary());
        BigDecimal titleBaseSalary = new BigDecimal(staffInfoView.getTitleBaseSalary());
        BigDecimal monthSalary = dutySalary.add(titleBaseSalary).add(titleSalary);

        double dayTemp = day.divide(monthDay, 6, RoundingMode.HALF_UP).doubleValue();
        BigDecimal temp = new BigDecimal(dayTemp)
                .multiply(monthSalary).multiply(new BigDecimal(absenceSetting.getProportion()));
        totalAbsentMoney = totalAbsentMoney.add(temp);
//        switch (reason) {
//            case "事假":
//                dayTemp = day.divide(monthDay, 6, RoundingMode.HALF_UP).doubleValue();
//                BigDecimal temp = new BigDecimal(dayTemp)
//                        .multiply(monthSalary);
//                totalAbsentMoney = totalAbsentMoney.add(temp);
//                break;
//            case "病假":
//                dayTemp = day.divide(monthDay, 6, RoundingMode.HALF_UP).doubleValue();
//                totalAbsentMoney = totalAbsentMoney.add(new BigDecimal(dayTemp))
//                        .multiply(monthSalary)
//                        .divide(new BigDecimal(2), 6, RoundingMode.HALF_UP);
//                break;
//            case "产假":
//                if (absentInfo.getAbsentDays() > 90) {
//                    totalAbsentMoney = totalAbsentMoney.add(
//                            day.subtract(new BigDecimal(90))
//                                    .multiply(monthSalary)
//                                    .divide(new BigDecimal(21), 6, RoundingMode.HALF_UP)
//                    );
//                }
//                break;
//            case "婚假":
//                if (absentInfo.getAbsentDays() > 7) {
//                    totalAbsentMoney = totalAbsentMoney.add(day.subtract(new BigDecimal(7))
//                            .multiply(monthSalary)
//                            .divide(new BigDecimal(21), 6, RoundingMode.HALF_UP));
//                }
//                break;
//            case "旷工":
//                totalAbsentMoney = totalAbsentMoney.add(day.divide(monthDay, 6, RoundingMode.HALF_UP)
//                        .multiply(monthSalary)
//                        .multiply(new BigDecimal(3)));
//                break;
//            default:
//                break;
//        }

        return totalAbsentMoney;
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
        BigDecimal baseNum = dutySalary.add(titleSalary)
                .add(titleBaseSalary).subtract(absentMon)
                .multiply(new BigDecimal(insuranceSetting.getBaseRate()));//缴纳基数
        Map<String, BigDecimal> result = new HashMap<>();
        BigDecimal medical = baseNum.multiply(new BigDecimal(insuranceSetting.getMedicalRate()));
        result.put("medical", medical);//医疗保险
        BigDecimal aged = baseNum.multiply(new BigDecimal(insuranceSetting.getAgedRate()));
        result.put("aged", aged);//养老保险
        BigDecimal unemp = baseNum.multiply(new BigDecimal(insuranceSetting.getUnempRate()));
        result.put("unemp", unemp);//失业保险
        BigDecimal accu = baseNum.multiply(new BigDecimal(insuranceSetting.getAccuRate()));
        result.put("accu", accu);//公积金
        result.put("base", baseNum);
        result.put("total", medical.add(aged).add(unemp).add(accu));

        return result;
    }


    public static int getTaxBaseMoney(StaffInfoView staffInfoView, AbsentMoney absentMoney, Insurance insurance) {
        BigDecimal baseMoney = new BigDecimal(staffInfoView.getTitleBaseSalary())  //这一坨都是计算缴纳基数
                .add(new BigDecimal(staffInfoView.getDutySalary()))
                .add(new BigDecimal(staffInfoView.getTitleSalary()))
                .subtract(new BigDecimal(insurance.getInsuranceTotal()))
                .subtract(new BigDecimal(absentMoney.getMoney()))
                .subtract(new BigDecimal(3500));

        return baseMoney.intValue();
    }

    /**
     * 根据人员信息计算税金
     *
     * @param staffInfoView
     * @param absentMoney
     * @param insurance
     * @return
     */
    public static Map<String, BigDecimal> countTaxMoneyDetail(StaffInfoView staffInfoView, AbsentMoney absentMoney, Insurance insurance,
                                                              TaxSetting taxSetting, int base) {
        Map<String, BigDecimal> result = new HashMap<>();
        BigDecimal baseMoney = new BigDecimal(base);  //这一坨都是计算缴纳基数
//                .add(new BigDecimal(staffInfoView.getDutySalary()))
//                .add(new BigDecimal(staffInfoView.getTitleSalary()))
//                .subtract(new BigDecimal(insurance.getInsuranceTotal()))
//                .subtract(new BigDecimal(absentMoney.getMoney()))
//                .subtract(new BigDecimal(3500));
        BigDecimal taxRate = new BigDecimal(taxSetting.getRate());
        BigDecimal taxCaucl = new BigDecimal(taxSetting.getCalcuNum());
//        if (baseMoney.intValue() <= 1500) {
//            taxRate = new BigDecimal(0.03);
//            taxCaucl = new BigDecimal(0);
//        } else if (baseMoney.intValue() > 1500 && baseMoney.intValue() < 4500) {
//            taxRate = new BigDecimal(0.10);
//            taxCaucl = new BigDecimal(105);
//        } else if (baseMoney.intValue() > 4500 && baseMoney.intValue() < 9000) {
//            taxRate = new BigDecimal(0.20);
//            taxCaucl = new BigDecimal(555);
//        } else if (baseMoney.intValue() > 9000 && baseMoney.intValue() < 35000) {
//            taxRate = new BigDecimal(25);
//            taxCaucl = new BigDecimal(1005);
//        } else if (baseMoney.intValue() > 35000 && baseMoney.intValue() < 55000) {
//            taxRate = new BigDecimal(0.30);
//            taxCaucl = new BigDecimal(2755);
//        } else if (baseMoney.intValue() > 55000 && baseMoney.intValue() < 80000) {
//            taxRate = new BigDecimal(0.35);
//            taxCaucl = new BigDecimal(5505);
//        } else {
//            taxRate = new BigDecimal(0.45);
//            taxCaucl = new BigDecimal(13505);
//        }
        result.put("tax", baseMoney.multiply(taxRate).subtract(taxCaucl));
        result.put("taxRate", taxRate);
        result.put("taxCaucl", taxCaucl);
        result.put("baseMoney", baseMoney);

        return result;
    }

    public static Map<String, BigDecimal> countShouldRealPay(StaffInfoView staffInfoView, Tax tax, Insurance insurance, HrAbsentMoney absentMoney) {
        Map<String, BigDecimal> resultMap = new HashMap<>();
        BigDecimal shouldPay = new BigDecimal(staffInfoView.getDutySalary()).add(new BigDecimal(staffInfoView.getTitleSalary()))
                .add(new BigDecimal(staffInfoView.getTitleBaseSalary()));
        resultMap.put("shouldPay", shouldPay);

        BigDecimal realPay = shouldPay.subtract(new BigDecimal(tax.getTaxTaxMoney())).subtract(new BigDecimal(insurance.getInsuranceTotal()))
                .subtract(new BigDecimal(absentMoney.getMoney()));
        resultMap.put("realPay", realPay);

        return resultMap;
    }
}
