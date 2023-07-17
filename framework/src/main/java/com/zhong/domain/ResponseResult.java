package com.zhong.domain;

import com.zhong.enums.AppHttpCodeEnum;

import java.io.Serializable;

/**
 * @author zhong
 * @date 2023/7/14
 */
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public ResponseResult() {
        this.code = AppHttpCodeEnum.SUCCESS.getCode();
        this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
    }

    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums) {
        return ResponseResult.okResult(enums.getCode(), enums.getMsg());
    }

    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums, String msg) {
        return ResponseResult.okResult(enums.getCode(), msg);
    }

    public ResponseResult<?> ok(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public ResponseResult<?> ok(Integer code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
        return this;
    }

    public ResponseResult<?> error(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public static ResponseResult okResult() {
        ResponseResult result = new ResponseResult();
        return result;
    }

    public static ResponseResult okResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, msg);
    }

    public static ResponseResult okResult(Object data) {
        ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getMsg());
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    public static ResponseResult errorResult(Integer code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums) {
        return setAppHttpCodeEnum(enums, enums.getMsg());
    }

    public static ResponseResult errorResult(AppHttpCodeEnum enums, String msg) {
        return setAppHttpCodeEnum(enums, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
