package com.example.shop_detail.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.mapper.TradeMapper;
import com.example.shop_detail.service.TradeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * (Trade)
 *
 * @author makejava
 * @since 2021-10-29 15:50:06
 */
@Service
public class TradeServiceImpl extends ServiceImpl<TradeMapper, Trade>
        implements TradeService {

    @Override
    public IPage<Trade> tradeInfo(String tradeStatus, Date beginTime, Date endTime, IPage<Trade> tradeIPage) {
        return this.lambdaQuery()
                .eq(StringUtils.isNotBlank(tradeStatus), Trade::getTradeStatus, tradeStatus)
                .gt(beginTime != null, Trade::getPayTime, beginTime)
                .lt(endTime != null, Trade::getPayTime, endTime)
                .page(tradeIPage);
    }

    @Override
    public List<Trade> tradeInfo(String tradeStatus, Date beginTime, Date endTime) {
        return this.lambdaQuery()
                .eq(StringUtils.isNotBlank(tradeStatus), Trade::getTradeStatus, tradeStatus)
                .gt(beginTime != null, Trade::getPayTime, beginTime)
                .lt(endTime != null, Trade::getPayTime, endTime)
                .list();
    }

    @Override
    public Trade findByTradeNo(String tradeNo) {
        return this.lambdaQuery()
                .eq(Trade::getTradeNo, tradeNo)
                .one();
    }

}