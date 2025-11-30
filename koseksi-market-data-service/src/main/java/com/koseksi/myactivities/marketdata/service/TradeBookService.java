package com.koseksi.myactivities.marketdata.service;

import java.util.Map;
import java.util.Set;

import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;
import com.koseksi.myactivities.marketdata.dtos.response.TradeBookPage;

public interface TradeBookService {

	public TradeBookDto getTradeBookById(Long tradeId);
	
	public TradeBookPage getAllTrades(int pageIndex, int pageSize);
	
	public Map<String, Set<String>> getFilterValues();
}
