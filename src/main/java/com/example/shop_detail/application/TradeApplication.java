package com.example.shop_detail.application;

import com.example.shop_detail.model.Trade;
import com.example.shop_detail.param.TradeInfoByStatusParam;

import java.util.List;

public interface TradeApplication {


    List<Trade> tradeInfo(TradeInfoByStatusParam tradeInfoByStatusParam);

    void createTradeNoPay(Long goodsId, Integer num);

    void createTradePay(Long goodsId, Integer num);

    void tradeSend(String tradeNo);

    void tradeReceive(String tradeNo);

    void tradePay(String tradeNo);
}
