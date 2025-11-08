package com.koseksi.myactivities.marketdata.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koseksi.myactivities.marketdata.domain.TradeBook;
import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;
import com.koseksi.myactivities.marketdata.dtos.request.TradeBookFilterRequest;
import com.koseksi.myactivities.marketdata.repository.TradeBookRepository;
import com.koseksi.myactivities.marketdata.service.TradeBookService;

@Service
public class TradeBookServiceImpl implements TradeBookService{
	
	@Autowired
	private TradeBookRepository tradeBookRepository;

	@Override
	public TradeBookDto getTradeBookById(Long tradeId) {
		TradeBookDto tradeBookDto = new TradeBookDto();
		TradeBook tradeBook;
		try {
			tradeBook = tradeBookRepository.findById(tradeId)
					.orElseThrow(() -> new Exception("Record :: "+tradeId+"Is not found"));
			if(tradeBook != null) {
				BeanUtils.copyProperties(tradeBook, tradeBookDto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tradeBookDto;
	}

	@Override
	public List<TradeBookDto> getAllTrades(Long pageId, Long pageIndex, TradeBookFilterRequest tradeBookFilterRequest) {
		// TODO Auto-generated method stub
		List<TradeBook> records = tradeBookRepository.findAllTrades(pageIndex, pageId, tradeBookFilterRequest);
		List<TradeBookDto> rBookDtos = null;
		BeanUtils.copyProperties(rBookDtos, records);
		return rBookDtos;
	}

}
