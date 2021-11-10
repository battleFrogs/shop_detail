package com.example.shop_detail.vo;

import com.example.shop_detail.model.Goods;
import lombok.Data;

import java.util.List;

@Data
public class GoodsSearchVO {

    private Long total;
    private List<Goods> goodsList;

}
