package org.ssms.web.param;

import lombok.Data;

/**
 * Created by Intellij IDEA
 * USER: luoliang
 * DATE: 2017/5/6
 * TIME: 下午1:09
 */
@Data
public class CheckAbsentInfoParam {
    private String staffId;

    private String beginTime;

    private String status;
}
