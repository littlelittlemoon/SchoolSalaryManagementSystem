package org.ssms.web;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.entity.TaxSetting;
import org.ssms.service.ITaxSettingService;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;

/**
 * <p>
 * 扣税规则表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@RestController
@RequestMapping("/taxSetting")
public class TaxSettingController {
    @Resource
    private ITaxSettingService taxSettingService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        BaseResponse response = new BaseResponse();
        response.setData(taxSettingService.selectList(new EntityWrapper<>()));

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(TaxSetting setting) {
        BaseResponse response = new BaseResponse();
        taxSettingService.insert(setting);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(String id) {
        BaseResponse response = new BaseResponse();
        taxSettingService.deleteById(id);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(TaxSetting setting) {
        BaseResponse response = new BaseResponse();
        taxSettingService.updateById(setting);

        return JSON.toJSONString(response);
    }
}
