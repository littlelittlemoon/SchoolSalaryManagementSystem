package org.ssms.web.result;

import lombok.Data;

import java.util.List;

/**
 * Created by Intellij IDEA
 * USER: tankaiyue
 * DATE: 2017/5/20
 * TIME: 上午11:17
 */
@Data
public class InsuranceInfoResult extends PageResult{
    private List<InsuranceInfo> insuranceInfoList;
}
