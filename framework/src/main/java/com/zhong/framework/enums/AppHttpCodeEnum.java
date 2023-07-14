package com.zhong.framework.enums;

public enum AppHttpCodeEnum {
    SUCCESS(200, "操作成功"),
    BAD_REQUEST(400, "请求不合法"),
    NOT_FOUND(404, "请求的资源不存在"),
    SYSTEM_ERROR(500, "出现错误"),;

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
