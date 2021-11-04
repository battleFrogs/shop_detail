package com.example.shop_detail.controller;

import com.example.shop_detail.application.TradeApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.utils.HttpUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * @return 订单页面
     */
    @RequestMapping("/tradeInfo")
    public String tradeInfo() {
        List<Trade> tradeList = tradeApplication.tradeInfo("");
        HttpUtils.getRequest().setAttribute("tradeList", tradeList);
        return "/jsp/front/trade";
    }

    /**
     * 查询订单状态信息
     *
     * @param tradeStatus 订单类型
     * @return 订单页面
     */
    @RequestMapping("/tradeInfoByStatus")
    @ResponseBody
    public ResultData tradeInfoByStatus(String tradeStatus) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        List<Trade> tradeList = tradeApplication.tradeInfo(tradeStatus);
        resultData.addData("tradeList", tradeList);
        return resultData;
    }


    /**
     * 创建订单未支付
     *
     * @return index页面
     */
    @RequestMapping("/createTradeNoPay")
    @ResponseBody
    public ResultData createTradeNoPay(Long goodsId, Integer num) {
        tradeApplication.createTradeNoPay(goodsId, num);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }

    /**
     * 创建订单支付
     *
     * @return index页面
     */
    @RequestMapping("/createTradePay")
    @ResponseBody
    public ResultData createTradePay(Long goodsId, Integer num) {
        tradeApplication.createTradePay(goodsId, num);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


}
