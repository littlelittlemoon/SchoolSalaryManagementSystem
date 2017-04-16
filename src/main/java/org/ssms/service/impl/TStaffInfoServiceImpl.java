package org.ssms.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.TStaffInfo;
import org.ssms.mapper.TStaffInfoMapper;
import org.ssms.service.ITStaffInfoService;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
public class TStaffInfoServiceImpl extends ServiceImpl<TStaffInfoMapper, TStaffInfo> implements ITStaffInfoService {
    @Resource
    private TStaffInfoMapper tStaffInfoMapper;

    @Override
    public BaseResponse verifyUser(String username, String password) {
        BaseResponse response = new BaseResponse();

        EntityWrapper<TStaffInfo> ew = new EntityWrapper<>();
        ew.where("Sta_Tel={0}", username);

        List<TStaffInfo> tStaffInfos = tStaffInfoMapper.selectList(ew);
        if (tStaffInfos == null || tStaffInfos.isEmpty()) {
            response.setCode("1");
            response.setMessage("用户名不存在");

            return response;
        }
        TStaffInfo staffInfo = tStaffInfos.get(0);
        if (!staffInfo.getSta_Pass_Word().equals(password)) {
            response.setCode("1");
            response.setMessage("密码错误");

            return response;
        }
        response.setMessage("登录成功");

        return response;
    }
}
