package com.basicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basicstore.model.Client;
import com.basicstore.repository.ClientRepository;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private ClientRepository consumerRepository;
	

	@Override
	public Iterable<Client> findAll() {
		return consumerRepository.findAll();
	}

	@Override
	public Client findById(Long id) {
		Optional<Client> optConsumer = consumerRepository.findById(id);
		
		if (optConsumer.get() != null) {
		    return optConsumer.get();
		}
		else 
			return null;
	}

	@Override
	public List<Client> findByName(String name) {
		return null;
	}

	@Override
	public Client save(Client consumer) {
		return consumerRepository.save(consumer);
	}

	@Override
	public int remove(Long id) {
		Optional<Client> optConsumer = consumerRepository.findById(id);
		if (optConsumer.get() != null ) {
			consumerRepository.delete(optConsumer.get());
			return 1;
		}
		
		return 0;
	}
	

}
