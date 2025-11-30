package com.koseksi.myactivities.marketdata.repository.custom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koseksi.myactivities.marketdata.domain.QTradeBook;
import com.koseksi.myactivities.marketdata.domain.TradeBook;
import com.koseksi.myactivities.marketdata.repository.custom.TradeBookCustomRepo;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;

@Component
public class TradeBookCustomRepoImpl implements TradeBookCustomRepo {

	@Autowired
	private EntityManager entityManager;
	private final QTradeBook qTradeBook = QTradeBook.tradeBook;

	@Override
	public List<TradeBook> findAllTrades(int pageIndex, int pageSize) {
		return new JPAQuery<TradeBook>(entityManager)
				.from(qTradeBook)
				.distinct()
				.offset(pageIndex * pageSize)
				.limit(pageSize)
				.fetch();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Long countOfAllTrades() {
		return new JPAQuery<TradeBook>(entityManager).from(qTradeBook).fetchCount();
	}

}
