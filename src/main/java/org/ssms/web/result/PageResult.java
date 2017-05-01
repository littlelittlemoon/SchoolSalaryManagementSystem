package org.ssms.web.result;

import lombok.Data;

@Data
public class PageResult {
    private Integer total;

    private Integer currentPage;
}
