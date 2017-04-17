package org.ssms.entity.viewentity;

import lombok.Data;

import java.util.Date;

@Data
public class StaffInfoView {
    private String staffId;

    /**
     * 员工姓名
     */
    private String staffName;
    /**
     * 员工性别
     */
    private String staffSex;
    /**
     * 身份证号
     */
    private String staffIdentityNum;
    /**
     * 所属部门编号
     */
    private String departmentName;
    /**
     * 职称编号
     */
    private String titleName;
    /**
     * 职务编号
     */
    private String dutyName;
    /**
     * 入职时间
     */
    private Date staffEntryTime;
    /**
     * 银行卡账号
     */
    private String staffBankAcount;
    /**
     * 电话号码&登录账号
     */
    private String staffTel;

    private String roleName;

    private String dutySalary;

    private String titleSalary;

    private String titleBaseSalary;
}
