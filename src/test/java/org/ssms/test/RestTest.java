package org.ssms.test;

import static com.jayway.restassured.RestAssured.given;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.ssms.Application;
import org.ssms.mapper.StaffInfoMapper;
import org.ssms.service.IStaffInfoService;
import org.ssms.web.param.StaffQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)   //1.
@SpringBootTest(classes = Application.class, webEnvironment=WebEnvironment.RANDOM_PORT )   // 2.SpringBoot入口类,配置起server随机端口
public class RestTest {
    @Resource
    private StaffInfoMapper staffInfoMapper;
    @Resource
    private IStaffInfoService staffInfoService;

    @Test
    public void postTest(){
        StaffQueryParam param = new StaffQueryParam();
        param.setCurrentPage(1);
        param.setPageSize(3);
        param.setStaffInfoSearch("11111");
        BaseResponse response = staffInfoService.staffList(param);

        log.info("result：{}", JSON.toJSONString(response));
    }
}


