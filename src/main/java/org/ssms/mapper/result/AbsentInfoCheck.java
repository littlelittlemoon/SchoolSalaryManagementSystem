package org.ssms.mapper.result;

import lombok.Data;

@Data
public class AbsentInfoCheck {
    private String staffId;

    private String staffName;

    private String absentApplyTime;

    private String absentReason;

    private String absentStartTime;

    private String absentEndTime;

    private String absentDays;
}
