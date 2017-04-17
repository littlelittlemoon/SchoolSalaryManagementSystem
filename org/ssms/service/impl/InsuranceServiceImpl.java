package org.ssms.service.impl;

import org.ssms.entity.Insurance;
import org.ssms.mapper.InsuranceMapper;
import org.ssms.service.IInsuranceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 五险一金表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@Service
public class InsuranceServiceImpl extends ServiceImpl<InsuranceMapper, Insurance> implements IInsuranceService {
	
}
