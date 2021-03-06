package com.example.shop_detail.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.param.TradeInfoByStatusParam;

import java.util.Date;
import java.util.List;

/**
 * (Trade)
 *
 * @author makejava
 * @since 2021-10-29 15:50:06
 */
public interface TradeService extends IService<Trade> {

    IPage<Trade> tradeInfo(String tradeStatus, Date beginTime, Date endTime, IPage<Trade> tradeIPage);

    List<Trade> tradeInfo(String tradeStatus, Date beginTime, Date endTime);

    Trade findByTradeNo(String tradeNo);
}