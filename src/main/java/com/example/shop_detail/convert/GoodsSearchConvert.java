package com.example.shop_detail.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.vo.GoodsSearchVO;

import java.util.ArrayList;
import java.util.List;

public class GoodsSearchConvert {

    public static GoodsSearchVO doToVo(IPage<Goods> goodsIPage) {
        GoodsSearchVO result = new GoodsSearchVO();
        List<GoodsSearchVO.GoodsBean> resultBeanList = new ArrayList<>();
        result.setTotal(goodsIPage.getTotal());
        result.setGoodsList(resultBeanList);
        for (Goods goods : goodsIPage.getRecords()) {
            GoodsSearchVO.GoodsBean goodsBean = new GoodsSearchVO.GoodsBean();
            goodsBean.setGoodsId(goods.getGoodsId());
            goodsBean.setGoodsName(goods.getGoodsName());
            goodsBean.setGoodsNum(goods.getGoodsNum());
            goodsBean.setGoodsDescription(goods.getGoodsDescription());
            goodsBean.setGoodsPrice(goods.getGoodsPrice());
            resultBeanList.add(goodsBean);
        }
        return result;

    }

}
