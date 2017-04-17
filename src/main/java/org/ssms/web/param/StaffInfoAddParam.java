package org.ssms.web.param;

import lombok.Data;

@Data
public class StaffInfoAddParam {
    private String staffName;

    private String staffSex;

    private String departmentId;

    private String titleId;

    private String dutyId;

    private String staffEntryTime;

    private String staffIdentityNum;

    private String staffBankAcount;

    private String staffTel;
}
