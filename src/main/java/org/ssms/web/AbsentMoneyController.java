package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.IAbsentMoneyService;
import org.ssms.web.param.AbsentMoneyQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
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

    @RequestMapping(value = "countAbsentMoney", method = RequestMethod.POST)
    public String countAbsentMoney(String staffIds) {
        List<String> ids = JSON.parseArray(staffIds, String.class);
        BaseResponse response = absentMoneyService.countAbsentMoney(ids);

        return JSON.toJSONString(response);
    }

    /**
     *
     */
    @RequestMapping(value = "absentInfoResult", method = RequestMethod.GET)
    public String absentInfoResult(AbsentMoneyQueryParam param) {
        BaseResponse response = absentMoneyService.getAbsentInfoResult(param);

        return JSON.toJSONString(response);
    }
}
