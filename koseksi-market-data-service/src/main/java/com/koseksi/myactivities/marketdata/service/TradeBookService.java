package com.koseksi.myactivities.marketdata.service;

import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;

public interface TradeBookService {

	public TradeBookDto getTradeBookById(Long tradeId);
}
