package com.boxpractice.taskmanage.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private String code;

    private String message;

    private T data;

    public static ApiResponse fromApiCode(ApiCode code) {
        return ApiResponse.builder().code(code.getCode()).message(code.getMessage()).build();
    }

    public static <T> ApiResponse<T> fromApiCode(ApiCode code, T data) {
        return ApiResponse.<T>builder().code(code.getCode()).message(code.getMessage()).data(data).build();
    }

    public static <T> ApiResponse<T> fromApiCode(ApiCode code, String message, T data) {
        return ApiResponse.<T>builder().code(code.getCode()).message(message != null ? message : code.getMessage()).data(data).build();
    }

    public static <T> ApiResponse<T> fromApiCode(String code, String message, T data) {
        if (message == null) {
            try {
                ApiCode c = ApiCode.valueOf(code);
                message = c.getMessage();
            } catch (Exception ex) {
            }
        }
        return ApiResponse.<T>builder().code(code).message(message).data(data).build();
    }

    public static <T> ApiResponse<T> success(T data) {
        ApiCode code = ApiCode.SUCCESS;
        return ApiResponse.<T>builder().code(code.getCode()).message(code.getMessage()).data(data).build();
    }

    public static ApiResponse success() {
        ApiCode code = ApiCode.SUCCESS;
        return ApiResponse.builder().code(code.getCode()).message(code.getMessage()).build();
    }

}
