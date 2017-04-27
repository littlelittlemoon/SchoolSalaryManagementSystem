package org.ssms.service;


import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.AbsentInfo;
import org.ssms.web.param.ApplyLeaveParam;
import org.ssms.web.result.BaseResponse;

/**
 * <p>
 * 考勤信息表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface IAbsentInfoService extends IService<AbsentInfo> {
	BaseResponse addAbsentInfo(ApplyLeaveParam param);
}
