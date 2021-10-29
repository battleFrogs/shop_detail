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
            response.sendRedirect("http://localhost:8080/shop_detail_war_exploded/index/login");
            return false;
        }
        return true;
    }

}
