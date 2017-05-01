package org.ssms.web.param;

import lombok.Data;

@Data
public class PageParam {
    private Integer currentPage;

    private Integer pageSize;

    private String staffInfoSearch;
}
