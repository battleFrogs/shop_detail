package com.example.shop_detail.task;

import com.example.shop_detail.domain.TradeDomain;
import com.example.shop_detail.domain.trade_status.TradeOperate;
import com.example.shop_detail.domain.trade_status.TradeStatusFactory;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.queue.Order;
import com.example.shop_detail.queue.OrderQueue;
import com.example.shop_detail.service.TradeService;
import com.example.shop_detail.utils.SpringUtil;

import java.util.concurrent.DelayQueue;

public class CloseOrderTimeOutTask implements Runnable {


    @Override
    public void run() {

        OrderQueue orderQueue = OrderQueue.getOrderQueue();
        DelayQueue<Order> delayQueue = orderQueue.getDelayQueue();
        while (true) {
            Order order = delayQueue.poll();
            if (order != null) {
                String tradeNo = order.getTradeNo();
                TradeService tradeService = SpringUtil.getBean(TradeService.class);
                Trade trade = tradeService.findByTradeNo(tradeNo);
                if (trade != null) {
                    TradeStatusFactory tradeStatusFactory = new TradeStatusFactory();
                    TradeOperate tradeStatusBean = tradeStatusFactory.getTradeStatusBean(trade);
                    tradeStatusBean.close();
                    tradeService.saveOrUpdate(trade);
                }
            }
        }

    }
}
