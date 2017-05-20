package org.ssms.web.result;

import lombok.Data;
import org.ssms.mapper.result.HrAbsentInfo;
import org.ssms.mapper.result.HrAbsentMoney;

import java.util.List;

@Data
public class HrAbsentInfoResult extends PageResult {
    private List<HrAbsentInfo> hrAbsentInfos;
}
