package org.ssms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.InsuranceSetting;
import org.ssms.entity.TaxSetting;
import org.ssms.mapper.InsuranceSettingMapper;
import org.ssms.service.IInsuranceSettingService;
import org.ssms.web.result.BaseResponse;

import java.util.List;

/**
 * <p>
 * 五险一金扣款规则表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@Service
public class InsuranceSettingServiceImpl extends ServiceImpl<InsuranceSettingMapper, InsuranceSetting> implements IInsuranceSettingService {

    @Override
    public BaseResponse<List<InsuranceSetting>> list() {
        BaseResponse response = new BaseResponse();
        List<InsuranceSetting> data = baseMapper.selectList(new EntityWrapper<>());
        data.stream().forEach(taxSetting -> {
            String status = "已启用";
            if (taxSetting.getStatus().equals("disable")) {
                status = "未启用";
            }
            taxSetting.setStatus(status);
        });

        response.setData(data);

        return response;
    }
}
