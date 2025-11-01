package com.koseksi.myactivities.marketdata.dtos;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TradeBookDto {

private Long id;
	
	private String symbol;
	
	private String isin;
	
	@JsonDeserialize(using=LocalDateDeserializer.class)
	@JsonSerialize(using= LocalDateSerializer.class)
	private LocalDate tradeDate;
	
	private String exchange;
	
	private String segment;
	
	private String series;
	
	private String tradeType;
	
	private Integer auction;
	
	private Integer quantity;
	
	private Double price;
	
	private BigInteger tradeId;
	
	private BigInteger orderId;
	
	private LocalDateTime orderExecutionTime;
}
