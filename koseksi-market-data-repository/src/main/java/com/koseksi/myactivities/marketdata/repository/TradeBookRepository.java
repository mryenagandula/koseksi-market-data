package com.koseksi.myactivities.marketdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.koseksi.myactivities.marketdata.domain.TradeBook;
import com.koseksi.myactivities.marketdata.repository.custom.TradeBookCustomRepo;
import jakarta.persistence.Tuple;
import java.util.List;


public interface TradeBookRepository extends JpaRepository<TradeBook, Long>,QuerydslPredicateExecutor<TradeBook>, TradeBookCustomRepo{
 
	@Query(
			value = "SELECT DISTINCT TB.SYMBOL AS SYMBOL_NAME, TB.EXCHANGE AS EXCHANGE_NAME, TB.ISIN AS ISIN, TB.TRADE_TYPE AS TRADE_TYPE FROM TRADE_BOOK TB ORDER BY TB.SYMBOL",
			nativeQuery=true
		)
	public List<Tuple> getAllFilterValues();
}