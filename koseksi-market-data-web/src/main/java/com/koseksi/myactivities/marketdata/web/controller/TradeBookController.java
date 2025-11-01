package com.koseksi.myactivities.marketdata.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;
import com.koseksi.myactivities.marketdata.service.TradeBookService;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController
@RequestMapping("/trade-book")
public class TradeBookController{
	
	@Autowired
	private TradeBookService tradeBookService;
	
	@GetMapping("/allTrades")
	public List<String> getAllTradeBookRecords(){
		return List.of();
	}
	
	@GetMapping("/getTradeById/{tradeId}")
	public TradeBookDto getTradeBookById(@PathVariable("tradeId") Long tradeId) {
		return tradeBookService.getTradeBookById(tradeId);
	}
}