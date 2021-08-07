package com.basicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basicstore.model.Item;
import com.basicstore.model.Stock;
import com.basicstore.repository.ItemRepository;
import com.basicstore.repository.StockRepository;

@Service
public class ItemService implements IItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	@Override
	public Iterable<Item> findAll() {
		return itemRepository.findAll();
	}
	
	@Override
	public Item findById(Long id) {
		Optional<Item> itemOpt = itemRepository.findById(id);
		Item item = itemOpt.get();
		if (item != null)
			return item;
		else
			return null;
	}

	@Override
	public List<Item> findByName(String name) {
		return itemRepository.findByNameIgnoreCase(name);
	}
	
	
	@Override
	public Item save(Item item) {
		
		// create item stock with value 10
		try {
			itemRepository.save(item);
			
			Stock newStock = new Stock();
			newStock.setItem(item);
			newStock.setQuantity(Long.valueOf(10));
			stockRepository.save(newStock);
			
			return item;
		}
		catch(Exception e) {
			System.err.println("Error while saving item: " + e.getMessage());
			return new Item();
		}
		
		
	}

	@Override
	public int remove(Long id) {
		
		itemRepository.deleteById(id);
		return 1;
	}

}
