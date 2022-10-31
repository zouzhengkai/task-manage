package com.boxpractice.taskmanage.exception;

import cn.hutool.core.collection.CollectionUtil;
import com.boxpractice.taskmanage.utils.StringUtil;
import com.boxpractice.taskmanage.web.ApiCode;
import com.boxpractice.taskmanage.web.ApiResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    public static MediaType
            APPLICATION_JSON_UTF8 = new MediaType("application", "json", StandardCharsets.UTF_8);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.debug("MethodArgumentNotValidException：", e);
        Map<String, String> errorsMap = e.getBindingResult().getAllErrors().stream()
                .map(el -> {
                    if (el instanceof FieldError) {
                        return new ExceptionValidObject(StringUtil.camelToSnake(((FieldError) el).getField()), el.getDefaultMessage());
                    } else {
                        return new ExceptionValidObject(StringUtil.join(el.getArguments(), ","), el.getDefaultMessage());
                    }
                })
                .collect(Collectors.toMap(
                        ExceptionValidObject::getName,
                        ExceptionValidObject::getMessage,
                        (u, v) -> CollectionUtil.join(Arrays.asList(u, v), ",")
                ));
        String msg = String.join(",", errorsMap.values());
        return error(ApiCode.BIZ_ERROR.getCode(), msg, errorsMap);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> ConstraintViolationExceptionHandler(ConstraintViolationException e) {
        log.debug("ConstraintViolationException：", e);
        Map<String, String> errorMap = e.getConstraintViolations().stream().collect(Collectors.toMap(el -> StringUtil.camelToSnake(el.getPropertyPath().toString()), el -> el.getMessage()));
        String msg = String.join(",", errorMap.values());
        return error(ApiCode.BIZ_ERROR.getCode(), msg, errorMap);
    }

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ApiResponse> apiExceptionHandler(HttpServletRequest request, BusinessException e) {
        log.info("Request body:{}, BusinessException：", getRequestBody(request), e);
        return error(e.getCode(), e.getMessage(),null);
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse> exceptionHandler(HttpServletRequest request, Exception e) {
        log.error("Request body:{}, 未知异常：", getRequestBody(request), e);
        return error(ApiCode.BIZ_ERROR.getCode(), null, e.getMessage());
    }

    private <T> ResponseEntity<ApiResponse> error(ApiCode code, String message, T data) {
        return error(code.name(), message != null ? message : code.getMessage(), data);
    }

    private <T> ResponseEntity<ApiResponse> error(String code, String message, T data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON_UTF8);
        ApiResponse response = ApiResponse.fromApiCode(code, message, data);
        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    private String getRequestBody(HttpServletRequest request){
        String body = null;
        try {
            body = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        }catch (IOException e1){
        }
        return body;
    }

    @Data
    public static class ExceptionValidObject{
        private String name;
        private String message;

        public ExceptionValidObject(){

        }

        public ExceptionValidObject(String name,String message){
            this.name = name;
            this.message = message;
        }
    }
}
