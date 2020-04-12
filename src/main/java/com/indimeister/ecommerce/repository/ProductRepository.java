package com.indimeister.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.indimeister.ecommerce.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	
	Iterable<Product> findByName(String product);
}
