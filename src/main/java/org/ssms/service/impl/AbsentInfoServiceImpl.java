package org.ssms.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.ssms.entity.AbsentInfo;
import org.ssms.mapper.AbsentInfoMapper;
import org.ssms.mapper.DepartmentMapper;
import org.ssms.mapper.result.AbsentInfoCheck;
import org.ssms.service.IAbsentInfoService;
import org.ssms.web.param.AbsentInfoQueryParam;
import org.ssms.web.param.ApplyLeaveParam;
import org.ssms.web.param.CheckAbsentInfoParam;
import org.ssms.web.result.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    @Resource
    private DepartmentMapper departmentMapper;

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
            Page<AbsentInfo> absentInfoPage = this.selectPage(page, ew);

            for (int i = 0; i < absentInfoPage.getRecords().size(); i++) {
                AbsentInfo absentInfo = absentInfoPage.getRecords().get(i);
                if (Objects.equals(absentInfo.getAbsentState(), "std")) {
                    absentInfoPage.getRecords().get(i).setAbsentState("待部门审核");
                }
                if (Objects.equals(absentInfo.getAbsentState(), "d_pass")) {
                    absentInfoPage.getRecords().get(i).setAbsentState("部门通过");
                }
                if (Objects.equals(absentInfo.getAbsentState(), "d_reject")) {
                    absentInfoPage.getRecords().get(i).setAbsentState("部门打回");
                }
                if (Objects.equals(absentInfo.getAbsentState(), "dtp")) {
                    absentInfoPage.getRecords().get(i).setAbsentState("待人事处审核");
                }
                if (Objects.equals(absentInfo.getAbsentState(), "done")) {
                    absentInfoPage.getRecords().get(i).setAbsentState("已统计");
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
            page.setRecords(baseMapper.getAbsentInfoCheck(page, param.getStaffId(), "std"));
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

    @Override
    public BaseResponse updateAbsentInfo(CheckAbsentInfoParam param) {
        BaseResponse response = new BaseResponse();

        EntityWrapper<AbsentInfo> ew = new EntityWrapper<>();
        ew.where("staff_id={0}", param.getStaffId());
        ew.and("absent_start_time={0}", param.getBeginTime());

        try {
            AbsentInfo absentInfo = absentInfoMapper.selectList(ew).get(0);

            absentInfo.setAbsentState(param.getStatus());
            absentInfo.setAbsentCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
            update(absentInfo, ew);
        } catch (Exception e) {
            log.error("管理员修改考勤记录异常：", e);
            response.setCode("1");
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @Override
    public BaseResponse<StaffAbsentInfoResult> staffAbsentInfoList(AbsentInfoQueryParam param) {
        BaseResponse<StaffAbsentInfoResult> response = new BaseResponse<>();
        StaffAbsentInfoResult staffAbsentInfoResult = new StaffAbsentInfoResult();
        response.setData(staffAbsentInfoResult);

        Page<String> page = new Page();
        page.setCurrent(param.getCurrentPage());
        page.setSize(param.getPageSize());

        try {
            List<String> staffIds = baseMapper.getStaffAbsentInfoPage(page, param.getStaffId(), param.getSearchCondition(),
                    param.getId(), param.getTime(), param.getState());//自定义SQL多表查询，获得分页信息
            page.setRecords(staffIds);
            staffAbsentInfoResult.setCurrentPage(page.getCurrent());
            staffAbsentInfoResult.setTotal(page.getTotal());

            page = new Page<>();
            page.setSize(9999);
            page.setCurrent(1);
            String temp = param.getStaffId();
            if (null == temp) {
                temp = param.getId();
            }
            List<AbsentInfoCheck> absentInfoChecks = baseMapper.getAbsentInfoCheck(page, temp, param.getState());

            List<StaffAbsentInfoDetail> staffAbsentInfoDetails = new ArrayList<>();
            staffAbsentInfoResult.setStaffAbsentInfoDetails(staffAbsentInfoDetails);
            for (String staffId : staffIds) {
                StaffAbsentInfoDetail staffAbsentInfoDetail = new StaffAbsentInfoDetail();
                staffAbsentInfoDetail.setStaffId(staffId);  //实例化员工请假详情对象
                staffAbsentInfoDetails.add(staffAbsentInfoDetail);
                staffAbsentInfoDetail.setAbsences(new ArrayList<>(5));
                staffAbsentInfoDetail.setAbsentDays(0);
                BigDecimal totalAbsentMoney = new BigDecimal(0);
                for (AbsentInfoCheck absentInfoCheck : absentInfoChecks) {
                    if (absentInfoCheck.getStaffId().equals(staffId)) {
                        staffAbsentInfoDetail.setStaffName(absentInfoCheck.getStaffName());
                        staffAbsentInfoDetail.setAbsentCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM"));
                        staffAbsentInfoDetail.setAbsentDays(staffAbsentInfoDetail.getAbsentDays() + absentInfoCheck.getAbsentDays());
                        totalAbsentMoney = totalAbsentMoney.add(new BigDecimal(absentInfoCheck.getAbsentMoney()));
                        Absence absence = new Absence();
                        staffAbsentInfoDetail.getAbsences().add(absence);
                        absence.setAbsentDays(absentInfoCheck.getAbsentDays());
                        absence.setAbsentEndTime(absentInfoCheck.getAbsentEndTime());
                        absence.setAbsentStartTime(absentInfoCheck.getAbsentStartTime());
                        absence.setAbsentReason(absentInfoCheck.getAbsentReason());
                        absence.setMoney(absentInfoCheck.getAbsentMoney());
                    }
                }
                staffAbsentInfoDetail.setShouldDays(21.75f);
                staffAbsentInfoDetail.setRealDays(new BigDecimal(21.75).subtract(new BigDecimal(staffAbsentInfoDetail.getAbsentDays())).floatValue());
                staffAbsentInfoDetail.setAbsentTotalMoney(totalAbsentMoney.floatValue());
            }

        } catch (Exception e) {
            log.error("获取管理员待审批考勤记录业务异常：", e);
            response.setCode("1");
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @Override
    public BaseResponse sendAbsentInfoToHr(String staffId) {
        BaseResponse response = new BaseResponse();

        try {
            baseMapper.updateStatebatch(staffId);
        } catch (Exception e) {
            log.error("发送到人事处业务异常：", e);
            response.setCode("1");
            response.setMessage(e.getMessage());
        }

        return response;
    }

    @Override
    public BaseResponse<StaffAbsentInfoResult> hrCheckAbsentInfo(AbsentInfoQueryParam param) {
        BaseResponse<StaffAbsentInfoResult> response = new BaseResponse<>();
        StaffAbsentInfoResult staffAbsentInfoResult = new StaffAbsentInfoResult();
        response.setData(staffAbsentInfoResult);

        Page<String> page = new Page();
        page.setCurrent(param.getCurrentPage());
        page.setSize(param.getPageSize());

        try {
            if (StringUtils.isEmpty(param.getSearchCondition())) {
                param.setSearchCondition(null);
            }
            List<String> staffIds = baseMapper.getStaffAbsentInfoPageByDep(page, param.getDepartmentId(), param.getSearchCondition());//自定义SQL多表查询，获得分页信息
            page.setRecords(staffIds);
            staffAbsentInfoResult.setCurrentPage(page.getCurrent());
            staffAbsentInfoResult.setTotal(page.getTotal());

            page = new Page<>();
            page.setSize(9999);
            page.setCurrent(1);
            List<AbsentInfoCheck> absentInfoChecks = baseMapper.getAbsentInfoCheckByDep(page, param.getDepartmentId());

            List<StaffAbsentInfoDetail> staffAbsentInfoDetails = new ArrayList<>();
            staffAbsentInfoResult.setStaffAbsentInfoDetails(staffAbsentInfoDetails);
            for (String staffId : staffIds) {
                StaffAbsentInfoDetail staffAbsentInfoDetail = new StaffAbsentInfoDetail();
                staffAbsentInfoDetail.setStaffId(staffId);  //实例化员工请假详情对象
                staffAbsentInfoDetails.add(staffAbsentInfoDetail);
                staffAbsentInfoDetail.setAbsences(new ArrayList<Absence>(5));
                staffAbsentInfoDetail.setAbsentDays(0);
                staffAbsentInfoDetail.setDepartment(departmentMapper.selectById(param.getDepartmentId()).getDepartmentName());

                for (AbsentInfoCheck absentInfoCheck : absentInfoChecks) {
                    if (absentInfoCheck.getStaffId().equals(staffId)) {
                        staffAbsentInfoDetail.setStaffName(absentInfoCheck.getStaffName());
                        staffAbsentInfoDetail.setAbsentCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM"));
                        staffAbsentInfoDetail.setAbsentDays(staffAbsentInfoDetail.getAbsentDays() + absentInfoCheck.getAbsentDays());
                        Absence absence = new Absence();
                        absence.setAbsentDays(absentInfoCheck.getAbsentDays());
                        absence.setAbsentEndTime(absentInfoCheck.getAbsentEndTime());
                        absence.setAbsentStartTime(absentInfoCheck.getAbsentStartTime());
                        absence.setAbsentReason(absentInfoCheck.getAbsentReason());
                        staffAbsentInfoDetail.getAbsences().add(absence);
                    }
                }
            }

        } catch (Exception e) {
            log.error("人事处获取待计算考勤记录业务异常：", e);
            response.setCode("1");
            response.setMessage(e.getMessage());
        }

        return response;
    }


}
