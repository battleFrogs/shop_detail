package com.example.shop_detail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.shop_detail.model.Goods;

import java.util.List;

/**
 * (Goods)
 *
 * @author makejava
 * @since 2021-10-28 16:37:58
 */
public interface GoodsService extends IService<Goods> {

    List<Goods> goodsSearch(String goodsName);

    Goods findByGoodsId(Long goodsId);
}