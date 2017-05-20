package org.ssms.mapper.result;

import lombok.Data;
import org.ssms.entity.AbsentInfo;

import java.util.List;

/**
 * 这个类用来封装Mapper，hr管理缺勤金
 */
@Data
public class HrAbsentMoney {
    private String staffId;

    private String staffName;

    private String checkTime;//只有年月没有日

    private String departmentName;

    private Integer absentDays;

    private String money;

    private List<AbsentInfo> absentMoneyList;
}
