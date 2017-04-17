package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.mapper.RoleMapper;
import org.ssms.service.IRoleService;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class IRoleService extends ServiceImpl<RoleMapper, TRole> implements IRoleService {
	
}
