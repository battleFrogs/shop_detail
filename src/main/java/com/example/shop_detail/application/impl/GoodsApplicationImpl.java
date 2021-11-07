package com.example.shop_detail.application.impl;

import com.example.shop_detail.application.GoodsApplication;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsApplicationImpl implements GoodsApplication {

    @Resource
    private GoodsService goodsService;

    @Override
    public List<Goods> goodsInfo() {
        return goodsService.list();
    }

    @Override
    public List<Goods> goodsSearch(String goodsName) {
        return goodsService.goodsSearch(goodsName);
    }
}
