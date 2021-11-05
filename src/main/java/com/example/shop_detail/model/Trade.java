package com.example.shop_detail.model;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;


/**
 * (Trade)实体类
 *
 * @author makejava
 * @since 2021-11-04 17:43:29
 */
@Data
public class Trade implements Serializable {
    private static final long serialVersionUID = 168825058366324330L;
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 支付时间
     */
    private Date payTime;
    /**
     * 发货时间
     */
    private Date sendTime;
    /**
     * 收货时间
     */
    private Date receiveTime;

}