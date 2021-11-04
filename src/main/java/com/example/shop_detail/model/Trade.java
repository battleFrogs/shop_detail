package com.example.shop_detail.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;


/**
 * (Trade)实体类
 *
 * @author makejava
 * @since 2021-10-29 15:50:05
 */
@Data
public class Trade implements Serializable {
    private static final long serialVersionUID = -57740557432954262L;
    /**
     * 主键Id
     */
    @TableId
    private Long tradeId;
    /**
     * 订单编号
     */
    private String tradeNo;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 订单价钱
     */
    private Long total;
    /**
     * 订单类型
     */
    private String tradeStatus;

}