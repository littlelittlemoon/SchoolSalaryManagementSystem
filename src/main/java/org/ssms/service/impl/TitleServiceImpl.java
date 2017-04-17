package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.Title;
import org.ssms.mapper.TitleMapper;
import org.ssms.service.ITitleService;

/**
 * <p>
 * 职称信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TitleServiceImpl extends ServiceImpl<TitleMapper, Title> implements ITitleService {
	
}
