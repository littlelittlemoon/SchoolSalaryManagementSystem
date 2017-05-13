package org.ssms.mapper.result;

import lombok.Data;
import org.ssms.entity.AbsentInfo;
import org.ssms.web.result.Absence;

import java.util.List;

@Data
public class HrAbsentInfo {
    private String staffId;

    private String staffName;

    private String checkTime;

    private String departmentName;

    private Integer absentDays;

    private String money;

    private List<AbsentInfo> absentInfos;
}
