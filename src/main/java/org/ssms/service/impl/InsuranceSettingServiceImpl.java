package org.ssms.service.impl;

import org.ssms.entity.InsuranceSetting;
import org.ssms.mapper.InsuranceSettingMapper;
import org.ssms.service.IInsuranceSettingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 五险一金扣款规则表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@Service
public class InsuranceSettingServiceImpl extends ServiceImpl<InsuranceSettingMapper, InsuranceSetting> implements IInsuranceSettingService {
	
}
