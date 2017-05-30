package org.ssms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TaxSetting;
import org.ssms.mapper.TaxSettingMapper;
import org.ssms.service.ITaxSettingService;
import org.ssms.web.result.BaseResponse;

import java.util.List;

/**
 * <p>
 * 扣税规则表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@Service
public class TaxSettingServiceImpl extends ServiceImpl<TaxSettingMapper, TaxSetting> implements ITaxSettingService {

    @Override
    public BaseResponse<List<TaxSetting>> list() {
        BaseResponse response = new BaseResponse();
        List<TaxSetting> data = baseMapper.selectList(new EntityWrapper<>());
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
