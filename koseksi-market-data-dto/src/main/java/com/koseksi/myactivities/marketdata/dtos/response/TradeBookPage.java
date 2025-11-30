package com.koseksi.myactivities.marketdata.dtos.response;

import java.util.List;

import com.koseksi.myactivities.marketdata.dtos.TradeBookDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeBookPage {

	private List<TradeBookDto> trades;
	private Long count;
	
}
