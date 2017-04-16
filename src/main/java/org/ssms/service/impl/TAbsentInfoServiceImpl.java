package org.ssms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TAbsentInfo;
import org.ssms.mapper.TAbsentInfoMapper;
import org.ssms.service.ITAbsentInfoService;

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
