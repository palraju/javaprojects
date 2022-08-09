package com.cognizant.stock.resources;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StockDashBoardResource {
	
	 @Bean
     @LoadBalanced
     RestTemplate restTemplate() {
           return new RestTemplate();
     }

     @Autowired
     RestTemplate restTemplate;
	
	@RequestMapping("/stock/findAll")
	@HystrixCommand(fallbackMethod="fallBackFindAll")
	public Collection<Stock> findAll() {
		StockServiceResponse responseObject = restTemplate.getForObject("http://stock-search/stock/findAll", StockServiceResponse.class);
		return responseObject.getDataList();
	}
	
	public Collection<Stock> fallBackFindAll() {
		Collection<Stock> stockCollection= new ArrayList<Stock>();
		Stock responseObject = new Stock();
		responseObject.setScripCode("DFLT");
		responseObject.setCompanyName("Default Tech Company");
		stockCollection.add(responseObject);
		return stockCollection;
	}
	
	@HystrixCommand(fallbackMethod="fallBackFindById")
	@RequestMapping("/stock/find/{id}")
	public Stock findById(@PathVariable String id) {
		Stock responseObject = restTemplate.getForObject("http://stock-search/stock/find/" + id, Stock.class );
		return responseObject;
	}
	
	public Stock fallBackFindById(@PathVariable String id) {
		Stock responseObject = new Stock();
		responseObject.setScripCode("DFLT");
		responseObject.setCompanyName("Default Tech Company");
		return responseObject;
	}	
}