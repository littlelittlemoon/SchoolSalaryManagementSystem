package org.ssms.test.service.impl;

import org.ssms.test.entity.TInsurance;
import org.ssms.test.mapper.TInsuranceMapper;
import org.ssms.test.service.ITInsuranceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 五险一金表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TInsuranceServiceImpl extends ServiceImpl<TInsuranceMapper, TInsurance> implements ITInsuranceService {
	
}
