package org.ssms.test.service.impl;

import org.ssms.test.entity.TStaffInfo;
import org.ssms.test.mapper.TStaffInfoMapper;
import org.ssms.test.service.ITStaffInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TStaffInfoServiceImpl extends ServiceImpl<TStaffInfoMapper, TStaffInfo> implements ITStaffInfoService {
	
}
