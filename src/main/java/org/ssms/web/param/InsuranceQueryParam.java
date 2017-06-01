package org.ssms.web.param;

import lombok.Data;

/**
 * Created by Intellij IDEA
 * USER: TanKaiYue
 * DATE: 2017/5/20
 * TIME: 上午11:15
 */
@Data
public class InsuranceQueryParam  extends PageParam{
    private String staffId;

    private String departmentId;

    private String searchCondition;
}
