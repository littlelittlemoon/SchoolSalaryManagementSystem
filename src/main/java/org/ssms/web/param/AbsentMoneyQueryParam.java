package org.ssms.web.param;

import lombok.Data;

@Data
public class AbsentMoneyQueryParam extends PageParam {
    private String departmentId;

    private String searchCondition;
}
