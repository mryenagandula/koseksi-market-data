package com.koseksi.myactivities.marketdata.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradeBookFilterRequest {
	
	private String symbol;
	private String isin;

}
