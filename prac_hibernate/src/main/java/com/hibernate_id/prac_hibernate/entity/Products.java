package com.hibernate_id.prac_hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Products {
	@EmbeddedId
	ProductID productId;
	
	@Column(name="productName")
	String productName;
	@Column(name="productDescription")
	String productDescription;
	@Column(name="productPrice")
	double price;
	@Column(name="productImageUrl")
	String productImageUrl;
	
	@ManyToOne
	@JoinColumn(name="categoryId",insertable=false,updatable=false)
	Category cat;
		
	public Products() {
		super();
	}

	public Products(ProductID productId, String productName, String productDescription, double price,
			String productImageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.productImageUrl = productImageUrl;
	}

	public ProductID getProductId() {
		return productId;
	}

	public void setProductId(ProductID prodctId) {
		this.productId = prodctId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductImageUrl() {
		return productImageUrl;
	}

	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}
	
	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", price=" + price + ", productImageUrl=" + productImageUrl + "]";
	}
	
	

	
}
