package org.ssms.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssms.entity.Insurance;
import org.ssms.entity.Tax;
import org.ssms.entity.ToBank;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.*;
import org.ssms.mapper.result.HrAbsentMoney;
import org.ssms.service.IInsuranceService;
import org.ssms.service.IToBankService;
import org.ssms.utils.MoneyUtils;
import org.ssms.web.param.SalaryQueryParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.HistorySalaryResult;
import org.ssms.web.result.SalaryDetail;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 银行发放表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class ToBankServiceImpl extends ServiceImpl<ToBankMapper, ToBank> implements IToBankService {
    @Resource
    private StaffInfoMapper staffInfoMapper;
    @Resource
    private AbsentMoneyMapper absentMoneyMapper;
    @Resource
    private TaxMapper taxMapper;
    @Resource
    private InsuranceMapper insuranceMapper;
    @Resource
    private IInsuranceService insuranceService;

    @Override
    public BaseResponse<List<SalaryDetail>> checkSalaryList(SalaryQueryParam param) {
        BaseResponse<List<SalaryDetail>> response = new BaseResponse();
        List<SalaryDetail> salaryDetails = new ArrayList<>();
        response.setData(salaryDetails);

        Page page = new Page();
        page.setSize(99999);
        page.setCurrent(1);

        List<HrAbsentMoney> hrAbsentMoneyList = absentMoneyMapper.getAbsentMoney(page, param.getDepartmentId(),
                param.getSearchCondition(), param.getTime(), 0);//查询获取部门那些信息

        for (HrAbsentMoney absentMoney : hrAbsentMoneyList) {
            SalaryDetail salaryDetail = new SalaryDetail();
            salaryDetail.setAbsentMoney(Float.parseFloat(absentMoney.getMoney()));
            salaryDetail.setStaffId(absentMoney.getStaffId());
            salaryDetail.setStaffName(absentMoney.getStaffName());
            salaryDetail.setDepartmentName(absentMoney.getDepartmentName());

            EntityWrapper<Tax> ew = new EntityWrapper<>();
            ew.where("staff_id={0}", absentMoney.getStaffId());
            ew.like("check_time", DateFormatUtils.format(new Date(), "yyyy-MM-dd").substring(0, 7));
            Tax tax = taxMapper.selectList(ew).get(0);
            if (tax == null || (!tax.getTaxState().equals("p_done") && !tax.getTaxState().equals("f_pass"))) {
                continue;
            }
            salaryDetail.setTaxMoney(tax.getTaxTaxMoney());
            if (tax.getTaxState().equals("p_done")) {
                salaryDetail.setStatus("ntb");
            } else {
                salaryDetail.setStatus("atb");
            }
            salaryDetail.setCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd").substring(0, 7));

            Insurance insurance = insuranceService.getInsurance(absentMoney.getStaffId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
            if (insurance == null || (!insurance.getInsuranceState().equals("ptf") && !insurance.getInsuranceState().equals("f_pass"))) {
                continue;
            }
            salaryDetail.setInsuranceTotal(insurance.getInsuranceTotal());

            StaffQueryParam staffQueryParam = new StaffQueryParam();
            staffQueryParam.setStaffInfoSearch(absentMoney.getStaffId());
            StaffInfoView staffInfoView = staffInfoMapper.selectStaffView(new Page<>(), staffQueryParam).get(0);//调用模糊搜索的方法
            salaryDetail.setBaseSalary(Float.parseFloat(staffInfoView.getTitleBaseSalary()));
            salaryDetail.setDutySalary(Float.parseFloat(staffInfoView.getDutySalary()));
            salaryDetail.setTitleSalary(Float.parseFloat(staffInfoView.getTitleSalary()));
            salaryDetail.setBankAcount(staffInfoView.getStaffBankAcount());
            salaryDetail.setStaffTel(staffInfoView.getStaffTel());
            salaryDetail.setIdentityNum(staffInfoView.getStaffIdentityNum());

            Map<String, BigDecimal> map = MoneyUtils.countShouldRealPay(staffInfoView, tax, insurance, absentMoney);
            salaryDetail.setRealPay(map.get("realPay").floatValue());
            salaryDetail.setShouldPay(map.get("shouldPay").floatValue());

            salaryDetails.add(salaryDetail);
        }

        return response;
    }

    @Transactional
    @Override
    public BaseResponse sendToBank(SalaryQueryParam param) {
        BaseResponse response = new BaseResponse();

        taxMapper.sendToBank(param.getDepartmentId(), "p_done", "f_pass", "p_done");
        insuranceMapper.sendToBank(param.getDepartmentId(), "ptf", "f_pass", "ptf");
        absentMoneyMapper.sendToBank(param.getDepartmentId(), "ptf", "f_pass", "ptf");

        return response;
    }

    @Transactional
    @Override
    public BaseResponse sendToDepartment(SalaryQueryParam param) {
        BaseResponse response = new BaseResponse();

        taxMapper.sendToBank(param.getDepartmentId(), "f_pass", "done", "f_pass");
        insuranceMapper.sendToBank(param.getDepartmentId(), "f_pass", "done", "f_pass");
        absentMoneyMapper.sendToBank(param.getDepartmentId(), "f_pass", "done", "f_pass");

        return response;
    }

    @Override
    public BaseResponse<HistorySalaryResult> historySalaryList(SalaryQueryParam param) {
        BaseResponse<HistorySalaryResult> response = new BaseResponse();
        HistorySalaryResult historySalaryResult = new HistorySalaryResult();
        List<SalaryDetail> salaryDetails = new ArrayList<>();
        historySalaryResult.setSalaryDetails(salaryDetails);
        response.setData(historySalaryResult);

        Page<HrAbsentMoney> page = new Page();
        page.setCurrent(param.getCurrentPage());
        page.setSize(param.getPageSize());
        List<HrAbsentMoney> hrAbsentMoneyList = absentMoneyMapper.getAbsentMoney(page, param.getDepartmentId(),
                param.getSearchCondition(), param.getTime(), 1);
        page.setRecords(hrAbsentMoneyList);
        historySalaryResult.setTotal(page.getTotal());
        historySalaryResult.setCurrentPage(page.getCurrent());

        for (HrAbsentMoney absentMoney : page.getRecords()) {
            SalaryDetail salaryDetail = new SalaryDetail();
            salaryDetail.setAbsentMoney(Float.parseFloat(absentMoney.getMoney()));
            salaryDetail.setStaffId(absentMoney.getStaffId());
            salaryDetail.setStaffName(absentMoney.getStaffName());
            salaryDetail.setDepartmentName(absentMoney.getDepartmentName());

            EntityWrapper<Tax> ew = new EntityWrapper<>();
            ew.where("staff_id={0}", absentMoney.getStaffId());
            ew.like("check_time", DateFormatUtils.format(new Date(), "yyyy-MM-dd").substring(0, 7));
            Tax tax = taxMapper.selectList(ew).get(0);
            if (tax == null || (!tax.getTaxState().equals("done"))) {
                continue;
            }
            salaryDetail.setTaxMoney(tax.getTaxTaxMoney());
//            if (tax.getTaxState().equals("p_done")) {
//                salaryDetail.setStatus("ntb");
//            } else {
//                salaryDetail.setStatus("atb");
//            }
            salaryDetail.setCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd").substring(0, 7));

            Insurance insurance = insuranceService.getInsurance(absentMoney.getStaffId(), DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
            if (insurance == null || (!insurance.getInsuranceState().equals("done"))) {
                continue;
            }
            salaryDetail.setInsuranceTotal(insurance.getInsuranceTotal());

            StaffQueryParam staffQueryParam = new StaffQueryParam();
            staffQueryParam.setStaffInfoSearch(absentMoney.getStaffId());
            StaffInfoView staffInfoView = staffInfoMapper.selectStaffView(new Page<>(), staffQueryParam).get(0);//调用模糊搜索的方法
            salaryDetail.setBaseSalary(Float.parseFloat(staffInfoView.getTitleBaseSalary()));
            salaryDetail.setDutySalary(Float.parseFloat(staffInfoView.getDutySalary()));
            salaryDetail.setTitleSalary(Float.parseFloat(staffInfoView.getTitleSalary()));
            salaryDetail.setBankAcount(staffInfoView.getStaffBankAcount());
            salaryDetail.setStaffTel(staffInfoView.getStaffTel());
            salaryDetail.setIdentityNum(staffInfoView.getStaffIdentityNum());
            salaryDetail.setDutyName(staffInfoView.getDutyName());
            salaryDetail.setTitleName(staffInfoView.getTitleName());

            Map<String, BigDecimal> map = MoneyUtils.countShouldRealPay(staffInfoView, tax, insurance, absentMoney);
            salaryDetail.setRealPay(map.get("realPay").floatValue());
            salaryDetail.setShouldPay(map.get("shouldPay").floatValue());

            salaryDetails.add(salaryDetail);
        }

        return response;
    }

}
