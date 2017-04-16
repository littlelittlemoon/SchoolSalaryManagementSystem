package org.ssms.test.service.impl;

import org.ssms.test.entity.TAbsentMoney;
import org.ssms.test.mapper.TAbsentMoneyMapper;
import org.ssms.test.service.ITAbsentMoneyService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考勤扣款表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TAbsentMoneyServiceImpl extends ServiceImpl<TAbsentMoneyMapper, TAbsentMoney> implements ITAbsentMoneyService {
	
}
