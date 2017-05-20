package org.ssms.web.result;

import lombok.Data;
import org.ssms.mapper.result.HrAbsentMoney;

import java.util.List;


@Data
public class HrAbsentMoneyResult extends PageResult{
    private List<HrAbsentMoney> hrAbsentMoneyList;
}
