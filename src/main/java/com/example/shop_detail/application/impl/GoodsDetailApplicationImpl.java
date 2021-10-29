package com.example.shop_detail.application.impl;

import com.example.shop_detail.application.GoodsDetailApplication;
import com.example.shop_detail.exception.CustomizeException;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsDetailApplicationImpl implements GoodsDetailApplication {

    @Resource
    private GoodsService goodsService;

    @Override
    public Goods goodsDetail(Long goodsId) {
        Goods goods = goodsService.getById(goodsId);
        if (goods == null) {
            throw new CustomizeException("商品不存在");
        }
        return goodsService.getById(goodsId);
    }
}
