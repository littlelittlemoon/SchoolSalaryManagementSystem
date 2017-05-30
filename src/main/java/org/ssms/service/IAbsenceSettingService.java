package org.ssms.service;

import org.ssms.entity.AbsenceSetting;
import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.InsuranceSetting;
import org.ssms.web.result.BaseResponse;

import java.util.List;

/**
 * <p>
 * 缺勤扣款规则表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
public interface IAbsenceSettingService extends IService<AbsenceSetting> {
	BaseResponse<List<AbsenceSetting>> list();

	BaseResponse<List<String>> getAbsentType();
}
