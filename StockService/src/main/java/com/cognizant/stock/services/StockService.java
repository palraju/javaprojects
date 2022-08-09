package com.cognizant.stock.services;

import java.util.*;
import java.util.stream.Collectors;

import org.bouncycastle.crypto.prng.RandomGenerator;
import org.springframework.stereotype.Service;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.model.StockServiceResponse;


@Service
public class StockService {

	public static Map<String, Stock> StockRepsitory = new HashMap();
	public static Random randomNumber = new Random();


	static {
		Stock stock1 = new Stock();
		stock1.setStockId(randomNumber.nextInt());
		stock1.setScripCode("COGN");
		stock1.setCompanyName("Cognizant Technology Solutions");
		StockRepsitory.put("COGN", stock1);

		Stock stock2 = new Stock();
		stock2.setStockId(randomNumber.nextInt());
		stock2.setScripCode("INFY");
		stock2.setCompanyName("Infosys Technologies");
		StockRepsitory.put("INFY", stock2);
	}

	public Stock findById(String scripCode) {
		return StockRepsitory.get(scripCode);
	}

	public Collection<Stock> findAll() {
		return StockRepsitory.values();
	}

	public Stock add (Stock stock) {
		if(stock == null) {
			new RuntimeException("Stock can not be empty");
		}

		if(StockRepsitory.containsKey(stock.getScripCode())) {
			new RuntimeException("Stock with scrip code : "+ stock.getScripCode() + " is already added");
		}

		stock.setStockId(randomNumber.nextInt());
		StockRepsitory.put(stock.getScripCode(), stock);
		return stock;
	}
}
