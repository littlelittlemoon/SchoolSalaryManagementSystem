package org.ssms.web.result;

import lombok.Data;

import java.util.List;

/**
 * Created by Intellij IDEA
 * DATE: 2017/5/6
 * TIME: 下午2:48
 */
@Data
public class StaffAbsentInfoResult extends PageResult{
    private List<StaffAbsentInfoDetail> staffAbsentInfoDetails;
}
