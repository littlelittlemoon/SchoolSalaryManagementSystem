package org.ssms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.AbsenceSetting;
import org.ssms.mapper.AbsenceSettingMapper;
import org.ssms.service.IAbsenceSettingService;
import org.ssms.web.result.BaseResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 缺勤扣款规则表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-05-28
 */
@Service
public class AbsenceSettingServiceImpl extends ServiceImpl<AbsenceSettingMapper, AbsenceSetting> implements IAbsenceSettingService {

    @Override
    public BaseResponse<List<AbsenceSetting>> list() {
        BaseResponse response = new BaseResponse();
        List<AbsenceSetting> data = baseMapper.selectList(new EntityWrapper<>());
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

    @Override
    public BaseResponse<List<String>> getAbsentType() {
        BaseResponse response = new BaseResponse();

        EntityWrapper<AbsenceSetting> ew = new EntityWrapper<>();
        ew.where("status={0}", "enable");

        List<AbsenceSetting> absenceSettings = baseMapper.selectList(ew);

        response.setData(absenceSettings.stream().map(AbsenceSetting::getAbsentType).collect(Collectors.toList()));

        return response;
    }
}
