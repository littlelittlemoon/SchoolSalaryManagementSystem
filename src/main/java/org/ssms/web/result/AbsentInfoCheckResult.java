package org.ssms.web.result;

import lombok.Data;
import org.ssms.mapper.result.AbsentInfoCheck;

import java.util.List;

@Data
public class AbsentInfoCheckResult extends PageResult {
    private List<AbsentInfoCheck> absentInfoChecks;
}
