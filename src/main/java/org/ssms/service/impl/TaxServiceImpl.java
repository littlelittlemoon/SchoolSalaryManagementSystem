package org.ssms.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ssms.entity.Tax;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.mapper.TaxMapper;
import org.ssms.service.ITaxService;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.param.TaxQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public BaseResponse countTaxMoney(List<String> staffIds) {
        BaseResponse response = new BaseResponse();
        try {
            for (String staffId : staffIds) {
                //查询视图中的信息，为了算缴纳基数
                StaffQueryParam staffQueryParam = new StaffQueryParam();
                staffQueryParam.setStaffInfoSearch(staffId);
                StaffInfoView staffInfoView = staffInfoMapper.selectStaffView(staffQueryParam).get(0);//调用模糊搜索的方法
            }
        } catch (Exception e) {
            log.error("", e);
            response.setMessage("计算交税失败");
        }

        return response;
    }

    @Override
    public BaseResponse taxMoneyResult(TaxQueryParam param) {
        return null;
    }
}
