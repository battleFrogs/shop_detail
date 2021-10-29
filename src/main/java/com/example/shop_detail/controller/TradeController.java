package com.example.shop_detail.controller;

import com.example.shop_detail.application.TradeApplication;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.utils.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/trade")
public class TradeController {

    @Resource
    private TradeApplication tradeApplication;

    /**
     * 查询订单信息
     *
     * @param tradeType 订单类型
     * @return 订单页面
     */
    @RequestMapping("/tradeInfo")
    public String tradeInfo(String tradeType) {
        List<Trade> tradeList = tradeApplication.tradeInfo();
        HttpUtils.getRequest().setAttribute("tradeList", tradeList);
        return "/jsp/front/trade";
    }


}
