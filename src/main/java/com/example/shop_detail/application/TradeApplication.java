package com.example.shop_detail.application;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.param.TradeInfoByStatusParam;
import com.example.shop_detail.vo.TradeInfoByStatusVO;

import java.util.List;

public interface TradeApplication {


    TradeInfoByStatusVO tradeInfo(TradeInfoByStatusParam tradeInfoByStatusParam, IPage<Trade> tradeIPage);

    void createTradeNoPay(Long goodsId, Integer num);

    void createTradePay(Long goodsId, Integer num);

    void tradeSend(String tradeNo);

    void tradeReceive(String tradeNo);

    void tradePay(String tradeNo);
}
