package com.example.shop_detail.param;

import lombok.Data;

@Data
public class AddGoodsParam {

    private String goodsName;
    private Long goodsPrice;
    private Long goodsNum;
    private String goodsDescription;

}
