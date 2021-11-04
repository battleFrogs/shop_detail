package com.example.shop_detail.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.shop_detail.model.Trade;
import com.example.shop_detail.mapper.TradeMapper;
import com.example.shop_detail.service.TradeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

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
    public List<Trade> tradeInfo(String tradeStatus) {
        return this.lambdaQuery()
                .eq(StringUtils.isNotBlank(tradeStatus), Trade::getTradeStatus, tradeStatus)
                .list();
    }
}