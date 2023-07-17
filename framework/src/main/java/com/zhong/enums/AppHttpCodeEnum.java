package com.zhong.enums;

public enum AppHttpCodeEnum {
    SUCCESS(200, "操作成功"),
    BAD_REQUEST(400, "请求不合法"),
    NOT_FOUND(404, "请求的资源不存在"),
    SYSTEM_ERROR(500, "出现错误"),
    USERNAME_EXIST(501, "用户已存在"),
    EMAIL_EXIST(502, "邮箱已存在"),
    PHONE_NUMBER_EXIST(503, "手机号已存在");

    private final int code;
    private final String msg;

    AppHttpCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
