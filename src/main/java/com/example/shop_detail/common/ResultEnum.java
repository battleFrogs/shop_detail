package com.example.shop_detail.common;

public enum ResultEnum {


    /**
     *
     */
    SUCCESS("请求成功", 0),
    ERROR("服务器内部错误", 500),
    RELOGIN("重新登录", 401),
    FORBIDDEN("没有权限", 403),
    PARAM_ERROR("参数错误", 5001),
    NON_EXISTENT("目标不存在", 5002);

    private String msg;
    private Integer code;

    public String getMsg() {
        return this.msg;
    }

    public Integer getCode() {
        return this.code;
    }

    private ResultEnum(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }
    }
