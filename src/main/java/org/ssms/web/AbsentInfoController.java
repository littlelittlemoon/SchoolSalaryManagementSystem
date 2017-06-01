package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.IAbsentInfoService;
import org.ssms.web.param.AbsentInfoQueryParam;
import org.ssms.web.param.ApplyLeaveParam;
import org.ssms.web.param.CheckAbsentInfoParam;
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
     * 员工撤回申请请假接口
     *
     * @param applyLeaveParam
     * @return
     */
    @RequestMapping(value = "turnBack", method = RequestMethod.POST)
    public String turnBack(ApplyLeaveParam applyLeaveParam) {
        BaseResponse response = absentInfoService.turnBackApplication(applyLeaveParam);

        return JSON.toJSONString(response);

    }

    /**
     * 根据员工id返回考勤信息接口
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
    public String absentInfoCheckList(AbsentInfoQueryParam param) {
        BaseResponse response = absentInfoService.getAbsentInfoCheckList(param);

        return JSON.toJSONStringWithDateFormat(response, "yyyy-MM-dd");
    }

    @RequestMapping(value = "checkAbsentInfo", method = RequestMethod.POST)
    public String checkAbsentInfo(CheckAbsentInfoParam param) {
        BaseResponse response = absentInfoService.updateAbsentInfo(param);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "staffAbsentInfo", method = RequestMethod.GET)
    public String staffAbsentInfo(AbsentInfoQueryParam param) {
        BaseResponse response = absentInfoService.staffAbsentInfoList(param);

        return JSON.toJSONStringWithDateFormat(response, "yyyy-MM-dd");
    }

    /**
     * 发送到人事处
     *
     * @param staffId
     * @return
     */
    @RequestMapping(value = "sendToHr", method = RequestMethod.POST)
    public String sendToHr(String staffId) {
        BaseResponse response = absentInfoService.sendAbsentInfoToHr(staffId);

        return JSON.toJSONString(response);
    }

    /**
     * 人事处审核考勤信息
     */
    @RequestMapping(value = "hrCheckAbsentInfo", method = RequestMethod.GET)
    public String hrCheckAbsentInfo(AbsentInfoQueryParam param) {
        BaseResponse response = absentInfoService.hrCheckAbsentInfo(param);

        return JSON.toJSONStringWithDateFormat(response, "yyyy-MM-dd");
    }
}
