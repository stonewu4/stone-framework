package com.stone.component.controlleradvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.component.response.ResponseInfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: stone
 * @Date: 2021/7/27 14:05
 * @Version 1.0
 * @Des: 统一返回处理
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        /** String格式化为Json **/
        if(o instanceof String){
            return objectMapper.writeValueAsString(ResponseInfo.success(o));
        }
        /** 统一返回类数据无需再次封装**/
        if(o instanceof ResponseInfo){
            return o;
        }
        return ResponseInfo.success(o);
    }
}
