package com.basicstore.service;

import com.basicstore.model.Stock;

public interface IStockService {

	Iterable<Stock> findAll();
	
	Stock findById(Long id);
	
	Stock save(Stock stock);
	
	int remove(Long id);
}
