package com.example.shop_detail.exception;

import com.example.shop_detail.common.ResultEnum;

public class CustomizeException extends RuntimeException {
    private static final long serialVersionUID = 3642650953275995607L;
    public Integer code;
    public String errMsg;

    public CustomizeException(String message) {
        super(message);
        this.code = ResultEnum.ERROR.getCode();
        this.errMsg = message;
    }

    public CustomizeException(Integer code, String errMsg) {
        super(errMsg);
        this.code = code;
        this.errMsg = errMsg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
