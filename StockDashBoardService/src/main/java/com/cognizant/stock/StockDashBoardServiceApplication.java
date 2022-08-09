package com.cognizant.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class StockDashBoardServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockDashBoardServiceApplication.class, args);
	}
}