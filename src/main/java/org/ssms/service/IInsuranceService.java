package org.ssms.service;


import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.Insurance;
import org.ssms.web.param.InsuranceQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.InsuranceInfoResult;

import java.util.List;

/**
 * <p>
 * 五险一金表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface IInsuranceService extends IService<Insurance> {
   BaseResponse<InsuranceInfoResult> insuranceInfoResult(InsuranceQueryParam param);

   BaseResponse countInsuranceMoney(List<String> staffIds);

   BaseResponse updateInsuranMoney(String staffId, String startTime, Float medical, Float unemp, Float accu, Float aged);
}
