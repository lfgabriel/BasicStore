package com.basicstore.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basicstore.dto.ItemDto;
import com.basicstore.model.Item;
import com.basicstore.service.IItemService;

@RestController
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@RequestMapping("/items")
    public List<ItemDto> items() {
		Iterable<Item> items = itemService.findAll();
		List<ItemDto> result = StreamSupport.stream(items.spliterator(), false).map(this::convertToDto).collect(Collectors.toList());
		
		return result;
    }
	
	@RequestMapping("/item/add")
	public ItemDto addItem(@RequestBody ItemDto itemDto) {
		Item item = convertToEntity(itemDto);
		Item createdItem = itemService.save(item); 
		return convertToDto(createdItem);
	}
	
	@RequestMapping("/item/{itemName}")
	public List<ItemDto> findbyName(@PathVariable String itemName) {
		List<Item> items = itemService.findByName(itemName);
		List<ItemDto> itemsDto = items.stream().map(this::convertToDto).collect(Collectors.toList());
		return itemsDto;
	}
	
	@RequestMapping("/item/update")
	public ItemDto updateItem(@RequestBody ItemDto itemDto) {
		Item item = convertToEntity(itemDto);
		Item updatedItem = itemService.save(item);
		return convertToDto(updatedItem);
	}
	
	@RequestMapping("/item/delete/{itemId}")
	public int deleteItem(@PathVariable String itemId) {
		return itemService.remove(Long.valueOf(itemId));
	}
	
	
	private ItemDto convertToDto(Item item) {
		ItemDto itemDto = modelMapper.map(item, ItemDto.class);
		return itemDto;
	}
	
	private Item convertToEntity(ItemDto itemDto) {
		Item item = modelMapper.map(itemDto, Item.class);
		return item;
	}
	
}
