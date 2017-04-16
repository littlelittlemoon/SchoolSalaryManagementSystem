package org.ssms.test.service.impl;

import org.ssms.test.entity.TDepartment;
import org.ssms.test.mapper.TDepartmentMapper;
import org.ssms.test.service.ITDepartmentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
