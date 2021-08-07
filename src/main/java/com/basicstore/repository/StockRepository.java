package com.basicstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basicstore.model.Item;
import com.basicstore.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
	Stock findByItem(Item item);
}
