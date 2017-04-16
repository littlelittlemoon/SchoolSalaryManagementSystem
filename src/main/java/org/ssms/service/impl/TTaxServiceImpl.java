package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TTax;
import org.ssms.mapper.TTaxMapper;
import org.ssms.service.ITTaxService;

/**
 * <p>
 * 纳税款表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TTaxServiceImpl extends ServiceImpl<TTaxMapper, TTax> implements ITTaxService {
	
}
