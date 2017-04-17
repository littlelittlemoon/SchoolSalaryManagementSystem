package org.ssms.service.impl;

import org.ssms.entity.Role;
import org.ssms.mapper.RoleMapper;
import org.ssms.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-17
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
}
