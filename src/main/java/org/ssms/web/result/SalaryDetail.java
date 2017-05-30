package org.ssms.web.result;

import lombok.Data;

/**
 * Created by Intellij IDEA
 * DATE: 2017/5/29
 * TIME: 下午10:27
 */
@Data
public class SalaryDetail {
    //    staff_id, staff_name, title_basesalary, title_salary, duty_salary,
//    insurance_total, tax_tax_money, money, staff_tel, staff_bank_acount, staff_identity_num
    private String staffId;

    private String staffName;

    private Float baseSalary;

    private String dutyName;

    private String titleName;

    private Float titleSalary;

    private Float dutySalary;

    private Float insuranceTotal;

    private Float taxMoney;

    private Float absentMoney;

    private String departmentName;

    private String staffTel;

    private String bankAcount;

    private String identityNum;

    private String status;

    private Float realPay;

    private Float shouldPay;

    private String checkTime;
}
