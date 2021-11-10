package com.example.shop_detail.vo;

import com.example.shop_detail.model.Trade;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TradeInfoByStatusVO {

    private Long total;
    private List<Trade> tradeList;


}
