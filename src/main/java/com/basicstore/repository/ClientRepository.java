package com.basicstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basicstore.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
	public List<Client> findByNameIgnoreCase(String name);

}
