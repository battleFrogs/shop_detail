package com.example.shop_detail.controller;

import com.example.shop_detail.application.GoodsApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.model.Goods;
import com.example.shop_detail.param.AddGoodsParam;
import com.example.shop_detail.param.GoodsSearchParam;
import com.example.shop_detail.param.UpdateGoodsNumParam;
import com.example.shop_detail.param.UpdateGoodsParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsApplication goodsApplication;


    /**
     * 前台商品列表搜索
     */
    @RequestMapping("/goodsSearch")
    public ResultData goodsSearch(@RequestBody @Valid GoodsSearchParam param) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        List<Goods> goodsList = goodsApplication.goodsSearch(param);
        resultData.addData("goodsList", goodsList);
        return resultData;
    }

    /**
     * 后台添加商品
     */
    @RequestMapping("/addGoods")
    public ResultData addGoods(@RequestBody @Valid AddGoodsParam param) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        goodsApplication.addGoods(param);
        return resultData;
    }

    /**
     * 后台删除商品
     */
    @RequestMapping("/deleteGoods")
    public ResultData deleteGoods(Long goodsId) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        goodsApplication.deleteGoods(goodsId);
        return resultData;
    }


    /**
     * 后台修改商品
     */
    @RequestMapping("/updateGoods")
    public ResultData updateGoods(@RequestBody @Valid UpdateGoodsParam param) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        goodsApplication.updateGoods(param);
        return resultData;
    }


    /**
     * 后台修改商品数目
     */
    @RequestMapping("/updateGoodsNum")
    public ResultData updateGoodsNum(@RequestBody @Valid UpdateGoodsNumParam param) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        goodsApplication.updateGoodsNum(param);
        return resultData;
    }


}
