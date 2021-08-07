package com.basicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basicstore.model.Consumer;
import com.basicstore.repository.ConsumerRepository;

@Service
public class ConsumerService implements IConsumerService {
	
	@Autowired
	private ConsumerRepository consumerRepository;
	

	@Override
	public Iterable<Consumer> findAll() {
		return consumerRepository.findAll();
	}

	@Override
	public Consumer findById(Long id) {
		Optional<Consumer> optConsumer = consumerRepository.findById(id);
		
		if (optConsumer.get() != null) {
		    return optConsumer.get();
		}
		else 
			return null;
	}

	@Override
	public List<Consumer> findByName(String name) {
		return null;
	}

	@Override
	public Consumer save(Consumer consumer) {
		return consumerRepository.save(consumer);
	}

	@Override
	public int remove(Long id) {
		Optional<Consumer> optConsumer = consumerRepository.findById(id);
		if (optConsumer.get() != null ) {
			consumerRepository.delete(optConsumer.get());
			return 1;
		}
		
		return 0;
	}
	

}
