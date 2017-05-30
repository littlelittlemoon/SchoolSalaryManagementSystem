package org.ssms.web;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.entity.InsuranceSetting;
import org.ssms.service.IInsuranceSettingService;
import org.ssms.utils.UUIDGenerator;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;

/**
 * <p>
 * 五险一金扣款规则表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@RestController
@RequestMapping("/insuranceSetting")
public class InsuranceSettingController {
    @Resource
    private IInsuranceSettingService insuranceSettingService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        BaseResponse response = insuranceSettingService.list();

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(InsuranceSetting insuranceSetting) {
        BaseResponse response = new BaseResponse();
        insuranceSetting.setId(UUIDGenerator.generatorId());
        insuranceSettingService.insert(insuranceSetting);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String delete(String id){
        BaseResponse response = new BaseResponse();
        insuranceSettingService.deleteById(id);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(InsuranceSetting insuranceSetting){
        BaseResponse response = new BaseResponse();
        insuranceSettingService.updateById(insuranceSetting);

        return JSON.toJSONString(response);
    }
}
