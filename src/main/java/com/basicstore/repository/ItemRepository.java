package com.basicstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basicstore.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
	List<Item> findByNameIgnoreCase(String name);

}
