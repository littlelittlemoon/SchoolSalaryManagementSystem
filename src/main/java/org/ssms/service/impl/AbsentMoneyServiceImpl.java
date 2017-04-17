package org.ssms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.mapper.AbsentMoneyMapper;
import org.ssms.service.IAbsentMoneyService;

/**
 * <p>
 * 考勤扣款表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class IAbsentMoneyService extends ServiceImpl<AbsentMoneyMapper, TAbsentMoney> implements IAbsentMoneyService {
	
}
