package org.ssms.service.impl;

import org.ssms.entity.StaffInfo;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.service.IStaffInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@Service
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoMapper, StaffInfo> implements IStaffInfoService {
	
}
