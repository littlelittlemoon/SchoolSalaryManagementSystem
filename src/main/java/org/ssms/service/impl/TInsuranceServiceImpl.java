package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TInsurance;
import org.ssms.mapper.TInsuranceMapper;
import org.ssms.service.ITInsuranceService;

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
