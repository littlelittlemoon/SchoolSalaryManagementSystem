package org.ssms.web.result;

import lombok.Data;

import java.util.List;

/**
 * Created by Intellij IDEA
 * USER: luoliang
 * DATE: 2017/5/30
 * TIME: 下午2:59
 */
@Data
public class HistorySalaryResult extends PageResult{
    private List<SalaryDetail> salaryDetails;
}
