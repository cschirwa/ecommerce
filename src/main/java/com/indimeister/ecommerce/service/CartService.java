package com.indimeister.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indimeister.ecommerce.model.Cart;
import com.indimeister.ecommerce.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	public Iterable<Cart> findAll(){		
		Iterable<Cart> carts = cartRepository.findAll();		
		return carts;		
	}
	
	
	public void save(Cart cart){
		cartRepository.save(cart);
	}
	
	public void delete(Long id){
		cartRepository.deleteById(id);
	}


}
