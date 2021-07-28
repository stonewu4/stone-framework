package com.stone.component.controlleradvice;

import com.stone.component.enums.ReturnCodeEnum;
import com.stone.component.exception.BusinessException;
import com.stone.component.response.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @Author: stone
 * @Date: 2021/7/27 14:54
 * @Version 1.0
 * @Des: 全局统一异常处理
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * @Description 默认全局异常处理
     * @date 2021/7/27 15:11
     * @param
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseInfo<String> exception(Exception e) {
        log.error("全局异常信息 Exception: {}", e.getMessage(), e);
        if(e instanceof NoHandlerFoundException){
            return ResponseInfo.fail(ReturnCodeEnum.RC404);
        }else {
            return ResponseInfo.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }

    }

    /**
     * @Description 自定义异常处理
     * @date 2021/7/27 15:12
     * @param
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseInfo<String> exception(BusinessException e) {
        log.error("全局异常信息 Exception: {}", e.getMessage(), e);
        return ResponseInfo.fail(e.getCode(),e.getMessage());
    }

}
