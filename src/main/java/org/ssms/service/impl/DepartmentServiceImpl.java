package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.mapper.DepartmentMapper;
import org.ssms.service.IDepartmentService;

/**
 * <p>
 * 部门信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class IDepartmentService extends ServiceImpl<DepartmentMapper, TDepartment> implements IDepartmentService {
	
}
