package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.IAbsentInfoService;
import org.ssms.web.param.AbsentInfoQueryParam;
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

    /**
     * 员工申请请假接口
     *
     * @param applyLeaveParam
     * @return
     */
    @RequestMapping(value = "applyLeave", method = RequestMethod.POST)
    public String applyLeave(ApplyLeaveParam applyLeaveParam) {
        BaseResponse response = absentInfoService.addAbsentInfo(applyLeaveParam);

        return JSON.toJSONString(response);

    }

    /**
     * 根据员工id返回请假记录接口
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "absentInfoList", method = RequestMethod.GET)
    public String absentInfoList(AbsentInfoQueryParam param) {
        BaseResponse response = absentInfoService.getAbsentInfoList(param);

        return JSON.toJSONStringWithDateFormat(response, "yyyy-MM-dd");
    }

    /**
     * 部门管理员获取待审核考勤记录
     */
    @RequestMapping(value = "absentInfoCheckList", method = RequestMethod.GET)
    public String AbsentInfoCheckList(AbsentInfoQueryParam param) {
        BaseResponse response = absentInfoService.getAbsentInfoCheckList(param);

        return JSON.toJSONStringWithDateFormat(response, "yyyy-MM-dd");
    }
}
