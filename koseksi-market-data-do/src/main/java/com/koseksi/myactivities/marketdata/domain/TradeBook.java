package com.koseksi.myactivities.marketdata.domain;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
@Entity
public class TradeBook {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
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
