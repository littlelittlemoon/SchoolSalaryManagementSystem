package org.ssms.service.impl;

import org.ssms.entity.Department;
import org.ssms.mapper.DepartmentMapper;
import org.ssms.service.IDepartmentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
	
}
