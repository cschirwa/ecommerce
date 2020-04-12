package com.indimeister.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.indimeister.ecommerce.model.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long> {
	
	

}
