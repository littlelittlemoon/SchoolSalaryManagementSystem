package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TToBank;
import org.ssms.mapper.TToBankMapper;
import org.ssms.service.ITToBankService;

/**
 * <p>
 * 银行发放表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TToBankServiceImpl extends ServiceImpl<TToBankMapper, TToBank> implements ITToBankService {
	
}
