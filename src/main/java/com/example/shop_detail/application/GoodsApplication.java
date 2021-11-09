package com.example.shop_detail.application;

import com.example.shop_detail.model.Goods;
import com.example.shop_detail.param.AddGoodsParam;
import com.example.shop_detail.param.GoodsSearchParam;
import com.example.shop_detail.param.UpdateGoodsNumParam;
import com.example.shop_detail.param.UpdateGoodsParam;

import java.util.List;

public interface GoodsApplication {

    List<Goods> goodsInfo();

    List<Goods> goodsSearch(GoodsSearchParam param);

    void addGoods(AddGoodsParam param);

    void deleteGoods(Long goodsId);

    void updateGoods(UpdateGoodsParam param);

    void updateGoodsNum(UpdateGoodsNumParam param);

}
