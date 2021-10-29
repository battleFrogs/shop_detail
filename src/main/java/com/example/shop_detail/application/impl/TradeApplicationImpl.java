package com.example.shop_detail.application.impl;

import com.example.shop_detail.application.TradeApplication;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TradeApplicationImpl implements TradeApplication {

    @Resource
    private TradeService tradeService;

    @Override
    public List<Trade> tradeInfo() {
        return tradeService.list();
    }
}
