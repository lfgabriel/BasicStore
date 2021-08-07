package com.basicstore.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basicstore.model.Item;
import com.basicstore.service.IItemService;

@RestController
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@RequestMapping("/items")
    public Iterable<Item> cities() {
		return itemService.findAll();
    }
	
	@RequestMapping("/item/add")
	public Item addItem(@RequestBody Item item) {
		return itemService.save(item);
	}
	
	@RequestMapping("/item/{itemName}")
	public List<Item> findbyName(@PathVariable String itemName) {
		return itemService.findByName(itemName);
	}
	
	@RequestMapping("/item/update")
	public Item updateItem(Item item) {
		return item;
	}
	
	@RequestMapping("item/delete/{itemId}")
	public int deleteItem(@PathVariable String itemId) {
		return itemService.remove(Long.valueOf(itemId));
	}
	

}
