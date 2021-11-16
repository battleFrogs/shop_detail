package com.example.shop_detail.domain.trade_status;

import com.example.shop_detail.domain.TradeDomain;
import com.example.shop_detail.model.Trade;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class TradeStatusClose implements TradeOperate{

    private Trade trade;

    @Override
    public Trade close() {
        trade.setTradeStatus(TradeDomain.TradeStatus.CLOSE.getValue());
        trade.setCloseTime(new Date());
        return trade;
    }


}
