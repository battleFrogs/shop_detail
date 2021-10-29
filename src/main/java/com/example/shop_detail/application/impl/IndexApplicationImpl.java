package com.example.shop_detail.application.impl;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.example.shop_detail.application.IndexApplication;
import com.example.shop_detail.exception.CustomizeException;
import com.example.shop_detail.model.User;
import com.example.shop_detail.service.UserService;
import com.example.shop_detail.utils.HttpUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class IndexApplicationImpl implements IndexApplication {


    @Resource
    private UserService userService;

    @Override
    public void loginIn(String account, String password) {
        HttpSession session = HttpUtils.getRequest().getSession();
        User user = userService.findByUsername(account);
        if (user == null) {
            throw new CustomizeException("不存在");
        }
        String s = MD5.create().digestHex("password");
        if (s.equals(user.getPassword())) {
            throw new CustomizeException("密码不正确");
        }
        session.setAttribute("token", JSON.toJSONString(user));
    }

}
