package org.ssms.test.service.impl;

import org.ssms.test.entity.TToBank;
import org.ssms.test.mapper.TToBankMapper;
import org.ssms.test.service.ITToBankService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
