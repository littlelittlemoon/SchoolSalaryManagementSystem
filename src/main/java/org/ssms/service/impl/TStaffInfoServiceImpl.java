package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TStaffInfo;
import org.ssms.mapper.TStaffInfoMapper;
import org.ssms.service.ITStaffInfoService;

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
