package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.service.IStaffInfoService;
import org.ssms.web.param.StaffInfoAddParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.List;

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
        BaseResponse response = staffInfoService.verifyUser(username, password);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.POST)
    public String addStaff(StaffInfoAddParam param) {
        BaseResponse response = staffInfoService.addStaff(param);
        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "staffList", method = RequestMethod.GET)
    public String staffList(StaffQueryParam param) {
        BaseResponse<List<StaffInfoView>> response = staffInfoService.staffList(param);

        return JSON.toJSONString(response);
    }
}