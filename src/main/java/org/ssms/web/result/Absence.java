package org.ssms.web.result;

import lombok.Data;

/**
 * Created by Intellij IDEA
 * USER: luoliang
 * DATE: 2017/5/6
 * TIME: 下午3:49
 */
@Data
public class Absence {
    private String absentStartTime;

    private String absentEndTime;

    private String absentReason;

    private Integer absentDays;

    private Float money;
}
