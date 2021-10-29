package com.example.shop_detail.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultData implements java.io.Serializable {

    /**
     * 默认生成的序列号
     */
    private static final long serialVersionUID = 1L;


    private Integer code = 200;//默认成功

    private String msg = "";


    private Map<String, Object> data = new HashMap<>(32);

    public ResultData() {
    }

    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(Integer code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    public ResultData error(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

    public ResultData error(String msg) {
        this.setCode(ResultEnum.ERROR.getCode());
        this.setMsg(msg);
        return this;
    }

}
