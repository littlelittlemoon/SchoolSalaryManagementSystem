package org.tantan.ssms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.tantan.ssms.entity.TTax;
import org.tantan.ssms.mapper.TTaxMapper;
import org.tantan.ssms.service.ITTaxService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 纳税款表  服务实现类
 * </p>
 *
 * @author Tankaiyue
 * @since 2017-03-20
 */
@Service
public class TTaxServiceImpl extends ServiceImpl<TTaxMapper, TTax> implements ITTaxService {
	
}
