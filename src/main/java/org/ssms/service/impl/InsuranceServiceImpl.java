package org.ssms.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssms.entity.AbsentMoney;
import org.ssms.entity.Insurance;
import org.ssms.entity.InsuranceSetting;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.AbsentMoneyMapper;
import org.ssms.mapper.InsuranceMapper;
import org.ssms.mapper.InsuranceSettingMapper;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.mapper.result.HrAbsentMoney;
import org.ssms.service.IAbsentMoneyService;
import org.ssms.service.IInsuranceService;
import org.ssms.utils.MoneyUtils;
import org.ssms.web.param.InsuranceQueryParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.InsuranceInfo;
import org.ssms.web.result.InsuranceInfoResult;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 五险一金表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
@Slf4j
public class InsuranceServiceImpl extends ServiceImpl<InsuranceMapper, Insurance> implements IInsuranceService {
    @Resource
    private AbsentMoneyMapper absentMoneyMapper;
    @Resource
    private StaffInfoMapper staffInfoMapper;
    @Resource
    private IAbsentMoneyService absentMoneyService;
    @Resource
    private InsuranceSettingMapper insuranceSettingMapper;


    /**
     * 计算五险一金
     * @param staffIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse countInsuranceMoney(List<String> staffIds) {
        BaseResponse response = new BaseResponse();
        try {
            for (String staffId : staffIds) {
                //查询视图中的信息，为了算缴纳基数
                StaffQueryParam staffQueryParam = new StaffQueryParam();
                staffQueryParam.setStaffInfoSearch(staffId);
                StaffInfoView staffInfoView = staffInfoMapper.selectStaffView(new Page<>(), staffQueryParam).get(0);//调用模糊搜索的方法
                AbsentMoney absentMoney = absentMoneyService.getAbsentMoney(staffId, DateFormatUtils.format(new Date(), "yyyy-MM-dd"));

                EntityWrapper<InsuranceSetting> entityWrapper = new EntityWrapper<>();
                entityWrapper.where("status={0}", "enable");
                InsuranceSetting insuranceSetting = insuranceSettingMapper.selectList(entityWrapper).get(0);

                Map<String, BigDecimal> resultMap = MoneyUtils.countInsuranMoneyDetail(staffInfoView, absentMoney, insuranceSetting);
                Insurance insurance = new Insurance();
                insurance.setStaffId(staffId);
                insurance.setInsuranceTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
                insurance.setInsuranceState("p_pass");
                insurance.setInsuranceUnemp(resultMap.get("unemp").floatValue());
                insurance.setInsuranceAccu(resultMap.get("accu").floatValue());
                insurance.setInsuranceAged(resultMap.get("aged").floatValue());
                insurance.setInsuranceMedical(resultMap.get("medical").floatValue());
                insurance.setInsuranceTotal(resultMap.get("total").floatValue());
                insurance.setInsuranceBase(resultMap.get("base").floatValue());
                baseMapper.insert(insurance);

                absentMoney.setAbsentMoneyState("ptf");
                absentMoneyService.updateAbsentMoney(absentMoney);
            }
        } catch (Exception e) {
            log.error("", e);
            response.setMessage("计算五险一金异常");
        }

        return response;
    }

    /***
     * 获取五险一金计算结果
     * @param param
     * @return
     */
    @Override
    public BaseResponse<InsuranceInfoResult> insuranceInfoResult(InsuranceQueryParam param) {
        BaseResponse<InsuranceInfoResult> response = new BaseResponse<>();
        InsuranceInfoResult insuranceInfoResult = new InsuranceInfoResult();
        response.setData(insuranceInfoResult);

        /**
         * 分页
         */
        Page<HrAbsentMoney> page = new Page();
        page.setCurrent(param.getCurrentPage());
        page.setSize(param.getPageSize());
        List<HrAbsentMoney> hrAbsentMoneyList = absentMoneyMapper.getHrAbsentMoney(page, param.getSearchCondition(), param.getDepartmentId(), "ptf");//查询获取部门那些信息
        page.setRecords(hrAbsentMoneyList);

        List<InsuranceInfo> insuranceInfos = new ArrayList<>();

        /**
         * 调用之前的获取缺勤金信息的接口获取员工ID
         * 通过ID获取五险一金查询结果
         */
        for (HrAbsentMoney hrAbsentMoney : page.getRecords()) {
            EntityWrapper<Insurance> ew = new EntityWrapper<>();
            ew.where("staff_id={0}", hrAbsentMoney.getStaffId());
            ew.and("insurance_state={0}", "p_pass");
            ew.like("insurance_time", DateFormatUtils.format(new Date(), "yyyy-MM-dd").substring(0, 7));
            List<Insurance> insurances = this.selectList(ew);
            if (CollectionUtils.isEmpty(insurances)) {
                continue;
            }
            Insurance insurance = insurances.get(0);
            InsuranceInfo insuranceInfo = new InsuranceInfo();
            insuranceInfos.add(insuranceInfo);
            BeanUtils.copyProperties(hrAbsentMoney, insuranceInfo);
            BeanUtils.copyProperties(insurance, insuranceInfo);
            insuranceInfo.setCheckTime(insurance.getInsuranceTime());
        }
        insuranceInfoResult.setInsuranceInfoList(insuranceInfos);

        return response;
    }


    /**
     * 调整五险一金计算结果
     * @param staffId
     * @param startTime
     * @param medical
     * @param unemp
     * @param accu
     * @param aged
     * @return
     */
    @Override
    public BaseResponse updateInsuranMoney(String staffId, String startTime, Float medical, Float unemp, Float accu, Float aged) {
        BaseResponse response = new BaseResponse();

        Insurance insurance = getInsurance(staffId, startTime);
        insurance.setInsuranceMedical(medical);
        insurance.setInsuranceUnemp(unemp);
        insurance.setInsuranceAged(aged);
        insurance.setInsuranceAccu(accu);
        BigDecimal total = new BigDecimal(medical).add(new BigDecimal(unemp)).add(new BigDecimal(accu)).add(new BigDecimal(aged));
        insurance.setInsuranceTotal(total.floatValue());
        EntityWrapper<Insurance> ew = new EntityWrapper<>();
        ew.where("staff_id={0}", staffId);
        ew.and("insurance_time={0}", insurance.getInsuranceTime());
        baseMapper.update(insurance, ew);

        return response;
    }

    public Insurance getInsurance(String staffId, String time) {
        EntityWrapper<Insurance> ew = new EntityWrapper<>();
        ew.where("staff_id={0}", staffId);
        ew.like("insurance_time", time.substring(0, 7));
        List<Insurance> insurances = baseMapper.selectList(ew);

        return insurances.get(0);
    }
}
