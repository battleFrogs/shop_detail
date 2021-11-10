package com.example.shop_detail.vo;

import com.example.shop_detail.model.Trade;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TradeInfoByStatusVO {

    private Long total;
    private List<TradeBeanVO> tradeList;


    @Data
    public static class TradeBeanVO {
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
        private String createTime;
        /**
         * 修改时间
         */
        private String updateTime;
        /**
         * 支付时间
         */
        private String payTime;
        /**
         * 发货时间
         */
        private String sendTime;
        /**
         * 收货时间
         */
        private String receiveTime;

    }




}
