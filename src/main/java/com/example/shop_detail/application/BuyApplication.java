package com.example.shop_detail.application;

public interface BuyApplication {


    void createTradeNoPay(Long goodsId, Integer num);

    void createTradePay(Long goodsId, Integer num);

}
