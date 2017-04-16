package org.ssms.test;

import static com.jayway.restassured.RestAssured.given;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Equals;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import org.ssms.Application;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.matcher.ResponseAwareMatcher;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.ssms.entity.TStaffInfo;
import org.ssms.mapper.TStaffInfoMapper;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)   //1.
@SpringBootTest(classes = Application.class, webEnvironment=WebEnvironment.RANDOM_PORT )   // 2.SpringBoot入口类,配置起server随机端口
public class RestTest {
    @Resource
    private TStaffInfoMapper tStaffInfoMapper;

    @Test
    public void postTest(){

        EntityWrapper<TStaffInfo> ew = new EntityWrapper<>();
        ew.where("Sta_Tel={0}", "21341234124");

        List<TStaffInfo> tStaffInfos = tStaffInfoMapper.selectList(ew);
        System.out.println(tStaffInfos);
    }
}


