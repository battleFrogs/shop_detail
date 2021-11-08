package com.example.shop_detail.param;

import lombok.Data;

import java.util.Date;

/**
 * @author Gjc
 */
@Data
public class TradeInfoByStatusParam {

    private String tradeStatus ;
    private Date beginTime;
    private Date endTime;

}
