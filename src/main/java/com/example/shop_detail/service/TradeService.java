package com.example.shop_detail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_detail.model.Trade;

import java.util.List;

/**
 * (Trade)
 *
 * @author makejava
 * @since 2021-10-29 15:50:06
 */
public interface TradeService extends IService<Trade> {

    List<Trade> tradeInfo(String tradeStatus);
}