package com.example.shop_detail.param;

import lombok.Data;

@Data
public class GoodsSearchParam {

    private String goodsName;
    private Long page;
    private Long pageSize;

}
