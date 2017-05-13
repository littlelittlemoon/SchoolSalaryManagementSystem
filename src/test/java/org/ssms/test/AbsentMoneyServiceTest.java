package org.ssms.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.ssms.service.IAbsentMoneyService;
import org.ssms.web.param.AbsentInfoQueryParam;
import org.ssms.web.param.AbsentMoneyQueryParam;
import org.ssms.web.result.BaseResponse;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

public class AbsentMoneyServiceTest extends BaseTest {
    @Resource
    private IAbsentMoneyService absentMoneyService;

    @Test
    public void testCount() {
        List<String> staffIds = Arrays.asList("11111", "7613f");

        absentMoneyService.countAbsentMoney(staffIds);
    }

    @Test
    public void testHrAbsentInfo() {
        AbsentMoneyQueryParam param = new AbsentMoneyQueryParam();
        param.setPageSize(5);
        param.setCurrentPage(1);
        BaseResponse response = absentMoneyService.getAbsentInfoResult(param);

        System.out.println(JSON.toJSONString(response));
    }
}
