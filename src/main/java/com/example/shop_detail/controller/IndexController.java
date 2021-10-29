package com.example.shop_detail.controller;

import com.example.shop_detail.application.IndexApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.utils.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Timer;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexApplication indexApplication;

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
     * 登录请求
     *
     * @return 登录响应
     */
    @RequestMapping("/loginIn")
    @ResponseBody
    public ResultData loginIn(@RequestParam String account, @RequestParam String password) {
        indexApplication.loginIn(account, password);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


    public static void main(String[] args) {

        

    }


}
