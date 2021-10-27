package com.example.shop_detail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {


    /**
     * 访问首页
     *
     * @return 首页
     */
    @RequestMapping("/index")
    public String index() {
        return "jsp/index/index";
    }

    /**
     * 访问登录页面
     *
     * @return 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "jsp/index/login";
    }

    /**
     * 访问登录页面
     *
     * @return 登录页
     */
    @RequestMapping("/loginIn")
    @ResponseBody
    public String loginIn() {
        return "success";
    }


}
