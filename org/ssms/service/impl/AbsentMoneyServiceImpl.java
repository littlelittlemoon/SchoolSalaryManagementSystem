package org.ssms.service.impl;

import org.ssms.entity.AbsentMoney;
import org.ssms.mapper.AbsentMoneyMapper;
import org.ssms.service.IAbsentMoneyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考勤扣款表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@Service
public class AbsentMoneyServiceImpl extends ServiceImpl<AbsentMoneyMapper, AbsentMoney> implements IAbsentMoneyService {
	
}
