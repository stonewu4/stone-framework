package com.stone.aop;

import com.stone.enums.LogTypeEnum;
import com.stone.enums.ModuleTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * log annotation
 * <p>
 * use:在方法上打上 @Log("log的描述")
 * 在控制台看到对应数据,后面改为入库操作
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    /**
     * 日志类型
     * 详情见 LogTypeEnum.java
     */
    LogTypeEnum value() default LogTypeEnum.DEFAULT;

    /**
     * 操作模块类型
     * 详情见 ModuleTypeEnum.java
     */
    ModuleTypeEnum type() default ModuleTypeEnum.INDEX;

    /**
     * 接口的描述
     */
    String description() default "未知方法";
}
