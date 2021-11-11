package com.example.shop_detail.application.impl;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.shop_detail.application.ExportApplication;
import com.example.shop_detail.convert.TradeExportConvert;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.param.TradeExportParam;
import com.example.shop_detail.service.TradeService;
import com.example.shop_detail.utils.HttpUtils;
import com.example.shop_detail.vo.TradeExportVO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Service
public class ExportApplicationImpl implements ExportApplication {

    @Resource
    private TradeService tradeService;

    @Override
    public void tradeExport(@RequestBody @Valid TradeExportParam param) throws IOException {
        List<Trade> trades = tradeService.tradeInfo(param.getTradeStatus(), param.getBeginTime(), param.getEndTime());
        List<TradeExportVO> rows = TradeExportConvert.doToVo(trades);
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.addHeaderAlias("tradeNo", "订单编号");
        writer.addHeaderAlias("goodsName", "商品名称");
        writer.addHeaderAlias("total", "订单价钱");
        writer.addHeaderAlias("tradeStatus", "订单类型");
        writer.addHeaderAlias("createTime", "创建时间");
        writer.addHeaderAlias("updateTime", "修改时间");
        writer.addHeaderAlias("payTime", "支付时间");
        writer.addHeaderAlias("sendTime", "发货时间");
        writer.addHeaderAlias("receiveTime", "收货时间");
        writer.setOnlyAlias(true);
        writer.merge(8, "订单信息");
        writer.write(rows, true);
        writer.flush(HttpUtils.getResponse().getOutputStream());
        writer.close();
    }

}
