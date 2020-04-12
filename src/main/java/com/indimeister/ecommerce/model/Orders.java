package com.indimeister.ecommerce.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNameProduct() {
		return nameProduct;
	}


	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}


	public LocalDate getBuyDate() {
		return buyDate;
	}


	public void setBuyDate(LocalDate buyDate) {
		this.buyDate = buyDate;
	}

	
	
}
