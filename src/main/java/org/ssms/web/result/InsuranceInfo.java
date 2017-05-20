package org.ssms.web.result;

import lombok.Data;

/**
 * Created by Intellij IDEA
 * DATE: 2017/5/20
 * TIME: 下午2:44
 */
@Data
public class InsuranceInfo {
    private String checkTime;

    private String staffId;

    private String staffName;

    private String departmentName;

    private String titleName;

    private String dutyName;

    private Float insuranceBase;

    private Float insuranceTotal;

    private Float insuranceMedical;

    private Float insuranceUnemp;

    private Float insuranceAccu;

    private Float insuranceAged;
}
