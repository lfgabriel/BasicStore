package com.basicstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basicstore.model.Consumer;
import com.basicstore.service.IConsumerService;

@RestController
public class ConsumerController {
	
	@Autowired
	private IConsumerService consumerService;
	
	
	@RequestMapping("/consumers")
	public Iterable<Consumer> people() {
		return consumerService.findAll();
	}
	
	@RequestMapping("/consumer/add")
	public Consumer addConsumer(@RequestBody Consumer consumer) {
		return consumerService.save(consumer);
	}
	
	@RequestMapping("/consumer/delete/{consumerId}")
	public int deleteConsumer(@PathVariable String consumerId) {
		return consumerService.remove(Long.valueOf(consumerId));
	}

}
