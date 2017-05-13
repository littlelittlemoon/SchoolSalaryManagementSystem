package org.ssms.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.ssms.mapper.AbsentInfoMapper;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.service.IAbsentInfoService;
import org.ssms.service.IStaffInfoService;
import org.ssms.web.param.AbsentInfoQueryParam;
import org.ssms.web.param.StaffInfoAddParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.text.ParseException;

@Slf4j
public class StaffInfoTest extends BaseTest {
    @Resource
    private StaffInfoMapper staffInfoMapper;
    @Resource
    private IStaffInfoService staffInfoService;
    @Resource
    private IAbsentInfoService absentInfoService;
    @Resource
    private AbsentInfoMapper absentInfoMapper;

    @Test
    public void testList() {
        AbsentInfoQueryParam param = new AbsentInfoQueryParam();
        param.setStaffId("11111");
        param.setCurrentPage(1);
        param.setPageSize(10);
        BaseResponse response = absentInfoService.staffAbsentInfoList(param);

        log.info("result：{}", JSON.toJSONString(response));
    }

    @Test
    public void testAdd() throws ParseException {
        StaffInfoAddParam param = new StaffInfoAddParam();
        param.setDepartmentId("Dep_atmosDep");
        param.setDutyId("Du_depHead");
        param.setTitleId("Tit_assistant");
        param.setStaffIdentityNum("45667833");
        param.setStaffBankAcount("2342342342");
        param.setStaffName("staff");
        param.setStaffSex("男");
        param.setStaffTel("w3242342");
        param.setStaffEntryTime("2017-04-01");
        param.setRoleId("R_depMana");

        BaseResponse response = staffInfoService.addStaff(param);
        log.info("result：{}", JSON.toJSONString(response));

    }
}


