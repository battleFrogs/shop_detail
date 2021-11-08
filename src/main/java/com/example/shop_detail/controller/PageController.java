package com.example.shop_detail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/page")
@Controller
public class PageController {


    /**
     * 访问登录页面
     *
     * @return 登录页
     */
    @RequestMapping("/index/login")
    public String login() {
        return "jsp/index/login";
    }

    /**
     * 前台商品列表页面
     *
     * @return 前台商品列表页
     */
    @RequestMapping("/goods/goodsInfo")
    public String goodsInfo() {
        return "jsp/front/goods";
    }

    /**
     * 后台商品列表页面
     *
     * @return 前台商品列表页
     */
    @RequestMapping("/goods/goodsManage")
    public String goodsManage() {
        return "jsp/behind/goods";
    }

    /**
     * 前台订单列表页面
     *
     * @return 订单页面
     */
    @RequestMapping("/trade/tradeInfo")
    public String tradeInfo() {
        return "/jsp/front/trade";
    }

    /**
     * 后台订单列表页面
     *
     * @return 订单页面
     */
    @RequestMapping("/trade/tradeManage")
    public String tradeManage() {
        return "/jsp/behind/trade";
    }

}
