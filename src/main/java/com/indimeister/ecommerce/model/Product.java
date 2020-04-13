package com.indimeister.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="product")
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Double price;
	
	private Long available;
	
	public Product(){
		
	}

	public Product(String name, Double price, Long available) {
		super();
		this.name = name;
		this.price = price;
		this.available = available;
	}

}
