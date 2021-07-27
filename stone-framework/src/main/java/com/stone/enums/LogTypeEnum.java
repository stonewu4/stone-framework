package com.stone.enums;

/**
 * @Author: stone
 * @Date: 2021/7/27 17:32
 * @Version 1.0
 */
public enum LogTypeEnum {
    /**
     * 增1 删2 改3 查4 登陆5 登出6 导入7 导出8 上传9 默认0
     */
    INSERT(1,"新增"),
    DELETE(2,"删除"),
    UPDATE(3,"修改"),
    SELECT(4,"查询"),
    LOGIN(5,"登录"),
    LOGOUT(6,"登出"),
    IMPORT(7,"导入"),
    EXPORT(8,"导出"),
    UPLOAD(9,"上传"),
    DEFAULT(0,"默认");
    private int code;
    private String type;

    LogTypeEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }
}
