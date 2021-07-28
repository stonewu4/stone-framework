package com.stone.component.enums;

/**
 * @Author: stone
 * @Date: 2021/7/27 10:37
 * @Version 1.0
 */
public enum ReturnCodeEnum {
    /**操作成功**/
    RC200(200,"操作成功"),
    /**操作失败**/
    RC999(999,"操作失败"),
    /**服务限流**/
    RC201(201,"服务开启限流保护,请稍后再试!"),
    /**服务降级**/
    RC202(202,"服务开启降级保护,请稍后再试!"),
    /**热点参数限流**/
    RC203(203,"热点参数限流,请稍后再试!"),
    /**系统规则不满足**/
    RC204(204,"系统规则不满足要求,请稍后再试!"),
    /**授权规则不通过**/
    RC205(205,"授权规则不通过,请稍后再试!"),
    /**access_denied**/
    RC401(401,"匿名用户访问无权限资源时的异常"),
    /**access_denied**/
    RC403(403,"无访问权限,请联系管理员授予权限"),
    RC404(404,"访问接口不存在"),
    /**服务异常**/
    RC500(500,"系统异常，请稍后重试"),
    /**认证异常 1001-1099**/
    INVALID_TOKEN(1001,"访问令牌不合法"),
    ACCESS_DENIED(1002,"没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED(1003,"客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1004,"用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1005, "不支持的认证模式"),
    /**文件上传异常 2001-2099**/
    IMAGE_FORMAT_ERROR(2001,"图片格式不正确"),
    UPLOAD_IMAGE_EXCEPTION(2002,"图片上传异常"),
    NO_FILE(2003,"上传失败，请选择文件"),
    FILE_TRANSFER_ERROR(2004,"文件传输错误"),
    UPLOAD_FILE_EXCEPTION(2099,"文件上传异常"),
    /**业务异常 3001-3099**/
    NODATA(3001,"暂无数据!"),
    INFO_INCOMPLETE(3002,"参数错误!");




    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    ReturnCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
