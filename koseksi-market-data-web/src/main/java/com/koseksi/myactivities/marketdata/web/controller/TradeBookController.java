package com.koseksi.myactivities.marketdata.web.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;
import com.koseksi.myactivities.marketdata.dtos.response.TradeBookPage;
import com.koseksi.myactivities.marketdata.service.TradeBookService;

@RestController
@RequestMapping("/trade-book")
public class TradeBookController{
	
	@Autowired
	private TradeBookService tradeBookService;
	
	@GetMapping("/allTrades")
	public TradeBookPage getAllTradeBookRecords(
			@RequestParam(value="pageIndex")int pageIndex, 
			@RequestParam(value="pageSize")int pageSize){
		return tradeBookService.getAllTrades(pageIndex, pageSize);
	}
	
	@GetMapping("/getTradeById/{tradeId}")
	public TradeBookDto getTradeBookById(@PathVariable("tradeId") Long tradeId) {
		return tradeBookService.getTradeBookById(tradeId);
	}
	
	@GetMapping("/getTradeFilterValues")
	public Map<String, Set<String>> getFilterValues(){
		return tradeBookService.getFilterValues();
	}
}