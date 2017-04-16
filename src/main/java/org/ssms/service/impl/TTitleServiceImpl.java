package org.ssms.test.service.impl;

import org.ssms.test.entity.TTitle;
import org.ssms.test.mapper.TTitleMapper;
import org.ssms.test.service.ITTitleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
