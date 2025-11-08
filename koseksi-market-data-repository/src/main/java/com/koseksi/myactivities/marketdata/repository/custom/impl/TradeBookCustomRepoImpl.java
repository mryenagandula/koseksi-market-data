package com.koseksi.myactivities.marketdata.repository.custom.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koseksi.myactivities.marketdata.domain.QTradeBook;
import com.koseksi.myactivities.marketdata.domain.TradeBook;
import com.koseksi.myactivities.marketdata.dtos.request.TradeBookFilterRequest;
import com.koseksi.myactivities.marketdata.repository.custom.TradeBookCustomRepo;

import jakarta.persistence.EntityManager;


@Component
public class TradeBookCustomRepoImpl implements TradeBookCustomRepo {
	
	@Autowired
	private EntityManager entityManager;
	private final QTradeBook qTradeBook = QTradeBook.tradeBook;
	
	@Override
	public List<TradeBook> findAllTrades(Long pageIndex, Long pageSize, TradeBookFilterRequest tradeBookFilterRequest) {
		// TODO Auto-generated method stub
		return List.of();
	}

}
