package com.cognizant.stock.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.cognizant.stock.model.Stock;
import com.cognizant.stock.model.StockServiceResponse;
import com.cognizant.stock.services.StockService;

@RefreshScope
@RestController
public class StockResource {
	@Autowired
	StockService stockService;

	@RequestMapping("/api/stock/find/{id}")
	public Stock findById(@PathVariable String id) {
		return stockService.findById(id);
	}

	@RequestMapping("/api/stock/findAll")
	public StockServiceResponse<Stock> findAll() {
		StockServiceResponse<Stock> stockListResponseObj = new StockServiceResponse<Stock>();
		stockListResponseObj.setDataList(stockService.findAll());
		return stockListResponseObj;
	}

	@PostMapping("/api/stock/add")
	public Stock add (@RequestBody Stock stock) {
		return stockService.add(stock);
	}
}