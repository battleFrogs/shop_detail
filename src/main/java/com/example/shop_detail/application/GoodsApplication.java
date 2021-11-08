package com.example.shop_detail.application;

import com.example.shop_detail.model.Goods;
import com.example.shop_detail.param.GoodsSearchParam;

import java.util.List;

public interface GoodsApplication {

    List<Goods> goodsInfo();

    List<Goods> goodsSearch(GoodsSearchParam param);

}
