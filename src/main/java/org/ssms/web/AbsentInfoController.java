package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.IAbsentInfoService;
import org.ssms.web.param.ApplyLeaveParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;

/**
 * <p>
 * 考勤信息表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@RestController
@RequestMapping("/absentInfo")
public class AbsentInfoController {
    @Resource
    private IAbsentInfoService absentInfoService;

    @RequestMapping(value = "applyLeave", method = RequestMethod.POST)
    public String applyLeave(ApplyLeaveParam applyLeaveParam) {
        BaseResponse response = absentInfoService.addAbsentInfo(applyLeaveParam);

        return JSON.toJSONString(response);

    }
}
