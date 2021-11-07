package com.example.shop_detail.controller;

import cn.hutool.core.util.RandomUtil;
import com.example.shop_detail.application.GoodsApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.utils.HttpUtils;
import com.example.shop_detail.vo.Result;
import com.zaxxer.hikari.util.FastList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsApplication goodsApplication;

    /**
     * 前台商品列表页面
     *
     * @return 前台商品列表页
     */
    @RequestMapping("/goodsInfo")
    public String goodsInfo() {
        List<Goods> goodsList = goodsApplication.goodsInfo();
        HttpUtils.getRequest().setAttribute("goodsList", goodsList);
        return "jsp/front/goods";
    }

    /**
     * 前台商品列表搜索
     *
     * @return 前台商品列表页
     */
    @RequestMapping("/goodsSearch")
    @ResponseBody
    public ResultData goodsSearch(String goodsName) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        List<Goods> goodsList = goodsApplication.goodsSearch(goodsName);
        resultData.addData("goodsList", goodsList);
        return resultData;
    }


}
