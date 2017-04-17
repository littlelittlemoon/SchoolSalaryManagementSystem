package org.ssms.service.impl;

import org.ssms.entity.Tax;
import org.ssms.mapper.TaxMapper;
import org.ssms.service.ITaxService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 纳税款表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@Service
public class TaxServiceImpl extends ServiceImpl<TaxMapper, Tax> implements ITaxService {
	
}
