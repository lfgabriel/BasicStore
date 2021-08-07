package com.basicstore.service;

import java.util.List;

import com.basicstore.model.Consumer;

public interface IConsumerService {
	
	Iterable<Consumer> findAll();
	
	Consumer findById(Long id);
	
	List<Consumer> findByName(String name);

	Consumer save(Consumer person);
	
	int remove(Long id);

}
