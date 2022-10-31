package com.boxpractice.taskmanage.exception;

import com.boxpractice.taskmanage.web.ApiCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private String code;


    public BusinessException(ApiCode code) {
        super(code.getMessage());
        this.code = code.getCode();
    }

    public BusinessException(ApiCode code, String message) {
        super(message == null ? code.getMessage() : message);
        this.code = code.getCode();
    }

    public BusinessException(ApiCode code, Throwable cause) {
        super(code.getMessage(), cause);
        this.code = code.getCode();
    }

    public BusinessException(ApiCode code, String message, Throwable cause) {
        super(message == null ? code.getMessage() : message, cause);
        this.code = code.getCode();
    }

    public BusinessException(String code,String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public static BusinessException from(String code,String message) {
        return new BusinessException(code,message);
    }

    public static BusinessException from(String code,String message,Throwable cause) {
        return new BusinessException(code,message,cause);
    }

    public static BusinessException from(ApiCode code) {
        return new BusinessException(code);
    }

    public static BusinessException from(ApiCode code, String message) {
        return new BusinessException(code, message);
    }

    public static BusinessException from(ApiCode code, Throwable cause) {
        return new BusinessException(code, cause);
    }

    public static BusinessException from(ApiCode code, String message, Throwable cause) {
        return new BusinessException(code, message, cause);
    }
}
