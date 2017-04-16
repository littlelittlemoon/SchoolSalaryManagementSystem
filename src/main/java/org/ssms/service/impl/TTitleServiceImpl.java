package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TTitle;
import org.ssms.mapper.TTitleMapper;
import org.ssms.service.ITTitleService;

/**
 * <p>
 * 职称信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TTitleServiceImpl extends ServiceImpl<TTitleMapper, TTitle> implements ITTitleService {
	
}
