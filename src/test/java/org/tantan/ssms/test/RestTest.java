package org.tantan.ssms.test;

import static com.jayway.restassured.RestAssured.given;

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
import org.tantan.ssms.Application;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.matcher.ResponseAwareMatcher;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

@RunWith(SpringJUnit4ClassRunner.class)   //1.
@SpringBootTest(classes = Application.class, webEnvironment=WebEnvironment.RANDOM_PORT )   // 2.SpringBoot入口类,配置起server随机端口
public class RestTest {

	@Value("${local.server.port}")   //3
    int port;

    @Before
    public void doBefore(){
        RestAssured.port = port;//4: 告诉restAssured使用哪个端口来访问
    }
    
    @Test
    public void postTest(){
        JSONObject parm = new JSONObject();
        parm.put("userId", "your id");
        parm.put("name", "your name");
        ValidatableResponse response = (ValidatableResponse) given().contentType("application/json")
        .request().body(parm.toJSONString())
        .when().post("/user/test1").then()
        //断言，类似Assert
        .body("id", new Equals(1))
        //可以接多个断言
        .body("name", new ResponseAwareMatcher<Response>() {
			@Override
			public Matcher<?> matcher(Response response) throws Exception {
				return new Equals("三毛");
			}
		})
        ;
        JSONObject json = JSONObject.parseObject(response.extract().asString());//获取返回的json数据(2)
        //自己写一些代码
        System.out.println(json);
        
    }
}


