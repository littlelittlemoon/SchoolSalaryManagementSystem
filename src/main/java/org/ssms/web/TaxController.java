package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.ITaxService;
import org.ssms.web.param.TaxQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 纳税款表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@RestController
@RequestMapping("/tax")
public class TaxController {
    @Resource
    private ITaxService taxService;

    @RequestMapping(value = "countTaxMoney", method = RequestMethod.POST)
    public String countTaxMoney(String staffIds) {
        List<String> ids = JSON.parseArray(staffIds, String.class);
        BaseResponse response = taxService.countTaxMoney(ids);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "taxMoneyResult", method = RequestMethod.GET)
    public String taxMoneyResult(TaxQueryParam param) {
        BaseResponse response = taxService.taxMoneyResult(param);

        return JSON.toJSONString(response);
    }
}
