package com.example.shop_detail.controller;

import com.example.shop_detail.application.BuyApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/buy")
public class BuyController {


    @Resource
    private BuyApplication buyApplication;

    /**
     * 创建订单未支付
     *
     * @param goodsId 商品Id
     * @param num     数目
     * @return resultData
     */
    @RequestMapping("/createTradeNoPay")
    public ResultData createTradeNoPay(Long goodsId, Integer num) {
        buyApplication.createTradeNoPay(goodsId, num);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }

    /**
     * 创建订单支付
     *
     * @param goodsId 商品Id
     * @param num     数目
     * @return resultData
     */
    @RequestMapping("/createTradePay")
    public ResultData createTradePay(Long goodsId, Integer num) {
        buyApplication.createTradePay(goodsId, num);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


}
