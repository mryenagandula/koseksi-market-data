package com.koseksi.myactivities.marketdata.service;

import java.util.List;

import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;
import com.koseksi.myactivities.marketdata.dtos.request.TradeBookFilterRequest;

public interface TradeBookService {

	public TradeBookDto getTradeBookById(Long tradeId);
	
	public List<TradeBookDto> getAllTrades(Long pageId, Long pageIndex, TradeBookFilterRequest tradeBookFilterRequest);
}
