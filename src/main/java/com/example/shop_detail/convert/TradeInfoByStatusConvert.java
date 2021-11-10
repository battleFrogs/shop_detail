package com.example.shop_detail.convert;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.vo.TradeInfoByStatusVO;

import java.util.ArrayList;
import java.util.List;

public class TradeInfoByStatusConvert {

    public static TradeInfoByStatusVO doToVo(IPage<Trade> tradeIPage) {

        TradeInfoByStatusVO result = new TradeInfoByStatusVO();
        List<TradeInfoByStatusVO.TradeBeanVO> resultBeanList = new ArrayList<>();
        result.setTotal(tradeIPage.getTotal());
        result.setTradeList(resultBeanList);
        for (Trade trade : tradeIPage.getRecords()) {
            TradeInfoByStatusVO.TradeBeanVO vo = new TradeInfoByStatusVO.TradeBeanVO();
            vo.setTradeNo(trade.getTradeNo());
            vo.setGoodsName(trade.getGoodsName());
            vo.setTotal(trade.getTotal());
            vo.setTradeStatus(trade.getTradeStatus());
            vo.setCreateTime(DateUtil.formatTime(trade.getCreateTime()));
            vo.setUpdateTime(DateUtil.formatTime(trade.getUpdateTime()));
            vo.setPayTime(trade.getPayTime() != null ? DateUtil.formatDateTime(trade.getPayTime()) : "");
            vo.setSendTime(trade.getSendTime() != null ? DateUtil.formatDateTime(trade.getSendTime()) : "");
            vo.setReceiveTime(trade.getReceiveTime() != null ? DateUtil.formatDateTime(trade.getReceiveTime()) : "");

            resultBeanList.add(vo);
        }
        return result;
    }
}
