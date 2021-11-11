package com.example.shop_detail.application;

import com.example.shop_detail.param.TradeExportParam;

import java.io.IOException;

public interface ExportApplication {


    void tradeExport(TradeExportParam param) throws IOException;
}
