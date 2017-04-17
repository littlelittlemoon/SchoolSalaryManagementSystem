package org.ssms.service;


import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.TStaffInfo;
import org.ssms.web.result.BaseResponse;

/**
 * <p>
 * 员工信息表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface ITStaffInfoService extends IService<TStaffInfo> {
    BaseResponse verifyUser(String username, String password);
}
