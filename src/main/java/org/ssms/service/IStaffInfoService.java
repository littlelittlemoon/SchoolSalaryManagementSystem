package org.ssms.service;


import com.baomidou.mybatisplus.service.IService;
import org.ssms.entity.StaffInfo;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.web.param.StaffInfoAddParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.StaffInfoResult;

import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 员工信息表 服务类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
public interface IStaffInfoService extends IService<StaffInfo> {
    BaseResponse<String> verifyUser(String username, String password);

    BaseResponse addStaff(StaffInfoAddParam param);

    BaseResponse<StaffInfoResult> staffList(StaffQueryParam param);

    BaseResponse<StaffInfoView> getStaff(String staffId);

    BaseResponse changePwd(String staffId,String oldPwd,String newPwd);

    BaseResponse updateStaffInfo(StaffInfo staffInfo);
}
