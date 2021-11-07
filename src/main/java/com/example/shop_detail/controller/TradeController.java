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
     * 前台订单列表页面
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
     * 后台订单列表页面
     *
     * @return 订单页面
     */
    @RequestMapping("/tradeManage")
    public String tradeManage() {
        List<Trade> tradeList = tradeApplication.tradeInfo("");
        HttpUtils.getRequest().setAttribute("tradeList", tradeList);
        return "/jsp/behind/trade";
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
     * @param goodsId 商品Id
     * @param num     数目
     * @return resultData
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
     * @param goodsId 商品Id
     * @param num     数目
     * @return resultData
     */
    @RequestMapping("/createTradePay")
    @ResponseBody
    public ResultData createTradePay(Long goodsId, Integer num) {
        tradeApplication.createTradePay(goodsId, num);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * 订单发货
     *
     * @param tradeNo 订单号
     * @return resultData
     */
    @RequestMapping("/tradeSend")
    @ResponseBody
    public ResultData tradeSend(String tradeNo) {
        tradeApplication.tradeSend(tradeNo);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }

    /**
     * 订单付款
     *
     * @param tradeNo 订单号
     * @return resultData
     */
    @RequestMapping("/tradePay")
    @ResponseBody
    public ResultData tradePay(String tradeNo) {
        tradeApplication.tradePay(tradeNo);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * 订单确认收货
     *
     * @param tradeNo 订单号
     * @return resultData
     */
    @RequestMapping("/tradeReceive")
    @ResponseBody
    public ResultData tradeReceive(String tradeNo) {
        tradeApplication.tradeReceive(tradeNo);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


}
