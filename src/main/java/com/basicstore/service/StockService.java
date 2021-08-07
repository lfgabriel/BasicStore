package com.basicstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basicstore.model.Stock;
import com.basicstore.repository.StockRepository;

@Service
public class StockService implements IStockService {

	@Autowired
	private StockRepository stockRepository;
	
	
	@Override
	public Iterable<Stock> findAll() {
		return stockRepository.findAll();
	}
	
	@Override
	public Stock findById(Long id) {
		Optional<Stock> stockOpt = stockRepository.findById(id);
		Stock stock = stockOpt.get();
		if (stock != null)
			return stock;
		else
			return null;
	}

	@Override
	public Stock save(Stock stock) {
		return stockRepository.save(stock);
	}

	@Override
	public int remove(Long id) {
		
		stockRepository.deleteById(id);
		return 1;
	}
}
