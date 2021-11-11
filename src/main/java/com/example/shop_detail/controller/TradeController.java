package com.example.shop_detail.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.shop_detail.application.TradeApplication;
import com.example.shop_detail.common.ResultData;
import com.example.shop_detail.common.ResultEnum;
import com.example.shop_detail.convert.TradeInfoByStatusConvert;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.param.TradeExportParam;
import com.example.shop_detail.param.TradeInfoByStatusParam;
import com.example.shop_detail.utils.HttpUtils;
import com.example.shop_detail.vo.TradeInfoByStatusVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {

    @Resource
    private TradeApplication tradeApplication;

    /**
     * 查询订单状态信息
     *
     * @param tradeInfoByStatusParam 订单参数
     * @return 订单页面
     */
    @RequestMapping("/tradeInfoByStatus")
    public ResultData tradeInfoByStatus(@RequestBody @Valid TradeInfoByStatusParam tradeInfoByStatusParam) {
        ResultData resultData = new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
        IPage<Trade> tradeIPage = new Page<>(tradeInfoByStatusParam.getPage(), tradeInfoByStatusParam.getPageSize());
        TradeInfoByStatusVO result = tradeApplication.tradeInfo(tradeInfoByStatusParam, tradeIPage);
        resultData.addData("tradeList", result.getTradeList());
        resultData.addData("total", result.getTotal());
        return resultData;
    }

    /**
     * 创建订单未支付
     *
     * @param goodsId 商品Id
     * @param num     数目
     * @return resultData
     */
    @RequestMapping("/createTradeNoPay")
    public ResultData createTradeNoPay(Long goodsId, Integer num) {
        tradeApplication.createTradeNoPay(goodsId, num);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }

    /**
     * 创建订单支付
     *
     * @param goodsId 商品Id
     * @param num     数目
     * @return resultData
     */
    @RequestMapping("/createTradePay")
    public ResultData createTradePay(Long goodsId, Integer num) {
        tradeApplication.createTradePay(goodsId, num);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * 订单发货
     *
     * @param tradeNo 订单号
     * @return resultData
     */
    @RequestMapping("/tradeSend")
    public ResultData tradeSend(String tradeNo) {
        tradeApplication.tradeSend(tradeNo);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }

    /**
     * 订单付款
     *
     * @param tradeNo 订单号
     * @return resultData
     */
    @RequestMapping("/tradePay")
    public ResultData tradePay(String tradeNo) {
        tradeApplication.tradePay(tradeNo);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }


    /**
     * 订单确认收货
     *
     * @param tradeNo 订单号
     * @return resultData
     */
    @RequestMapping("/tradeReceive")
    public ResultData tradeReceive(String tradeNo) {
        tradeApplication.tradeReceive(tradeNo);
        return new ResultData(ResultEnum.SUCCESS.getCode(), "成功");
    }

}
