package org.ssms.web.result;

import lombok.Data;

@Data
public class BaseResponse<T> {
    /**
     * 返回结果码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    private T data;

    public BaseResponse() {
        this.code = "0";
    }
}
