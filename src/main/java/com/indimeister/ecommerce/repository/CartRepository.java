package com.indimeister.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.indimeister.ecommerce.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {
	
	

}
