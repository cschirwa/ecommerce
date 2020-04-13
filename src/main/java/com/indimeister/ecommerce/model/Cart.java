package com.indimeister.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="cart")
public class Cart {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameProduct;
	
	private Long idProduct;
	
	public Cart(){
		
	}	

	public Cart(String nameProduct, Long idProduct) {
		super();
		this.nameProduct = nameProduct;
		this.idProduct = idProduct;		
	}


}
