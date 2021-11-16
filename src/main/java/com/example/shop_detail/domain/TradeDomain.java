package com.example.shop_detail.domain;

import com.example.shop_detail.model.Trade;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class TradeDomain {


    private TradeStatus tradeStatus;


    @Getter
    public enum TradeStatus {

        /**
         * 订单状态
         */
        WAIT_PAY("待付款", "WAIT_PAY", 10),
        WAIT_SEND("待发货", "WAIT_SEND", 30),
        WAIT_RECEIVE("待收货", "WAIT_RECEIVE", 80),
        CLOSE("已关闭", "CLOSE", 150),
        FINISH("完成", "FINISH", 200),
        ;

        private final String name;
        private final String value;
        private final Integer code;

        TradeStatus(String name, String value, Integer code) {
            this.name = name;
            this.value = value;
            this.code = code;
        }

        public static String getName(String value) {
            TradeStatus[] values = TradeStatus.values();
            for (TradeStatus tradeStatus : values) {
                if (tradeStatus.getValue().equals(value)) {
                    return tradeStatus.getName();
                }
            }
            return "";
        }

        public static TradeStatus getEnum(String value) {
            TradeStatus[] values = TradeStatus.values();
            for (TradeStatus tradeStatus : values) {
                if (tradeStatus.getValue().equals(value)) {
                    return tradeStatus;
                }
            }
            return null;
        }

    }


}
