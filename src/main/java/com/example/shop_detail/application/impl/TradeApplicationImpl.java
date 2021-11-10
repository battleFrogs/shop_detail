package com.example.shop_detail.application.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.shop_detail.application.TradeApplication;
import com.example.shop_detail.domain.TradeDomain;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.param.TradeInfoByStatusParam;
import com.example.shop_detail.service.GoodsService;
import com.example.shop_detail.service.TradeService;
import com.example.shop_detail.vo.TradeInfoByStatusVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class TradeApplicationImpl implements TradeApplication {

    @Resource
    private TradeService tradeService;
    @Resource
    private GoodsService goodsService;

    @Override
    public TradeInfoByStatusVO tradeInfo(TradeInfoByStatusParam param, IPage<Trade> tradeIPage) {
        TradeInfoByStatusVO result = new TradeInfoByStatusVO();
        IPage<Trade> tradeIPageResult = tradeService.tradeInfo(param.getTradeStatus(), param.getBeginTime(),
                param.getEndTime(), tradeIPage);
        result.setTotal(tradeIPageResult.getTotal());
        result.setTradeList(tradeIPageResult.getRecords());
        return result;
    }

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

    @Override
    public void tradeSend(String tradeNo) {
        Trade trade = tradeService.findByTradeNo(tradeNo);
        trade.setTradeStatus(TradeDomain.TradeStatus.WAIT_RECEIVE.getValue());
        trade.setSendTime(new Date());
        trade.setUpdateTime(new Date());
        tradeService.saveOrUpdate(trade);
    }

    @Override
    public void tradeReceive(String tradeNo) {
        Trade trade = tradeService.findByTradeNo(tradeNo);
        trade.setTradeStatus(TradeDomain.TradeStatus.FINISH.getValue());
        trade.setReceiveTime(new Date());
        trade.setUpdateTime(new Date());
        tradeService.saveOrUpdate(trade);
    }

    @Override
    public void tradePay(String tradeNo) {
        Trade trade = tradeService.findByTradeNo(tradeNo);
        trade.setTradeStatus(TradeDomain.TradeStatus.WAIT_SEND.getValue());
        trade.setPayTime(new Date());
        trade.setUpdateTime(new Date());
        tradeService.saveOrUpdate(trade);
    }
}
