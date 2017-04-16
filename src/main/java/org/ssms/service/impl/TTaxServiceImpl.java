package org.ssms.test.service.impl;

import org.ssms.test.entity.TTax;
import org.ssms.test.mapper.TTaxMapper;
import org.ssms.test.service.ITTaxService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
