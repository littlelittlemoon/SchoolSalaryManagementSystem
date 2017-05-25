package org.ssms.web.result;

import lombok.Data;

import java.util.List;

/**
 * Created by Intellij IDEA
 * DATE: 2017/5/22
 * TIME: 下午11:12
 */
@Data
public class TaxInfoResult extends PageResult{
    private List<TaxInfo> taxInfoList;
}
