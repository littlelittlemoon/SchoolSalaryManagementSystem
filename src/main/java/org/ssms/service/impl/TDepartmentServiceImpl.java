package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TDepartment;
import org.ssms.mapper.TDepartmentMapper;
import org.ssms.service.ITDepartmentService;

/**
 * <p>
 * 部门信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TDepartmentServiceImpl extends ServiceImpl<TDepartmentMapper, TDepartment> implements ITDepartmentService {
	
}
