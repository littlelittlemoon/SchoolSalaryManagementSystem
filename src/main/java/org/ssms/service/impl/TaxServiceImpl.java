package org.ssms.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.ssms.entity.AbsentMoney;
import org.ssms.entity.Insurance;
import org.ssms.entity.Tax;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.AbsentMoneyMapper;
import org.ssms.mapper.InsuranceMapper;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.mapper.TaxMapper;
import org.ssms.mapper.result.HrAbsentMoney;
import org.ssms.service.IAbsentMoneyService;
import org.ssms.service.IInsuranceService;
import org.ssms.service.ITaxService;
import org.ssms.utils.MoneyUtils;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.param.TaxQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.InsuranceInfo;
import org.ssms.web.result.TaxInfo;
import org.ssms.web.result.TaxInfoResult;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 纳税款表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
@Slf4j
public class TaxServiceImpl extends ServiceImpl<TaxMapper, Tax> implements ITaxService {
    @Resource
    private StaffInfoMapper staffInfoMapper;
    @Resource
    private IAbsentMoneyService absentMoneyService;
    @Resource
    private IInsuranceService insuranceService;
    @Resource
    private InsuranceMapper insuranceMapper;
    @Resource
    private AbsentMoneyMapper absentMoneyMapper;

    @Override
    public BaseResponse countTaxMoney(List<String> staffIds) {
        BaseResponse response = new BaseResponse();
        try {
            for (String staffId : staffIds) {
                //查询视图中的信息，为了算缴纳基数
                StaffQueryParam staffQueryParam = new StaffQueryParam();
                staffQueryParam.setStaffInfoSearch(staffId);
                StaffInfoView staffInfoView = staffInfoMapper.selectStaffView(staffQueryParam).get(0);//调用模糊搜索的方法
                AbsentMoney absentMoney = absentMoneyService.getAbsentMoney(staffId, DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
                Insurance insurance = insuranceService.getInsurance(staffId, DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
                Map<String, BigDecimal> map = MoneyUtils.countTaxMoneyDetail(staffInfoView, absentMoney, insurance);
                Tax tax = new Tax();
                tax.setStaffId(staffId);
                tax.setCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
                tax.setTaxCalcu(map.get("taxCaucl").floatValue());
                tax.setTaxRate(map.get("taxRate").floatValue());
                tax.setTaxTaxable(map.get("baseMoney").floatValue());
                tax.setTaxTaxMoney(map.get("tax").floatValue());
                tax.setTaxState("ptf");
                baseMapper.insert(tax);

                insurance.setInsuranceState("ptf");
                EntityWrapper<Insurance> ew = new EntityWrapper<>();
                ew.where("staff_id={0}", staffId);
                ew.and("insurance_time={0}", insurance.getInsuranceTime());
                insuranceMapper.update(insurance, ew);
            }
        } catch (Exception e) {
            log.error("", e);
            response.setMessage("计算交税失败");
        }

        return response;
    }

    @Override
    public BaseResponse<TaxInfoResult> taxMoneyResult(TaxQueryParam param) {
        BaseResponse<TaxInfoResult> response = new BaseResponse<>();
        TaxInfoResult taxInfoResult = new TaxInfoResult();
        response.setData(taxInfoResult);

        Page<HrAbsentMoney> page = new Page();
        page.setCurrent(param.getCurrentPage());
        page.setSize(param.getPageSize());
        List<HrAbsentMoney> hrAbsentMoneyList = absentMoneyMapper.getHrAbsentMoney(page, param.getSearchCondition(), param.getDepartmentId(), "ptf");//查询获取部门那些信息
        page.setRecords(hrAbsentMoneyList);

        List<TaxInfo> taxInfos = new ArrayList<>();
        for (HrAbsentMoney hrAbsentMoney : page.getRecords()) {
            EntityWrapper<Tax> ew = new EntityWrapper<>();
            ew.where("staff_id={0}", hrAbsentMoney.getStaffId());
            ew.and("tax_state={0}", "ptf");
            ew.like("check_time", DateFormatUtils.format(new Date(), "yyyy-MM-dd").substring(0, 7));
            List<Tax> taxes = this.selectList(ew);
            if (CollectionUtils.isEmpty(taxes)) {
                continue;
            }
            Tax tax = taxes.get(0);
            TaxInfo taxInfo = new TaxInfo();
            taxInfos.add(taxInfo);
            BeanUtils.copyProperties(hrAbsentMoney, taxInfo);
            BeanUtils.copyProperties(tax, taxInfo);
            taxInfo.setCheckTime(tax.getCheckTime());
        }
        taxInfoResult.setTaxInfoList(taxInfos);

        return response;
    }
}
