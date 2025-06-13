package com.hibernate_id.prac_hibernate.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
@NamedQueries({
	@NamedQuery(
			name="getAllCategories",
			query="Select OBJECT(c) from Category as c"),
	@NamedQuery(
			name="getSpecificColumns",
			query="Select c.id,c.categoryName from Category as c where c.id=:cid"
			)
})
@NamedNativeQueries({
	@NamedNativeQuery(
	name="sqlAllCategories",
	query="SELECT * FROM Category"
	)
})
public class Category {
	@Id
	@Column(name="categoryId")
	@GeneratedValue(generator="increment")
	int id;
	@Column(name="categoryDescription")
	String categoryDescription;
	@Column(name="categoryImageUrl")
	String ImageUrl;
	@Column(name="categoryName")
	String categoryName;
	
	@OneToMany(mappedBy="cat")
	Set<Products> prod;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Set<Products> getProd() {
		return prod;
	}


	public void setProd(Set<Products> prod) {
		this.prod = prod;
	}


	public Category() {
		super();
	}


	public Category(String categoryDescription, String imageUrl, String categoryName) {
		super();
		this.categoryDescription = categoryDescription;
		ImageUrl = imageUrl;
		this.categoryName = categoryName;
	}


	public String getCategoryDescription() {
		return categoryDescription;
	}


	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}


	public String getImageUrl() {
		return ImageUrl;
	}


	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryDescription=" + categoryDescription + ", ImageUrl=" + ImageUrl
				+ ", categoryName=" + categoryName + "]";
	}
	
	
}
