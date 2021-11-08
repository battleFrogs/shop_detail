package com.example.shop_detail.controller;

import com.example.shop_detail.application.GoodsApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.param.GoodsSearchParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsApplication goodsApplication;


    /**
     * 前台商品列表搜索
     *
     * @return 前台商品列表页
     */
    @RequestMapping("/goodsSearch")
    public ResultData goodsSearch(GoodsSearchParam param) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        List<Goods> goodsList = goodsApplication.goodsSearch(param);
        resultData.addData("goodsList", goodsList);
        return resultData;
    }


}
