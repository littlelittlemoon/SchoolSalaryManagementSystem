package org.ssms.service;

import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.InsuranceSetting;
import org.ssms.web.result.BaseResponse;

import java.util.List;

/**
 * <p>
 * 五险一金扣款规则表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
public interface IInsuranceSettingService extends IService<InsuranceSetting> {
    BaseResponse<List<InsuranceSetting>> list();
}
