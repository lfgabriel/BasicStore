package com.basicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basicstore.model.Client;
import com.basicstore.service.IClientService;

@RestController
public class ClientController {
	
	@Autowired
	private IClientService clientService;
	
	
	@RequestMapping("/clients")
	public Iterable<Client> people() {
		return clientService.findAll();
	}
	
	@RequestMapping("/client/add")
	public Client addConsumer(@RequestBody Client client) {
		try {
			return clientService.save(client);
		}
		catch(Exception e) {
			System.err.println("Error while saving client: " + e.getMessage());
			return new Client();
		}
	}
	
	@RequestMapping("/client/delete/{clientId}")
	public int deleteConsumer(@PathVariable String clientId) {
		return clientService.remove(Long.valueOf(clientId));
	}

}
