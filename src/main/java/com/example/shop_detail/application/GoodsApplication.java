package com.example.shop_detail.application;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.param.AddGoodsParam;
import com.example.shop_detail.param.GoodsSearchParam;
import com.example.shop_detail.param.UpdateGoodsNumParam;
import com.example.shop_detail.param.UpdateGoodsParam;
import com.example.shop_detail.vo.GoodsSearchVO;

import java.util.List;

public interface GoodsApplication {

    List<Goods> goodsInfo();

    GoodsSearchVO goodsSearch(GoodsSearchParam param, IPage<Goods> goodsIPage);

    void addGoods(AddGoodsParam param);

    void deleteGoods(Long goodsId);

    void updateGoods(UpdateGoodsParam param);

    void updateGoodsNum(UpdateGoodsNumParam param);

}
