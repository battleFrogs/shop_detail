package com.example.shop_detail.controller;

import com.example.shop_detail.application.GoodsDetailApplication;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.utils.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/goodsDetail")
public class GoodsDetailController {

    @Resource
    private GoodsDetailApplication goodsDetailApplication;

    @RequestMapping("/goodsDetail")
    public String goodsDetail(@RequestParam Long goodsId) {
        Goods goods = goodsDetailApplication.goodsDetail(goodsId);
        HttpUtils.getRequest().setAttribute("goods", goods);
        return "jsp/front/goodsDetail";
    }


}
