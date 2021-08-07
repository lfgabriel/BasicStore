package com.basicstore.service;

import java.util.List;

import com.basicstore.model.Client;

public interface IClientService {
	
	Iterable<Client> findAll();
	
	Client findById(Long id);
	
	List<Client> findByName(String name);

	Client save(Client client);
	
	int remove(Long id);

}
