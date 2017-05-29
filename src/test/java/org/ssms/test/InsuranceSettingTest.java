package org.ssms.test;

import org.junit.Test;
import org.ssms.entity.InsuranceSetting;
import org.ssms.service.IInsuranceSettingService;

import javax.annotation.Resource;

/**
 * Created by Intellij IDEA
 * USER: luoliang
 * DATE: 2017/5/28
 * TIME: 下午11:34
 */
public class InsuranceSettingTest extends BaseTest{
    @Resource
    private IInsuranceSettingService insuranceSettingService;

    @Test
    public void testAdd(){
        InsuranceSetting insuranceSetting = new InsuranceSetting();
    }
}
