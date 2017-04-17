package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.Duty;
import org.ssms.mapper.DutyMapper;
import org.ssms.service.IDutyService;

/**
 * <p>
 * 职务信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class DutyServiceImpl extends ServiceImpl<DutyMapper, Duty> implements IDutyService {
	
}
