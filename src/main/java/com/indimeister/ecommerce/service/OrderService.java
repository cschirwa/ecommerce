package com.indimeister.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indimeister.ecommerce.model.Orders;
import com.indimeister.ecommerce.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository ordertRepository;
	
	public Iterable<Orders> findAll(){		
		Iterable<Orders> order = ordertRepository.findAll();		
		return order;		
	}
	
	
	public void save(Orders order){
		ordertRepository.save(order);
	}
	
	


}
