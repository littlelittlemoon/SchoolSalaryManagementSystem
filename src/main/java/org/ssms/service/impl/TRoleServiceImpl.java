package org.ssms.test.service.impl;

import org.ssms.test.entity.TRole;
import org.ssms.test.mapper.TRoleMapper;
import org.ssms.test.service.ITRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
