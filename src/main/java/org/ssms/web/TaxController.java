package org.ssms.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.ITaxService;
import org.ssms.web.param.TaxQueryParam;

import javax.annotation.Resource;

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
        return "";
    }

    @RequestMapping(value = "taxMoneyResult", method = RequestMethod.POST)
    public String taxMoneyResult(TaxQueryParam param) {
        return "";
    }
}
