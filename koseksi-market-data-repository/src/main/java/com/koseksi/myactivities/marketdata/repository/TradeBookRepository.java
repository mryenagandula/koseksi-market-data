package com.koseksi.myactivities.marketdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koseksi.myactivities.marketdata.domain.TradeBook;
import com.koseksi.myactivities.marketdata.repository.custom.TradeBookCustomRepo;

public interface TradeBookRepository extends JpaRepository<TradeBook, Long>,TradeBookCustomRepo{
	// QuerydslPredicateExecutor<TradeBook>, 
	
}