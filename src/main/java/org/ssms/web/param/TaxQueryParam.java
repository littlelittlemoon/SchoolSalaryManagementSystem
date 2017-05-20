package org.ssms.web.param;

import lombok.Data;

/**
 * Created by Intellij IDEA
 * DATE: 2017/5/20
 * TIME: 下午4:14
 */
@Data
public class TaxQueryParam extends PageParam {
    private String staffId;

    private String departmentId;

    private String searchCondition;
}
