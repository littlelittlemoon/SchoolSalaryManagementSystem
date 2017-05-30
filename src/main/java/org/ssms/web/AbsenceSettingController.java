package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.entity.AbsenceSetting;
import org.ssms.service.IAbsenceSettingService;
import org.ssms.utils.UUIDGenerator;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;

/**
 * <p>
 * 缺勤扣款规则表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@RestController
@RequestMapping("/absenceSetting")
public class AbsenceSettingController {
    @Resource
    private IAbsenceSettingService absenceSettingService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        BaseResponse response = absenceSettingService.list();

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "absentType", method = RequestMethod.GET)
    public String absentType() {
        BaseResponse response = absenceSettingService.getAbsentType();

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(AbsenceSetting setting) {
        BaseResponse response = new BaseResponse();
        setting.setId(UUIDGenerator.generatorId());
        absenceSettingService.insert(setting);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(String id) {
        BaseResponse response = new BaseResponse();
        absenceSettingService.deleteById(id);

        return JSON.toJSONString(response);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(AbsenceSetting setting) {
        BaseResponse response = new BaseResponse();
        absenceSettingService.updateById(setting);

        return JSON.toJSONString(response);
    }
}
