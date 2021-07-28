package com.stone.enums;

/**
 * @Author: stone
 * @Date: 2021/7/28 9:44
 * @Version 1.0
 */
public enum ModuleTypeEnum {
    INDEX(0,"首页"),
    SYSTEM_MANAGE(1,"系统管理"),
    USER_MANAGE(2,"用户管理"),
    ROLE_MANAGE(3,"角色管理");
    private int code;
    private String typeName;

    ModuleTypeEnum(int code, String typeName) {
        this.code = code;
        this.typeName = typeName;
    }

    public int getCode() {
        return code;
    }

    public String getTypeName() {
        return typeName;
    }
}
