package org.ssms.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.ssms.entity.StaffInfo;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.service.IStaffInfoService;
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
public class IStaffInfoServiceImpl extends ServiceImpl<StaffInfoMapper, StaffInfo> implements IStaffInfoService {
    @Resource
    private StaffInfoMapper staffInfoMapper;

    @Override
    public BaseResponse verifyUser(String username, String password) {
        BaseResponse response = new BaseResponse();

        EntityWrapper<StaffInfo> ew = new EntityWrapper<>();
        ew.where("staff_tel={0}", username);

        List<StaffInfo> tStaffInfos = staffInfoMapper.selectList(ew);
        if (tStaffInfos == null || tStaffInfos.isEmpty()) {
            response.setCode("1");
            response.setMessage("用户名不存在");

            return response;
        }
        StaffInfo staffInfo = tStaffInfos.get(0);
        if (!staffInfo.getStaffPassWord().equals(password)) {
            response.setCode("1");
            response.setMessage("密码错误");

            return response;
        }
        response.setMessage("登录成功");

        return response;
    }
}
