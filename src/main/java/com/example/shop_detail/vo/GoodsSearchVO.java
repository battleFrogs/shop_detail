package com.example.shop_detail.vo;

import com.example.shop_detail.model.Goods;
import lombok.Data;

import java.util.List;

@Data
public class GoodsSearchVO {

    private Long total;
    private List<GoodsBean> goodsList;

    @Data
    public static class GoodsBean {

        private Long goodsId;
        /**
         * 商品名称
         */
        private String goodsName;
        /**
         * 商品数目
         */
        private Long goodsNum;
        /**
         * 商品描述
         */
        private String goodsDescription;
        /**
         * 商品价格
         */
        private Long goodsPrice;

    }

}
