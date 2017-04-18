package org.ssms.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.ssms.entity.StaffInfo;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.service.IStaffInfoService;
import org.ssms.web.param.StaffInfoAddParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author TanKaiYue
 * @since 2017-04-16
 */
@Service
@Slf4j
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoMapper, StaffInfo> implements IStaffInfoService {
    @Resource
    private StaffInfoMapper staffInfoMapper;

    @Override
    public BaseResponse verifyUser(String username, String password) {
        BaseResponse response = new BaseResponse();

        EntityWrapper<StaffInfo> ew = new EntityWrapper<>();
        ew.where("staff_tel={0}", username);

        List<StaffInfo> staffInfos = staffInfoMapper.selectList(ew);
        if (staffInfos == null || staffInfos.isEmpty()) {
            response.setCode("1");
            response.setMessage("用户名不存在");

            return response;
        }
        StaffInfo staffInfo = staffInfos.get(0);
        if (!staffInfo.getStaffPassWord().equals(password)) {
            response.setCode("1");
            response.setMessage("密码错误");

            return response;
        }
        response.setMessage("登录成功");

        return response;
    }

    @Override
    public BaseResponse addStaff(StaffInfoAddParam param) {
        BaseResponse response = new BaseResponse();

        StaffInfo staffInfo = new StaffInfo();
        BeanUtils.copyProperties(param, staffInfo);
        staffInfo.setStaffId(UUID.randomUUID().toString());

        try {
            insert(staffInfo);
            response.setMessage("添加员工成功");
        } catch (Exception e) {
            response.setMessage("添加员工失败");
            response.setCode("1");
        }

        return response;
    }

    @Override
    public BaseResponse<List<StaffInfoView>> staffList(StaffQueryParam param) {
        BaseResponse<List<StaffInfoView>> response = new BaseResponse<>();

        Page<StaffInfoView> page = new Page<>();
        page.setCurrent(page.getCurrent());
        page.setSize(param.getPageSize());

        try {
            page.setRecords(staffInfoMapper.selectStaffView(param));   //mybatis-plus自动分页
            response.setData(page.getRecords());
        } catch (Exception e) {
            response.setCode("1");
            response.setMessage("查询出错");
            log.error("查询出错：", e);
        }

        return response;
    }

}
