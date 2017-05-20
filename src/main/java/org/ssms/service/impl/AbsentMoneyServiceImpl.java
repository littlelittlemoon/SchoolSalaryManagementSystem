package org.ssms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssms.entity.AbsentInfo;
import org.ssms.entity.AbsentMoney;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.AbsentInfoMapper;
import org.ssms.mapper.AbsentMoneyMapper;
import org.ssms.mapper.DutyMapper;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.mapper.result.HrAbsentInfo;
import org.ssms.mapper.result.HrAbsentMoney;
import org.ssms.service.IAbsentMoneyService;
import org.ssms.utils.MoneyUtils;
import org.ssms.web.param.AbsentMoneyQueryParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.HrAbsentInfoResult;
import org.ssms.web.result.HrAbsentMoneyResult;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 考勤扣款表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class AbsentMoneyServiceImpl extends ServiceImpl<AbsentMoneyMapper, AbsentMoney> implements IAbsentMoneyService {
    @Resource
    private AbsentInfoMapper absentInfoMapper;
    @Resource
    private DutyMapper dutyMapper;
    @Resource
    private StaffInfoMapper staffInfoMapper;

    @Override
    public BaseResponse countAbsentMoney(List<String> staffIds) {
        BaseResponse response = new BaseResponse();

        for (String id : staffIds) {
            EntityWrapper<AbsentInfo> ew = new EntityWrapper<>();
            ew.where("staff_id={0}", id);
            ew.and("absent_state={0}", "dtp");
            ew.and("date_format(absent_check_time,'%Y-%m')=date_format(now(),'%Y-%m')");
            List<AbsentInfo> absentInfos = absentInfoMapper.selectList(ew);
            StaffQueryParam staffQueryParam = new StaffQueryParam();
            staffQueryParam.setStaffInfoSearch(id);
            List<StaffInfoView> staffInfoViews = staffInfoMapper.selectStaffView(staffQueryParam);//调用模糊搜索的方法

            int actualDay = absentInfos.stream().mapToInt(a -> a.getAbsentDays()).sum();
            AbsentMoney absentMoney = new AbsentMoney();
            absentMoney.setAbsentMoneyState("p_pass");
            absentMoney.setActualDays(21 - actualDay);
            absentMoney.setCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
            absentMoney.setDueDays(21);
            absentMoney.setStaffId(id);
            StaffInfoView staffInfoView = staffInfoViews.get(0);
            BigDecimal totalAbsentMoney = new BigDecimal(0);
            for (AbsentInfo absentInfo : absentInfos) {
                BigDecimal temp = MoneyUtils.countAbsentMoneyDetail(absentInfo.getAbsentReason(),
                        absentInfo, staffInfoView);
                absentInfo.setAbsentMoney(temp.doubleValue());
                totalAbsentMoney = totalAbsentMoney.add(temp);
            }
            absentMoney.setMoney(totalAbsentMoney.doubleValue());
            boolean res = insert(absentMoney);
            if (res) {
                for (AbsentInfo absentInfo : absentInfos) {
                    absentInfo.setAbsentState("done");
                    EntityWrapper<AbsentInfo> entityWrapper = new EntityWrapper();
                    entityWrapper.where("staff_id={0}", absentInfo.getStaffId());
                    entityWrapper.and("absent_start_time={0}", absentInfo.getAbsentStartTime());
                    absentInfoMapper.update(absentInfo, entityWrapper);
                }
            }
        }

        return response;
    }

    @Override
    /**
     * hr获取以计算缺勤金信息
     */
    public BaseResponse<HrAbsentInfoResult> getAbsentInfoResult(AbsentMoneyQueryParam param) {
        BaseResponse<HrAbsentInfoResult> response = new BaseResponse<>();
        HrAbsentInfoResult result = new HrAbsentInfoResult();
        response.setData(result);

        Page<HrAbsentInfo> page = new Page();
        page.setCurrent(page.getCurrent());
        page.setSize(param.getPageSize());

        List<HrAbsentInfo> hrAbsentInfos = baseMapper.getHrAbsentInfo(page, param.getSearchCondition());
        page.setRecords(hrAbsentInfos);
        result.setHrAbsentInfos(hrAbsentInfos);
        result.setCurrentPage(page.getCurrent());
        result.setTotal(page.getTotal());

        for (HrAbsentInfo hrAbsentInfo : hrAbsentInfos) {
            EntityWrapper<AbsentInfo> ew = new EntityWrapper<>();
            ew.where("staff_id={0}", hrAbsentInfo.getStaffId());
            ew.and("absent_state={0}", "dtp");
            ew.and("date_format(absent_check_time,'%Y-%m')=date_format(now(),'%Y-%m')");
            List<AbsentInfo> absentInfos = absentInfoMapper.selectList(ew);
            hrAbsentInfo.setAbsentInfos(absentInfos);
        }

        return response;
    }

    @Override
    public BaseResponse<HrAbsentMoneyResult> getAbsentMoneyResult(AbsentMoneyQueryParam param) {
        BaseResponse<HrAbsentMoneyResult> response = new BaseResponse<>();
        HrAbsentMoneyResult result = new HrAbsentMoneyResult();
        response.setData(result);

        Page<HrAbsentMoney> page = new Page();
        page.setCurrent(param.getCurrentPage());
        page.setSize(param.getPageSize());

        List<HrAbsentMoney> hrAbsentMoneyList = baseMapper.getHrAbsentMoney(page, param.getSearchCondition(),param.getDepartmentId(),"p_pass");
        page.setRecords(hrAbsentMoneyList);
        result.setHrAbsentMoneyList(hrAbsentMoneyList);
        result.setCurrentPage(page.getCurrent());
        result.setTotal(page.getTotal());

        for (HrAbsentMoney hrAbsentMoney : hrAbsentMoneyList) {
            EntityWrapper<AbsentInfo> ew = new EntityWrapper<>();
            ew.where("staff_id={0}", hrAbsentMoney.getStaffId());
            ew.and("absent_state={0}", "done");
            ew.and("date_format(absent_check_time,'%Y-%m')=date_format(now(),'%Y-%m')");
            List<AbsentInfo> absentInfos = absentInfoMapper.selectList(ew);
            hrAbsentMoney.setAbsentMoneyList(absentInfos);
        }

        return response;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse updateAbsentInfo(String staffId, String startTime, Double money) {
        BaseResponse response = new BaseResponse();
        EntityWrapper<AbsentInfo> ew = new EntityWrapper<>();
        ew.where("staff_id={0}", staffId);
        ew.and("absent_start_time={0}", startTime);
        AbsentInfo absentInfo = absentInfoMapper.selectList(ew).get(0);
        if (absentInfo == null) {
            response.setMessage("找不到缺勤信息");
            return response;
        }
        absentInfo.setAbsentMoney(money);
        absentInfoMapper.update(absentInfo, ew);

        EntityWrapper<AbsentMoney> entityWrapper = new EntityWrapper<>();
        entityWrapper.where("staff_id={0}", staffId);
        entityWrapper.like("check_time", startTime.substring(0, 7));
        AbsentMoney absentMoney = this.selectList(entityWrapper).get(0);
        entityWrapper = new EntityWrapper<>();
        entityWrapper.where("staff_id={0}", staffId);
        entityWrapper.and("check_time={0}", absentMoney.getCheckTime());
        BigDecimal temp = new BigDecimal(absentMoney.getMoney()).subtract(new BigDecimal(money));
        absentMoney.setMoney(new BigDecimal(absentMoney.getMoney()).subtract(temp).doubleValue());
        this.update(absentMoney, entityWrapper);

        return response;
    }

}
