package com.indimeister.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="orders")
public class Orders {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameProduct;
	
	private LocalDate buyDate;
	
	public Orders(){
		
	}	

	public Orders(String nameProduct, LocalDate buyDate ) {
		super();
		this.nameProduct = nameProduct;
		this.buyDate = buyDate;
	}
	
}
