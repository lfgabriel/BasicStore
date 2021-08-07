package com.basicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basicstore.model.Item;
import com.basicstore.model.Request;
import com.basicstore.model.Stock;
import com.basicstore.repository.RequestRepository;
import com.basicstore.repository.StockRepository;

@Service
public class RequestService implements IRequestService {

	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	
	@Override
	public Iterable<Request> findAll() {
		return requestRepository.findAll();
	}
	
	@Override
	public Request findById(Long id) {
		Optional<Request> requestOpt = requestRepository.findById(id);
		Request request = requestOpt.get();
		if (request != null)
			return request;
		else
			return null;
	}
	

	@Override
	public List<Request> findByClientId(Long clientId) {
		return requestRepository.findByClientId(clientId);
	}

	
	@Override
	public Request save(Request request) {
		try {
			List<Item> items = request.getItems();
			
			for (int i = 0; i < items.size(); i++) {

				Stock stock = stockRepository.findByItem(items.get(i));
				if (stock.getQuantity() <= 0) {
					System.err.println("Error while saving request. Item : " + items.get(i).getName() + " is out of stock!");
					return new Request();
				}
				else {
					stock.setQuantity(stock.getQuantity() - 1);
					stockRepository.save(stock);
				}
			}
		}
		catch(Exception e) {
			System.err.println("Error while saving request: " + e.getMessage());
			return new Request();
		}
		
		return requestRepository.save(request);
	}

	@Override
	public int remove(Long id) {
		
		requestRepository.deleteById(id);
		return 1;
	}


}
