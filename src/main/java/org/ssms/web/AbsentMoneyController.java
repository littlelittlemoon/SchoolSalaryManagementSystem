package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.IAbsentMoneyService;
import org.ssms.web.param.AbsentMoneyQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * <p>
 * 考勤扣款表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@RestController
@RequestMapping("/absentMoney")
public class AbsentMoneyController {
    @Resource
    private IAbsentMoneyService absentMoneyService;

    /**
     * 人事部门获取待计算缺勤信息
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "absentInfoResult", method = RequestMethod.GET)
    public String absentInfoResult(AbsentMoneyQueryParam param) {
        BaseResponse response = absentMoneyService.getAbsentInfoResult(param);

        return JSON.toJSONString(response);
    }

    /**
     * 计算缺勤扣款
     * @param staffIds
     * @return
     */
    @RequestMapping(value = "countAbsentMoney", method = RequestMethod.POST)
    public String countAbsentMoney(String staffIds) {
        List<String> ids = JSON.parseArray(staffIds, String.class);
        BaseResponse response = absentMoneyService.countAbsentMoney(ids);

        return JSON.toJSONString(response);
    }

    /**
     * 人事部门获取缺勤金计算结果
     * @param param
     * @return
     */
    @RequestMapping(value = "absentMoneyResult", method = RequestMethod.GET)
    public String absentMoneyResult(AbsentMoneyQueryParam param) {
        BaseResponse response = absentMoneyService.getAbsentMoneyResult(param);

        return JSON.toJSONString(response);
    }

    /**
     * 人事部门调整缺勤计算结果
     * @param staffId
     * @param startTime
     * @param money
     * @return
     */
    @RequestMapping(value = "updateAbsentMoney", method = RequestMethod.POST)
    public String updateAbsentMoney(String staffId, String startTime, Double money)  {
        BaseResponse response = absentMoneyService.updateAbsentInfo(staffId, startTime, money);

        return JSON.toJSONString(response);
    }
}
