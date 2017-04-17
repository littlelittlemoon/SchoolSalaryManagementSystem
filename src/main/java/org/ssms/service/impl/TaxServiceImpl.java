package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.Tax;
import org.ssms.mapper.TaxMapper;
import org.ssms.service.ITaxService;

/**
 * <p>
 * 纳税款表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TaxServiceImpl extends ServiceImpl<TaxMapper, Tax> implements ITaxService {
	
}
