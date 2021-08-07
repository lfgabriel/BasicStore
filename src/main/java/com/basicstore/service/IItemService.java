package com.basicstore.service;

import java.util.HashMap;
import java.util.List;

import com.basicstore.model.Item;

public interface IItemService {

	Iterable<Item> findAll();
	
	Item findById(Long id);
	
	List<Item> findByName(String name);

	Item save(Item city);
	
	int remove(Long id);

}
