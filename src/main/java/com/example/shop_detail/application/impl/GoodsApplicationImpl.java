package com.example.shop_detail.application.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.shop_detail.application.GoodsApplication;
import com.example.shop_detail.exception.CustomizeException;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.param.AddGoodsParam;
import com.example.shop_detail.param.GoodsSearchParam;
import com.example.shop_detail.param.UpdateGoodsNumParam;
import com.example.shop_detail.param.UpdateGoodsParam;
import com.example.shop_detail.service.GoodsService;
import com.example.shop_detail.vo.GoodsSearchVO;
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
    public GoodsSearchVO goodsSearch(GoodsSearchParam param, IPage<Goods> goodsIPage) {
        GoodsSearchVO result = new GoodsSearchVO();
        IPage<Goods> goods = goodsService.goodsSearch(param.getGoodsName(), goodsIPage);
        result.setTotal(goods.getTotal());
        result.setGoodsList(goods.getRecords());
        return result;
    }

    @Override
    public void addGoods(AddGoodsParam param) {
        Goods goods = new Goods();
        goods.setGoodsName(param.getGoodsName());
        goods.setGoodsNum(param.getGoodsNum());
        goods.setGoodsDescription(param.getGoodsDescription());
        goods.setGoodsPrice(param.getGoodsPrice());
        goodsService.saveOrUpdate(goods);
    }

    @Override
    public void deleteGoods(Long goodsId) {
        Goods goods = goodsService.findByGoodsId(goodsId);
        if (goods == null) {
            throw new CustomizeException("商品为空");
        }
        goodsService.removeById(goodsId);
    }

    @Override
    public void updateGoods(UpdateGoodsParam param) {
        Goods goods = goodsService.findByGoodsId(param.getGoodsId());
        if (goods == null) {
            throw new CustomizeException("商品为空");
        }
        goods.setGoodsNum(param.getGoodsNum());
        goods.setGoodsPrice(param.getGoodsPrice());
        goods.setGoodsDescription(param.getGoodsDescription());
        goods.setGoodsName(param.getGoodsName());
        goodsService.saveOrUpdate(goods);
    }

    @Override
    public void updateGoodsNum(UpdateGoodsNumParam param) {
        Goods goods = goodsService.findByGoodsId(param.getGoodsId());
        if (goods == null) {
            throw new CustomizeException("商品为空");
        }
        goods.setGoodsNum(param.getGoodsNum());
        goodsService.saveOrUpdate(goods);
    }
}
