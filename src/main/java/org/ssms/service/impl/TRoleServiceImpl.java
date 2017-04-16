package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TRole;
import org.ssms.mapper.TRoleMapper;
import org.ssms.service.ITRoleService;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements ITRoleService {
	
}
