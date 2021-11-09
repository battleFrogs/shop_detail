package com.example.shop_detail.config;

import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.exception.CustomizeException;
import com.example.shop_detail.utils.ResponseWriterUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class TokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if (token == null) {
            ResultData resultData = new ResultData(ResultEnum.RELOGIN.getCode(), "重新登录");
            ResponseWriterUtils.writeToJSON(resultData, response);
            return false;
        }
        return true;
    }

}
