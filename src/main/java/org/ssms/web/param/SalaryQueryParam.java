package org.ssms.web.param;

import lombok.Data;

/**
 * Created by Intellij IDEA
 * DATE: 2017/5/29
 * TIME: 下午10:13
 */
@Data
public class SalaryQueryParam extends PageParam{
    private String searchCondition;

    private String departmentId;

    private String time;
}
