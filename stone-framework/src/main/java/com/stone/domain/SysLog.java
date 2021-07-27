package com.stone.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SysLog {

    private Long id;

    /**
     * 日志类型  根据系统模块来定义日志类型
     */
    private Integer logType;

    /**
     * 操作类型： 添加-1 删除-2 更新-3 查看-4
     */
    private Integer operation;

    /**
     * 操作人员ID
     */
    private Long logUser;

    /**
     * 访问IP
     */
    private String logIp;

    /**
     * 请求方法
     */
    private String logMethod;

    /**
     * 请求参数
     */
    private String logParams;

    /**
     * 日志描述
     */
    private String logDesc;

    /**
     * 响应时间
     */
    private Long logTime;

    /**
     * 异常码
     */
    private String exceptionCode;

    /**
     * 异常描述
     */
    private String exceptionDetail;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


}