package org.ssms.web.result;

import lombok.Data;
import org.ssms.entity.viewentity.StaffInfoView;

import java.util.List;

/**
 * Created by Intellij IDEA
 * USER: luoliang
 * DATE: 2017/5/30
 * TIME: 下午9:31
 */
@Data
public class StaffInfoResult extends PageResult{
    private List<StaffInfoView> staffInfoViews;
}
