package org.ssms.test;

import org.junit.Test;
import org.ssms.entity.AbsenceSetting;
import org.ssms.service.IAbsenceSettingService;

import javax.annotation.Resource;

/**
 * Created by Intellij IDEA
 * USER: luoliang
 * DATE: 2017/5/28
 * TIME: 下午11:24
 */
public class AbsentSettingTest extends BaseTest {
    @Resource
    private IAbsenceSettingService absenceSettingService;

    @Test
    public void testAdd() {
        AbsenceSetting absenceSetting = new AbsenceSetting();
        absenceSetting.setAbsentType("旷工");
        absenceSetting.setShouldDays(21.0);
        absenceSetting.setProportion(3.0);

        absenceSettingService.insert(absenceSetting);
    }
}
