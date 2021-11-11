package com.example.shop_detail.convert;

import cn.hutool.core.date.DateUtil;
import com.example.shop_detail.domain.TradeDomain;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.vo.TradeExportVO;

import java.util.ArrayList;
import java.util.List;

public class TradeExportConvert {

    public static List<TradeExportVO> doToVo(List<Trade> tradeList) {

        List<TradeExportVO> tradeExportVOS = new ArrayList<>();
        for (Trade trade : tradeList) {
            TradeExportVO tradeExportVO = new TradeExportVO();
            tradeExportVO.setTradeNo(trade.getTradeNo());
            tradeExportVO.setGoodsName(trade.getGoodsName());
            tradeExportVO.setTotal(trade.getTotal());
            tradeExportVO.setTradeStatus(TradeDomain.TradeStatus.getName(trade.getTradeStatus()));
            tradeExportVO.setCreateTime(DateUtil.formatDateTime(trade.getCreateTime()));
            tradeExportVO.setUpdateTime(DateUtil.formatDateTime(trade.getUpdateTime()));
            tradeExportVO.setPayTime(trade.getPayTime() == null ? "" : DateUtil.formatDateTime(trade.getPayTime()));
            tradeExportVO.setSendTime(trade.getSendTime() == null ? "" : DateUtil.formatDateTime(trade.getSendTime()));
            tradeExportVO.setReceiveTime(trade.getReceiveTime() == null ? "" : DateUtil.formatDateTime(trade.getReceiveTime()));

            tradeExportVOS.add(tradeExportVO);
        }

        return tradeExportVOS;
    }

}
