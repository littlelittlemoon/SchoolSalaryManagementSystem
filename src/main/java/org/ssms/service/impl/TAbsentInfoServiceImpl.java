package org.ssms.test.service.impl;

import org.ssms.test.entity.TAbsentInfo;
import org.ssms.test.mapper.TAbsentInfoMapper;
import org.ssms.test.service.ITAbsentInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 考勤信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TAbsentInfoServiceImpl extends ServiceImpl<TAbsentInfoMapper, TAbsentInfo> implements ITAbsentInfoService {
	
}
