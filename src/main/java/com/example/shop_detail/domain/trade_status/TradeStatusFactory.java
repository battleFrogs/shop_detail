package com.example.shop_detail.domain.trade_status;

import com.example.shop_detail.domain.TradeDomain;
import com.example.shop_detail.exception.CustomizeException;
import com.example.shop_detail.model.Trade;

import static com.example.shop_detail.domain.TradeDomain.TradeStatus.WAIT_PAY;

public class TradeStatusFactory {

    public TradeOperate getTradeStatusBean(Trade trade) {
        TradeDomain.TradeStatus tradeStatus = TradeDomain.TradeStatus.getEnum(trade.getTradeStatus());
        switch (tradeStatus) {
            case WAIT_PAY:
                return new TradeStatusClose(trade);
            default:
                throw new CustomizeException("有问题");
        }

    }

}
