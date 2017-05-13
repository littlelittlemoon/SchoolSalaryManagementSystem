package org.ssms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.ssms.entity.AbsentInfo;
import org.ssms.entity.AbsentMoney;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.AbsentInfoMapper;
import org.ssms.mapper.AbsentMoneyMapper;
import org.ssms.mapper.DutyMapper;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.mapper.result.HrAbsentInfo;
import org.ssms.service.IAbsentMoneyService;
import org.ssms.utils.MoneyUtils;
import org.ssms.web.param.AbsentMoneyQueryParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.HrAbsentInfoResult;

import javax.annotation.Resource;
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
            List<StaffInfoView> staffInfoViews = staffInfoMapper.selectStaffView(staffQueryParam);

            int actualDay = absentInfos.stream().mapToInt(a -> a.getAbsentDays()).sum();
            AbsentMoney absentMoney = new AbsentMoney();
            absentMoney.setAbsentMoneyState("ptf");
            absentMoney.setActualDays(21 - actualDay);
            absentMoney.setCheckTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
            absentMoney.setDueDays(21);
            absentMoney.setStaffId(id);
            absentMoney.setMoney(MoneyUtils.countAbsentMoneyByStaff(absentInfos, staffInfoViews));
            boolean res = insert(absentMoney);
            if (!res) {
                response.setMessage("已经计算过");
                return response;
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
}
