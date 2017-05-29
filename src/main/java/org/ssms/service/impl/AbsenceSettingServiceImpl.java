package org.ssms.service.impl;

import org.ssms.entity.AbsenceSetting;
import org.ssms.mapper.AbsenceSettingMapper;
import org.ssms.service.IAbsenceSettingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 缺勤扣款规则表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@Service
public class AbsenceSettingServiceImpl extends ServiceImpl<AbsenceSettingMapper, AbsenceSetting> implements IAbsenceSettingService {
	
}
