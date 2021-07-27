package com.stone.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stone.domain.SysLog;
import com.stone.enums.LogTypeEnum;
import com.stone.mapper.SysLogMapper;
import com.stone.service.SysLogService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author stone
* @Description: 日志业务层
*/
@Slf4j
@Service
@Transactional
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    /**
     * 保存日志
     * @param sysLog
     */
    @Override
    public void saveLog(SysLog sysLog) {
        // 查看不做操作 Log注解上没写注释的也不保存
        Integer operation = sysLog.getOperation();
        if (operation != LogTypeEnum.SELECT.getCode() && operation != 0){
            //执行日志写入数据库操作
            this.save(sysLog);
        }
    }



}
