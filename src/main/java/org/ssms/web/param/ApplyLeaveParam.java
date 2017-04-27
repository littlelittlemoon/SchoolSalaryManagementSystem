package org.ssms.web.param;

import lombok.Data;

@Data
public class ApplyLeaveParam {
    private String staffId;

    private String absentReason;

    private String absentStartTime;

    private String absentEndTime;

    private Integer absentDays;
}
