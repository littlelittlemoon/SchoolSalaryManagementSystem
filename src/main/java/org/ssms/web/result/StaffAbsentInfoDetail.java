package org.ssms.web.result;

import lombok.Data;

import java.util.List;

/**
 * Created by Intellij IDEA
 * USER: TanKaiYue
 * DATE: 2017/5/6
 * TIME: 下午2:23
 */
@Data
public class StaffAbsentInfoDetail {
    private String absentCheckTime;

    private String staffId;

    private String staffName;

    private Integer absentDays;

    private String department;

    private Float shouldDays;

    private Float realDays;

    private Float absentTotalMoney;

    private List<Absence> absences;
}

