package com.basicstore.service;

import java.util.List;

import com.basicstore.model.Request;

public interface IRequestService {

	Iterable<Request> findAll();
	
	Request save(Request request);

	Request findById(Long id);

	List<Request> findByClientId(Long clientId);
	
	int remove(Long id);

}
