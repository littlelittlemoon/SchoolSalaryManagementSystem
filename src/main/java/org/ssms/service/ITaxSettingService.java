package org.ssms.service;

import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.TaxSetting;
import org.ssms.web.result.BaseResponse;

import java.util.List;

/**
 * <p>
 * 扣税规则表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
public interface ITaxSettingService extends IService<TaxSetting> {
    BaseResponse<List<TaxSetting>> list();
}
