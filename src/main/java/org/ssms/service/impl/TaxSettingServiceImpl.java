package org.ssms.service.impl;

import org.ssms.entity.TaxSetting;
import org.ssms.mapper.TaxSettingMapper;
import org.ssms.service.ITaxSettingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 扣税规则表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@Service
public class TaxSettingServiceImpl extends ServiceImpl<TaxSettingMapper, TaxSetting> implements ITaxSettingService {
	
}
