package org.ssms.web;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssms.service.IToBankService;
import org.ssms.web.param.SalaryQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;

/**
 * <p>
 * 银行发放表 前端控制器
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@RestController
@RequestMapping("/salary")
public class ToBankController {
    @Resource
    private IToBankService toBankService;

    /**
     * 财务处审核工资计算结果
     * @param param
     * @return
     */
    @RequestMapping(value = "checkSalaryList", method = RequestMethod.GET)
    public String checkSalaryList(SalaryQueryParam param) {
        BaseResponse response = toBankService.checkSalaryList(param);

        return JSON.toJSONString(response);

    }

    /**
     * 将工资发放单发送至银行
     * @param param
     * @return
     */
    @RequestMapping(value = "sendToBank", method = RequestMethod.POST)
    public String sendToBank(SalaryQueryParam param) {
        BaseResponse response = toBankService.sendToBank(param);

        return JSON.toJSONString(response);
    }

    /**
     * 发送工资单到各部门人员
     * @param param
     * @return
     */
    @RequestMapping(value = "sendToDepartment", method = RequestMethod.POST)
    public String sendToDepartment(SalaryQueryParam param) {
        BaseResponse response = toBankService.sendToDepartment(param);

        return JSON.toJSONString(response);
    }

    /**
     * 获取历史工资发放信息
     * @param param
     * @return
     */
    @RequestMapping(value = "historySalaryList", method = RequestMethod.GET)
    public String historySalaryList(SalaryQueryParam param) {
        BaseResponse response = toBankService.historySalaryList(param);

        return JSON.toJSONString(response);

    }
}
