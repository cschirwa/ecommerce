package com.indimeister.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indimeister.ecommerce.model.Product;
import com.indimeister.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> findAll(){		
		Iterable<Product> products = productRepository.findAll();		
		return products;		
	}
	
	public Optional<Product> findById(Long id){		
		return productRepository.findById(id);	
	}
	
	public Iterable<Product> findByName(String name){		
		return productRepository.findByName(name);	
	}
	
	
	public void save(Product product){
		productRepository.save(product);
	}
	
	


}
