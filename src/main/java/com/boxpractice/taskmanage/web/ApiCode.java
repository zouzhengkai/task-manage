package com.boxpractice.taskmanage.web;


/**
 * 响应码
 */
public enum ApiCode {
    /**
     * 状态信息
     */
    SUCCESS("000000","成功"),

    /**
     * 业务异常
     */
    BIZ_ERROR("100000","业务异常"),

    ;

    private final String code;

    private final String message;

    ApiCode(String code,String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
