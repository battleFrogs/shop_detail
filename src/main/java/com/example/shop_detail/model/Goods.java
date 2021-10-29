package com.example.shop_detail.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;


/**
 * (Goods)实体类
 *
 * @author makejava
 * @since 2021-10-28 16:37:58
 */
@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = -96919985935747311L;
    /**
     * 商品Id
     */
    @TableId
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