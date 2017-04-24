package org.ssms.web.param;

import lombok.Data;

@Data
public class StaffQueryParam {
    private String staffInfoSearch;

    private Integer currentPage;

    private Integer pageSize;
}
