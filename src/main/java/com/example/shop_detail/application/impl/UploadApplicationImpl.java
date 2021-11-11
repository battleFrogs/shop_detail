package com.example.shop_detail.application.impl;

import cn.hutool.poi.excel.ExcelReader;
import com.example.shop_detail.application.UploadApplication;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class UploadApplicationImpl implements UploadApplication {

    @Resource
    private GoodsService goodsService;

    @Override
    public void upload(MultipartFile file) throws IOException {

        ExcelReader excelReader = new ExcelReader(file.getInputStream(), 0);
        List<Goods> goodsList = excelReader.readAll(Goods.class);
        goodsService.saveBatch(goodsList);

    }
}
