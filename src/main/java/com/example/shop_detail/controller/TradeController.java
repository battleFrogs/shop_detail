package com.example.shop_detail.controller;

import com.example.shop_detail.application.TradeApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.param.TradeInfoByStatusParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {

    @Resource
    private TradeApplication tradeApplication;

    /**
     * 查询订单状态信息
     *
     * @param tradeInfoByStatusParam 订单参数
     * @return 订单页面
     */
    @RequestMapping("/tradeInfoByStatus")
    public ResultData tradeInfoByStatus(@RequestBody @Valid TradeInfoByStatusParam tradeInfoByStatusParam) {
        System.out.println(tradeInfoByStatusParam.getTradeStatus());
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        List<Trade> tradeList = tradeApplication.tradeInfo(tradeInfoByStatusParam);
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
    public ResultData tradeReceive(String tradeNo) {
        tradeApplication.tradeReceive(tradeNo);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


}
