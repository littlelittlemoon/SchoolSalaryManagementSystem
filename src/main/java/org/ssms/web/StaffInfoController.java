package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.entity.StaffInfo;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.service.IStaffInfoService;
import org.ssms.web.param.StaffInfoAddParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;

/**
 * <p>
 * 员工信息表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@RestController
@RequestMapping("/staffInfo")
public class StaffInfoController {
    @Resource
    private IStaffInfoService staffInfoService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(String username, String password) {
        BaseResponse<String> response = staffInfoService.verifyUser(username, password);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.POST)
    public String addStaff(StaffInfoAddParam param) {
        BaseResponse response = staffInfoService.addStaff(param);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "staffList", method = RequestMethod.GET)
    public String staffList(StaffQueryParam param) {
        BaseResponse response = staffInfoService.staffList(param);

        return JSON.toJSONStringWithDateFormat(response, "yyyy-MM-dd");
    }

    @RequestMapping(value = "getStaff", method = RequestMethod.GET)
    public String getStaff(String staffId) {
        BaseResponse<StaffInfoView> response = staffInfoService.getStaff(staffId);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    public String changePwd(String staffId, String oldPwd, String newPwd) {
        BaseResponse response = staffInfoService.changePwd(staffId, oldPwd, newPwd);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "updateStaffInfo", method = RequestMethod.POST)
    public String updateStaffInfo(StaffInfo staffInfo) {
        BaseResponse response = staffInfoService.updateStaffInfo(staffInfo);

        return JSON.toJSONString(response);

    }

    @RequestMapping(value = "deleteStaffInfo", method = RequestMethod.POST)
    public String deleteStaffInfo(String staffId) {
        BaseResponse response = new BaseResponse();
        staffInfoService.deleteById(staffId);

        return JSON.toJSONString(response);

    }
}
