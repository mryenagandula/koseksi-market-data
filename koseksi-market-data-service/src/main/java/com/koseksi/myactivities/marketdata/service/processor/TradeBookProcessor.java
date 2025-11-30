package com.koseksi.myactivities.marketdata.service.processor;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import com.koseksi.myactivities.marketdata.domain.TradeBook;
import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;

@Component
public class TradeBookProcessor{
	
	@Autowired
	@Qualifier("tradeBookModelMapper")
	public ModelMapper modelMapper;
	
	public TradeBookDto postProcess(TradeBook tradeBook) {
		return this.postProcess(List.of(tradeBook)).get(0);
	}
	
	public List<TradeBookDto> postProcess(List<TradeBook> tradeBooks){
		
		List<Pair<TradeBook, TradeBookDto>> tradeList = tradeBooks.stream()
				.map(tradeBook -> Pair.of(tradeBook, modelMapper.map(tradeBook, TradeBookDto.class)))
				.collect(Collectors.toList());
		
		return tradeList.stream()
				.map((Pair<TradeBook, TradeBookDto> pair) -> processItems(pair))
				.collect(Collectors.toList());
	}

	private TradeBookDto processItems(Pair<TradeBook, TradeBookDto> pair) {
		TradeBookDto tradeBookDto  = pair.getSecond();
		return tradeBookDto;
	}
	
	
}