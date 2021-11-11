package com.example.shop_detail.controller;

import com.example.shop_detail.application.ExportApplication;
import com.example.shop_detail.param.TradeExportParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class ExportController {


    @Resource
    private ExportApplication exportApplication;

    @RequestMapping("/tradeExport")
    public void tradeExport(TradeExportParam param) throws IOException {
        exportApplication.tradeExport(param);
    }

}
