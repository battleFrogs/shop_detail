package com.example.shop_detail.application.impl;

import cn.hutool.core.util.RandomUtil;
import com.example.shop_detail.application.BuyApplication;
import com.example.shop_detail.domain.TradeDomain;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.queue.Order;
import com.example.shop_detail.queue.OrderQueue;
import com.example.shop_detail.service.GoodsService;
import com.example.shop_detail.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

@Service
public class BuyApplicationImpl implements BuyApplication {


    @Resource
    private GoodsService goodsService;
    @Resource
    private TradeService tradeService;


    @Override
    public void createTradeNoPay(Long goodsId, Integer num) {

        Goods goods = goodsService.getById(goodsId);
        Trade trade = new Trade();
        trade.setTradeNo(RandomUtil.randomString(RandomUtil.BASE_CHAR, 10));
        trade.setGoodsName(goods.getGoodsName());
        Long total = Long.valueOf(BigDecimal.valueOf(num).multiply(BigDecimal.valueOf(goods.getGoodsPrice())).toString());
        trade.setTotal(total);
        trade.setUpdateTime(new Date());
        trade.setTradeStatus(TradeDomain.TradeStatus.WAIT_PAY.getValue());
        tradeService.save(trade);

        DelayQueue<Order> delayQueue = OrderQueue.getOrderQueue().getDelayQueue();
        Order order = new Order(trade.getTradeNo(), 10, TimeUnit.SECONDS);
        delayQueue.put(order);
    }

    @Override
    public void createTradePay(Long goodsId, Integer num) {
        Goods goods = goodsService.getById(goodsId);
        Trade trade = new Trade();
        trade.setTradeNo(RandomUtil.randomString(RandomUtil.BASE_CHAR, 10));
        trade.setGoodsName(goods.getGoodsName());
        Long total = Long.valueOf(BigDecimal.valueOf(num).multiply(BigDecimal.valueOf(goods.getGoodsPrice())).toString());
        trade.setTotal(total);
        trade.setPayTime(new Date());
        trade.setUpdateTime(new Date());
        trade.setTradeStatus(TradeDomain.TradeStatus.WAIT_SEND.getValue());
        tradeService.save(trade);
    }


}
