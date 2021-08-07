package com.basicstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basicstore.model.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
	List<Request> findByClientId(Long consumerId);
}
