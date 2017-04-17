package org.ssms.service.impl;

import org.ssms.entity.ToBank;
import org.ssms.mapper.ToBankMapper;
import org.ssms.service.IToBankService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 银行发放表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@Service
public class ToBankServiceImpl extends ServiceImpl<ToBankMapper, ToBank> implements IToBankService {
	
}
