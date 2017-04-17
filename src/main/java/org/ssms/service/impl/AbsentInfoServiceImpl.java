package org.ssms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.mapper.AbsentInfoMapper;
import org.ssms.service.IAbsentInfoService;

/**
 * <p>
 * 考勤信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class IAbsentInfoService extends ServiceImpl<AbsentInfoMapper, TAbsentInfo> implements IAbsentInfoService {
	
}
