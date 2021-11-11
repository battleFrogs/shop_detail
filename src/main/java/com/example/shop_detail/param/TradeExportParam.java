package com.example.shop_detail.param;

import lombok.Data;

import java.util.Date;

@Data
public class TradeExportParam {

    private String tradeStatus;
    private Date beginTime;
    private Date endTime;

}
