package org.ssms.web.result;

import lombok.Data;

/**
 * Created by Intellij IDEA
 * DATE: 2017/5/22
 * TIME: 下午11:12
 */
@Data
public class TaxInfo {
    private String staffId;

    private String checkTime;

    private String staffName;

    private String departmentName;

    private String baseMoney;

    private String taxMoney;

    private String taxCalcu;

    private String taxRate;
}
