package com.example.shop_detail.controller;

import com.example.shop_detail.application.GoodsApplication;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.utils.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsApplication goodsApplication;

    /**
     * 前台商品列表页面
     *
     * @return 前台商品列表页
     */
    @RequestMapping("/goodsInfo")
    public String goodsInfo() {
        List<Goods> goodsList = goodsApplication.goodsInfo();
        HttpUtils.getRequest().setAttribute("goodsList", goodsList);
        return "jsp/front/goods";
    }

}
