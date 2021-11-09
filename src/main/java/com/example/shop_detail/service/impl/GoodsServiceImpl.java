package com.example.shop_detail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.mapper.GoodsMapper;
import com.example.shop_detail.service.GoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Goods)
 *
 * @author makejava
 * @since 2021-10-28 16:37:58
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
        implements GoodsService {

    @Override
    public List<Goods> goodsSearch(String goodsName) {
        return this.lambdaQuery()
                .eq(StringUtils.isNotBlank(goodsName), Goods::getGoodsName, goodsName)
                .list();
    }

    @Override
    public Goods findByGoodsId(Long goodsId) {
        return this.lambdaQuery()
                .eq(Goods::getGoodsId, goodsId)
                .one();
    }
}