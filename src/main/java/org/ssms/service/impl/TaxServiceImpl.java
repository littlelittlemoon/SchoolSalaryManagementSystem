package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
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
public class ITaxService extends ServiceImpl<TaxMapper, TTax> implements ITaxService {
	
}
