package com.koseksi.myactivities.marketdata.repository.custom;

import java.util.List;
import com.koseksi.myactivities.marketdata.domain.TradeBook;
import com.koseksi.myactivities.marketdata.dtos.request.TradeBookFilterRequest;

public interface TradeBookCustomRepo {
	
	public List<TradeBook> findAllTrades(Long pageIndex, Long pageSize, TradeBookFilterRequest tradeBookFilterRequest);

}
