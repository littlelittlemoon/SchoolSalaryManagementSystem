package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.ITStaffInfoService;
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
@RequestMapping("/tStaffInfo")
public class TStaffInfoController {
    @Resource
    private ITStaffInfoService itStaffInfoService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(String username, String password) {
        BaseResponse response = itStaffInfoService.verifyUser(username, password);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "addStaff", method = RequestMethod.POST)
    public String addStaff() {
return "";
    }
}
