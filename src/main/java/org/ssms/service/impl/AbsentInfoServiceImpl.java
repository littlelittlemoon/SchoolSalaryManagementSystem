package org.ssms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.ssms.entity.AbsentInfo;
import org.ssms.mapper.AbsentInfoMapper;
import org.ssms.mapper.result.AbsentInfoCheck;
import org.ssms.service.IAbsentInfoService;
import org.ssms.web.param.AbsentInfoQueryParam;
import org.ssms.web.param.ApplyLeaveParam;
import org.ssms.web.result.AbsentInfoCheckResult;
import org.ssms.web.result.AbsentInfoResult;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    @Resource
    private AbsentInfoMapper absentInfoMapper;

    @Override
    public BaseResponse addAbsentInfo(ApplyLeaveParam param) {
        BaseResponse response = new BaseResponse();

        AbsentInfo absentInfo = new AbsentInfo();
        BeanUtils.copyProperties(param, absentInfo);
        absentInfo.setAbsentState("std");
        absentInfo.setAbsentCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
        absentInfo.setAbsentApplyTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

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

    @Override
    public BaseResponse<AbsentInfoResult> getAbsentInfoList(AbsentInfoQueryParam param) {
        BaseResponse<AbsentInfoResult> response = new BaseResponse<>();

        Page<AbsentInfo> page = new Page<>();
        page.setSize(param.getPageSize());
        page.setCurrent(param.getCurrentPage());
        EntityWrapper<AbsentInfo> ew = new EntityWrapper<>();
        ew.where("staff_id={0}", param.getStaffId());

        try {
            Page<AbsentInfo> absentInfoPage = this.selectPage(page);

            for (int i = 0; i < absentInfoPage.getRecords().size(); i++) {
                AbsentInfo absentInfo = absentInfoPage.getRecords().get(i);
                if (Objects.equals(absentInfo.getAbsentState(), "std")) {
                    absentInfoPage.getRecords().get(i).setAbsentState("待审核");
                }
                if (Objects.equals(absentInfo.getAbsentState(), "d_pass")) {
                    absentInfoPage.getRecords().get(i).setAbsentState("部门通过");
                }
                if (Objects.equals(absentInfo.getAbsentState(), "d_reject")) {
                    absentInfoPage.getRecords().get(i).setAbsentState("部门打回");
                }
            }

            AbsentInfoResult absentInfoResult = new AbsentInfoResult();
            absentInfoResult.setTotal(absentInfoPage.getTotal());
            absentInfoResult.setCurrentPage(absentInfoPage.getCurrent());
            absentInfoResult.setAbsentInfos(absentInfoPage.getRecords());
            response.setData(absentInfoResult);

        } catch (Exception e) {
            log.error("请假信息业务查询异常:", e);
            response.setCode("1");
            response.setMessage("请假信息业务查询异常:" + e.getMessage());
        }


        return response;
    }

    @Override
    public BaseResponse<AbsentInfoCheckResult> getAbsentInfoCheckList(AbsentInfoQueryParam param) {
        BaseResponse<AbsentInfoCheckResult> response = new BaseResponse<>();
        AbsentInfoCheckResult absentInfoCheckResult = new AbsentInfoCheckResult();
        response.setData(absentInfoCheckResult);

        Page<AbsentInfoCheck> page = new Page();
        page.setCurrent(param.getCurrentPage());
        page.setSize(param.getPageSize());

        try {
            page.setRecords(baseMapper.getAbsentInfoCheck(page, param.getStaffId()));
            absentInfoCheckResult.setCurrentPage(page.getCurrent());
            absentInfoCheckResult.setTotal(page.getTotal());
            absentInfoCheckResult.setAbsentInfoChecks(page.getRecords());

        } catch (Exception e) {
            log.error("获取管理员待审批考勤记录业务异常：", e);
            response.setCode("1");
            response.setMessage(e.getMessage());
        }

        return response;
    }


}
