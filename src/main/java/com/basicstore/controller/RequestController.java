package com.basicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basicstore.model.Request;
import com.basicstore.service.IRequestService;

@RestController
public class RequestController {
	
	@Autowired
	private IRequestService requestService;
	
	@RequestMapping("/requests")
    public Iterable<Request> cities() {
		return requestService.findAll();
    }
	
	@RequestMapping("/request/add")
	public Request addRequest(@RequestBody Request request) {
		System.err.println("request: " + request);
		return requestService.save(request);
	}
	
	
	@RequestMapping("/request/update")
	public Request updateRequest(Request request) {
		return request;
	}
	
	@RequestMapping("/request/delete/{requestId}")
	public int deleteRequest(@PathVariable String requestId) {
		return requestService.remove(Long.valueOf(requestId));
	}
	

}
