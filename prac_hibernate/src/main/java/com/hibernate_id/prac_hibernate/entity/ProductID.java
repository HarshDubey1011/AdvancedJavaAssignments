package com.hibernate_id.prac_hibernate.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9131104878635062634L;

	@Column(name="productId")
	@GeneratedValue(generator="increment")
	private int productId;

	@Column(name="categoryId")
	private int id;
	

	
	public ProductID() {
		super();
	}

	public ProductID(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
	
}
