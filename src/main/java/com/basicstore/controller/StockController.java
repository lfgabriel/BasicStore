package com.basicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basicstore.model.Stock;
import com.basicstore.service.IStockService;

@RestController
public class StockController {
	
	@Autowired
	private IStockService stockService;
	
	@RequestMapping("/stocks")
    public Iterable<Stock> cities() {
		return stockService.findAll();
    }
	
	@RequestMapping("/stock/add")
	public Stock addStock(@RequestBody Stock stock) {
		return stockService.save(stock);
	}
	
	@RequestMapping("/stock/update")
	public Stock updateStock(Stock stock) {
		return stock;
	}
	
	@RequestMapping("/stock/delete/{stockId}")
	public int deleteStock(@PathVariable String stockId) {
		return stockService.remove(Long.valueOf(stockId));
	}
	

}
