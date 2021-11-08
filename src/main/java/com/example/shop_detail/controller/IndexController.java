package com.example.shop_detail.controller;

import com.example.shop_detail.application.IndexApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Resource
    private IndexApplication indexApplication;

    /**
     * 登录请求
     *
     * @return 登录响应
     */
    @RequestMapping("/loginIn")
    public ResultData loginIn(@RequestParam String account, @RequestParam String password) {
        indexApplication.loginIn(account, password);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }

}
