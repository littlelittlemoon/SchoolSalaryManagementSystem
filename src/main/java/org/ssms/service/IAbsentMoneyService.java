package org.ssms.service;


import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.AbsentMoney;
import org.ssms.web.param.AbsentMoneyQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.HrAbsentInfoResult;

import java.util.List;

/**
 * <p>
 * 考勤扣款表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface IAbsentMoneyService extends IService<AbsentMoney> {
    BaseResponse countAbsentMoney(List<String> staffIds);

    BaseResponse<HrAbsentInfoResult> getAbsentInfoResult(AbsentMoneyQueryParam param);
}
