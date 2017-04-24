package org.ssms.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.service.IStaffInfoService;
import org.ssms.web.param.StaffInfoAddParam;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.text.ParseException;

@Slf4j
public class StaffInfoTest extends BaseTest {
    @Resource
    private StaffInfoMapper staffInfoMapper;
    @Resource
    private IStaffInfoService staffInfoService;

    @Test
    public void testList() {
        StaffQueryParam param = new StaffQueryParam();
        param.setCurrentPage(1);
        param.setPageSize(3);
        param.setStaffInfoSearch("11111");
        BaseResponse response = staffInfoService.staffList(param);

        log.info("result：{}", JSON.toJSONString(response));
    }

    @Test
    public void testAdd() throws ParseException {
        StaffInfoAddParam param = new StaffInfoAddParam();
        param.setDepartmentId("Dep_atmosDep");
        param.setDutyId("Du_depHead");
        param.setTitleId("Tit_assistant");
        param.setStaffIdentityNum("2324234");
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


