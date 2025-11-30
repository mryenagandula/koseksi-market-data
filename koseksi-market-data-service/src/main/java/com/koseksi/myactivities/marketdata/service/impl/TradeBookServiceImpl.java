package com.koseksi.myactivities.marketdata.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koseksi.myactivities.marketdata.domain.TradeBook;
import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;
import com.koseksi.myactivities.marketdata.dtos.response.TradeBookPage;
import com.koseksi.myactivities.marketdata.repository.TradeBookRepository;
import com.koseksi.myactivities.marketdata.service.TradeBookService;
import com.koseksi.myactivities.marketdata.service.processor.TradeBookProcessor;

import jakarta.persistence.Tuple;

@Service
public class TradeBookServiceImpl implements TradeBookService{
	
	@Autowired
	private TradeBookRepository tradeBookRepository;
	
	@Autowired
	private TradeBookProcessor tradeBookProcessor;

	@Override
	public TradeBookDto getTradeBookById(Long tradeId) {
		try {
			return tradeBookProcessor.postProcess(tradeBookRepository.findById(tradeId)
						.orElseThrow(() -> new Exception("Record :: "+tradeId+"Is not found")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TradeBookPage getAllTrades(int pageIndex, int pageSize) {
		List<TradeBook> records = tradeBookRepository.findAllTrades(pageIndex, pageSize);
		Long allRecordsCount =  tradeBookRepository.countOfAllTrades();

		return TradeBookPage.builder()
				.trades(tradeBookProcessor.postProcess(records))
				.count(allRecordsCount)
				.build();
	}
	
	@Override
	public Map<String, Set<String>> getFilterValues() {
		List<Tuple> tuples = tradeBookRepository.getAllFilterValues();
		Map<String, Set<String>> resultMap = new HashMap<>();
		Set<String> symbolsSet = new HashSet<>();
		Set<String> exchangeNameSet = new HashSet<>();
		Set<String> isinSet = new HashSet<>();
		Set<String> tradeTypeSet = new HashSet<>();
		tuples.stream().forEach(row ->{
			symbolsSet.add(String.valueOf(row.get("SYMBOL_NAME")));
			exchangeNameSet.add( String.valueOf(row.get("EXCHANGE_NAME")));
			isinSet.add(String.valueOf(row.get("ISIN")));
			tradeTypeSet.add(String.valueOf(row.get("TRADE_TYPE")));
		});
		resultMap.put("symbols", symbolsSet);
		resultMap.put("exchanges", exchangeNameSet);
		resultMap.put("isin", isinSet);
		resultMap.put("tradeTypes", tradeTypeSet);
		return resultMap;
	}
	
	/* Old Logic of getAllTrades*/
	public TradeBookPage getAllTradesOld(int pageIndex, int pageSize) {
		List<TradeBook> records = tradeBookRepository.findAllTrades(pageIndex, pageSize);
		Long allRecordsCount =  tradeBookRepository.countOfAllTrades();
		List<TradeBookDto> rBookDtos = records.stream().map(trade->{
			TradeBookDto tradeBookDto = new TradeBookDto();
			BeanUtils.copyProperties(trade, tradeBookDto);
			return tradeBookDto;
		}).toList();
		return TradeBookPage.builder()
				.trades(rBookDtos)
				.count(allRecordsCount)
				.build();	
	}

	/* Old Logic of getTradeBookById*/
	public TradeBookDto getTradeBookByIdOld(Long tradeId) {
		TradeBookDto tradeBookDto = new TradeBookDto();
		TradeBook tradeBook;
		try {
			tradeBook = tradeBookRepository.findById(tradeId)
					.orElseThrow(() -> new Exception("Record :: "+tradeId+"Is not found"));
			if(tradeBook != null) {
				BeanUtils.copyProperties(tradeBook, tradeBookDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tradeBookDto;
	}
}
