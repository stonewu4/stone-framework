package com.stone.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.stone.domain.SysLog;


/**
 * @Description 日志写入
 * @date 2021/7/27 17:28
 * @param
 */
public interface SysLogService extends IService<SysLog> {
    /**
     * 保存日志
     */
    void saveLog(SysLog sysLog);
}
