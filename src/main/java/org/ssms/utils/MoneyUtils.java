package org.ssms.utils;

import lombok.extern.slf4j.Slf4j;
import org.ssms.entity.AbsentInfo;
import org.ssms.entity.AbsentMoney;
import org.ssms.entity.viewentity.StaffInfoView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class MoneyUtils {

    /**
     * 算出总缺勤金额
     *
     * @param absentInfos
     * @param staffInfoViews
     * @return
     */
    public static double countAbsentMoneyByStaff(List<AbsentInfo> absentInfos, List<StaffInfoView> staffInfoViews) {
        StaffInfoView staffInfoView = staffInfoViews.get(0);
        BigDecimal totalAbsentMoney = new BigDecimal(0);
        for (AbsentInfo absentInfo : absentInfos) {
            totalAbsentMoney = totalAbsentMoney.add(countAbsentMoneyDetail(absentInfo.getAbsentReason(),
                    absentInfo, staffInfoView));
        }

        return totalAbsentMoney.doubleValue();
    }

    /**
     * 根据原因算出缺勤金额的方法
     *
     * @param reason
     * @param absentInfo
     * @param staffInfoView
     * @return
     */
    public static BigDecimal countAbsentMoneyDetail(String reason, AbsentInfo absentInfo, StaffInfoView staffInfoView) {
        BigDecimal totalAbsentMoney = new BigDecimal(0);
        BigDecimal day = new BigDecimal(Double.valueOf(absentInfo.getAbsentDays()));
        BigDecimal monthDay = new BigDecimal(Double.valueOf(21));
        BigDecimal dutySalary = new BigDecimal(staffInfoView.getDutySalary());
        BigDecimal titleSalary = new BigDecimal(staffInfoView.getTitleSalary());
        BigDecimal titleBaseSalary = new BigDecimal(staffInfoView.getTitleBaseSalary());
        BigDecimal monthSalary = dutySalary.add(titleBaseSalary).add(titleSalary);
        double dayTemp = 0.0;
        switch (reason) {
            case "事假":
                dayTemp = day.divide(monthDay, 6, RoundingMode.HALF_UP).doubleValue();
                BigDecimal temp = new BigDecimal(dayTemp)
                        .multiply(monthSalary);
                totalAbsentMoney = totalAbsentMoney.add(temp);
                break;
            case "病假":
                dayTemp = day.divide(monthDay, 6, RoundingMode.HALF_UP).doubleValue();
                totalAbsentMoney = totalAbsentMoney.add(new BigDecimal(dayTemp))
                        .multiply(monthSalary)
                        .divide(new BigDecimal(2), 6, RoundingMode.HALF_UP);
                break;
            case "产假":
                if (absentInfo.getAbsentDays() > 90) {
                    totalAbsentMoney = totalAbsentMoney.add(
                            day.subtract(new BigDecimal(90))
                                    .multiply(monthSalary)
                                    .divide(new BigDecimal(21), 6, RoundingMode.HALF_UP)
                    );
                }
                break;
            case "婚假":
                if (absentInfo.getAbsentDays() > 7) {
                    totalAbsentMoney = totalAbsentMoney.add(day.subtract(new BigDecimal(7))
                            .multiply(monthSalary)
                            .divide(new BigDecimal(21), 6, RoundingMode.HALF_UP));
                }
                break;
            case "旷工":
                totalAbsentMoney = totalAbsentMoney.add(day.divide(monthDay, 6, RoundingMode.HALF_UP)
                        .multiply(monthSalary)
                        .multiply(new BigDecimal(3)));
                break;
            default:
                break;
        }

        return totalAbsentMoney;
    }


    /**
     * 计算五险一金的方法
     *
     * @param staffInfoView
     * @param absentMoney
     * @return
     */
    public static Map<String, BigDecimal> countInsuranMoneyDetail(StaffInfoView staffInfoView, AbsentMoney absentMoney) {
        BigDecimal dutySalary = new BigDecimal(staffInfoView.getDutySalary());
        BigDecimal titleSalary = new BigDecimal(staffInfoView.getTitleSalary());
        BigDecimal titleBaseSalary = new BigDecimal(staffInfoView.getTitleBaseSalary());
        BigDecimal absentMon = new BigDecimal(absentMoney.getMoney());
        BigDecimal baseNum = dutySalary.add(titleSalary)
                .add(titleBaseSalary).subtract(absentMon)
                .multiply(new BigDecimal(0.6));//缴纳基数
        Map<String, BigDecimal> result = new HashMap<>();
        BigDecimal medical = baseNum.multiply(new BigDecimal(0.02));
        result.put("medical", medical);//医疗保险
        BigDecimal aged = baseNum.multiply(new BigDecimal(0.08));
        result.put("aged", aged);//养老保险
        BigDecimal unemp = baseNum.multiply(new BigDecimal(0.01));
        result.put("unemp", unemp);//失业保险
        BigDecimal accu = baseNum.multiply(new BigDecimal(0.01));
        result.put("accu", accu);//公积金
        result.put("base", baseNum);
        result.put("total", medical.add(aged).add(unemp).add(accu));

        return result;
    }
}
