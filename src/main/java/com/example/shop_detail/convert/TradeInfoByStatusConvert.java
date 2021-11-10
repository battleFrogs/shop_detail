package com.example.shop_detail.convert;

import cn.hutool.core.date.DateUtil;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.vo.TradeInfoByStatusVO;

import java.util.ArrayList;
import java.util.List;

public class TradeInfoByStatusConvert {

    public static List<TradeInfoByStatusVO> doToVo(List<Trade> tradeList) {

        List<TradeInfoByStatusVO> list = new ArrayList<>();
        for (Trade trade : tradeList) {
            TradeInfoByStatusVO vo = new TradeInfoByStatusVO();
            vo.setTradeNo(trade.getTradeNo());
            vo.setGoodsName(trade.getGoodsName());
            vo.setTotal(trade.getTotal());
            vo.setTradeStatus(trade.getTradeStatus());
            vo.setCreateTime(DateUtil.formatTime(trade.getCreateTime()));
            vo.setUpdateTime(DateUtil.formatTime(trade.getUpdateTime()));
            vo.setPayTime(trade.getPayTime() != null ? DateUtil.formatDateTime(trade.getPayTime()) : "");
            vo.setSendTime(trade.getSendTime() != null ? DateUtil.formatDateTime(trade.getSendTime()) : "");
            vo.setReceiveTime(trade.getReceiveTime() != null ? DateUtil.formatDateTime(trade.getReceiveTime()) : "");

            list.add(vo);
        }
        return list;
    }
}
