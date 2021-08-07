package com.basicstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basicstore.model.Consumer;

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Long> {
	public List<Consumer> findByNameIgnoreCase(String name);

}
