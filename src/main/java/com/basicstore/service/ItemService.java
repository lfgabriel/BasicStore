package com.basicstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basicstore.model.Item;
import com.basicstore.repository.ItemRepository;

@Service
public class ItemService implements IItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	
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
		return itemRepository.save(item);
	}

	@Override
	public int remove(Long id) {
		
		itemRepository.deleteById(id);
		return 1;
	}

}
