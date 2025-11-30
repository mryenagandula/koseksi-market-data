package com.koseksi.myactivities.marketdata.repository.custom;

import java.util.List;

import com.koseksi.myactivities.marketdata.domain.TradeBook;

public interface TradeBookCustomRepo {
	
	public List<TradeBook> findAllTrades(int pageIndex, int pageSize);
	public Long countOfAllTrades();

}
