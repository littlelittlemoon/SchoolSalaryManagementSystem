package org.ssms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.ssms.entity.AbsentInfo;
import org.ssms.mapper.AbsentInfoMapper;
import org.ssms.service.IAbsentInfoService;
import org.ssms.web.param.ApplyLeaveParam;
import org.ssms.web.result.BaseResponse;

/**
 * <p>
 * 考勤信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
@Slf4j
public class AbsentInfoServiceImpl extends ServiceImpl<AbsentInfoMapper, AbsentInfo> implements IAbsentInfoService {

    @Override
    public BaseResponse addAbsentInfo(ApplyLeaveParam param) {
        BaseResponse response = new BaseResponse();

        AbsentInfo absentInfo = new AbsentInfo();
        BeanUtils.copyProperties(param, absentInfo);
        absentInfo.setAbsentState("std");

        try {
            log.debug("请假信息：{}", JSON.toJSONString(absentInfo));
            insert(absentInfo);
        } catch (Exception e) {
            log.error("申请请假业务异常：", e);
            response.setCode("1");
            response.setMessage(e.getMessage());
        }

        return response;
    }
}
