package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.IInsuranceService;
import org.ssms.web.param.InsuranceQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 五险一金表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    @Resource
    private IInsuranceService insuranceService;

    /***
     * 计算五险一金
     * @param staffIds
     * @return
     */
    @RequestMapping(value = "countInsuranceMoney", method = RequestMethod.POST)
    public String countInsuranceMoney(String staffIds) {
        List<String> ids = JSON.parseArray(staffIds, String.class);
        BaseResponse response = insuranceService.countInsuranceMoney(ids);

        return JSON.toJSONString(response);
    }

    /**
     * 获取五险一金计算结果
     * @param param
     * @return
     */
    @RequestMapping(value = "insuranceMoneyResult", method = RequestMethod.GET)
    public String insuranceMoneyResult(InsuranceQueryParam param) {
        BaseResponse response = insuranceService.insuranceInfoResult(param);

        return JSON.toJSONString(response);
    }

    /**
     * 调整五险一金计算结果
     * @param staffId
     * @param insuranceTime
     * @param medical
     * @param unemp
     * @param accu
     * @param aged
     * @return
     */
    @RequestMapping(value = "updateInsuranMoney", method = RequestMethod.POST)
    public String updateInsuranMoney(String staffId, String insuranceTime, Float medical, Float unemp, Float accu, Float aged) {
        BaseResponse response = insuranceService.updateInsuranMoney(staffId, insuranceTime, medical, unemp, accu, aged);

        return JSON.toJSONString(response);
    }
}
