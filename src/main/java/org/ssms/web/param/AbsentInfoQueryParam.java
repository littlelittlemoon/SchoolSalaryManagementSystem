package org.ssms.web.param;

import lombok.Data;

@Data
public class AbsentInfoQueryParam extends PageParam{
    private String staffId;

    private String departmentId;

    private String searchCondition;

    private String id;

    private String time;

    private String state;
}
