package com.koseksi.myactivities.marketdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@EntityScan(basePackages = "com.koseksi.myactivities.marketdata.domain")
//@EnableJpaRepositories(basePackages = "com.koseksi.myactivities.marketdata.repository")
//@ComponentScan(basePackages = {"com.koseksi.myactivities.marketdata.repository.*", "com.koseksi.myactivities.marketdata.service.*"})
public class KoseksiMarketDataApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(KoseksiMarketDataApplication.class, args);
	}
}