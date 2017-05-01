package org.ssms.web.result;

import lombok.Data;
import org.ssms.entity.AbsentInfo;

import java.util.List;

@Data
public class AbsentInfoResult extends PageResult {
    private List<AbsentInfo> absentInfos;
}
