package com.example.shop_detail.utils;

import com.alibaba.fastjson.JSON;
import com.example.shop_detail.common.ResultData;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应输出类
 */
public class ResponseWriterUtils {


    public static void write(ResultData resultData, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type","text/ plain;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(resultData));

    }

    public static void writeToJSON(ResultData resultData, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type","application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(resultData));

    }



}
