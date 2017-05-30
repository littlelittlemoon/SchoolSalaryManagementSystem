package org.ssms.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.ssms.entity.*;
import org.ssms.entity.viewentity.StaffInfoView;
import org.ssms.mapper.*;
import org.ssms.service.IStaffInfoService;
import org.ssms.utils.UUIDGenerator;
import org.ssms.web.param.StaffInfoAddParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;
import org.ssms.web.result.StaffInfoResult;

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
@Slf4j
public class StaffInfoServiceImpl extends ServiceImpl<StaffInfoMapper, StaffInfo> implements IStaffInfoService {
    @Resource
    private StaffInfoMapper staffInfoMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private DutyMapper dutyMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private TitleMapper titleMapper;

    @Override
    public BaseResponse<String> verifyUser(String username, String password) {
        BaseResponse<String> response = new BaseResponse();

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
        response.setData(staffInfo.getStaffId());

        return response;
    }

    @Override
    public BaseResponse addStaff(StaffInfoAddParam param) {
        BaseResponse response = new BaseResponse();

        StaffInfo staffInfo = new StaffInfo();
        BeanUtils.copyProperties(param, staffInfo);
        staffInfo.setStaffId(UUIDGenerator.generatorId());
        staffInfo.setStaffEntryTime(param.getStaffEntryTime());

        try {
            insert(staffInfo);
            response.setMessage("添加员工成功");
        } catch (Exception e) {
            response.setMessage("添加员工失败");
            response.setCode("1");
            log.error("添加员工失败：{}", e);
        }

        return response;
    }

    @Override
    public BaseResponse<StaffInfoResult> staffList(StaffQueryParam param) {
        BaseResponse<StaffInfoResult> response = new BaseResponse<>();
        StaffInfoResult staffInfoResult = new StaffInfoResult();
        response.setData(staffInfoResult);

        Page<StaffInfoView> page = new Page<>();
        page.setCurrent(param.getCurrentPage());
        page.setSize(param.getPageSize());

        try {
            page.setRecords(staffInfoMapper.selectStaffView(page, param));   //mybatis-plus自动分页
            staffInfoResult.setStaffInfoViews(page.getRecords());
            staffInfoResult.setTotal(page.getTotal());
            staffInfoResult.setCurrentPage(page.getCurrent());
        } catch (Exception e) {
            response.setCode("1");
            response.setMessage("查询出错");
            log.error("查询出错：{}", e);
        }

        return response;
    }

    @Override
    public BaseResponse<StaffInfoView> getStaff(String staffId) {
        BaseResponse<StaffInfoView> response = new BaseResponse<>();
        StaffQueryParam param = new StaffQueryParam();
        param.setStaffInfoSearch(staffId);
        StaffInfoView staffInfo = staffInfoMapper.selectStaffView(new Page<>(), param).get(0);
        response.setData(staffInfo);

        return response;
    }

    @Override
    public BaseResponse changePwd(String staffId, String oldPwd, String newPwd) {
        BaseResponse response = new BaseResponse();

        StaffInfo staffInfo = staffInfoMapper.selectById(staffId);
        if (!staffInfo.getStaffPassWord().equals(oldPwd)) {
            response.setCode("1");
            response.setMessage("旧密码输入错误");

            return response;
        }
        staffInfo.setStaffPassWord(newPwd);
        staffInfoMapper.updateById(staffInfo);

        return response;
    }

    @Override
    public BaseResponse updateStaffInfo(StaffInfo staffInfo) {
        BaseResponse response = new BaseResponse();
        EntityWrapper<Title> ew = new EntityWrapper<>();
        ew.where("title_name={0}", staffInfo.getTitleId());
        Title title = titleMapper.selectList(ew).get(0);
        staffInfo.setTitleId(title.getTitleId());

        EntityWrapper<Role> ew1 = new EntityWrapper<>();
        ew1.where("role_name={0}", staffInfo.getRoleId());
        Role role = roleMapper.selectList(ew1).get(0);
        staffInfo.setRoleId(role.getRoleId());

        EntityWrapper<Duty> ew2 = new EntityWrapper<>();
        ew2.where("duty_name={0}", staffInfo.getDutyId());
        Duty duty = dutyMapper.selectList(ew2).get(0);
        staffInfo.setDutyId(duty.getDutyId());

        EntityWrapper<Department> ew3 = new EntityWrapper<>();
        ew3.where("department_name={0}", staffInfo.getDepartmentId());
        Department department = departmentMapper.selectList(ew3).get(0);
        staffInfo.setDepartmentId(department.getDepartmentId());

        staffInfo.setStaffPassWord(selectById(staffInfo.getStaffId()).getStaffPassWord());

        updateById(staffInfo);

        return response;
    }

}
