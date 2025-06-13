package com.hibernate_id.prac_hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "increment")
	int id;
	@Column(name="name")
	String name;
	@Column(name="userName")
	String userName;
	@Column(name="email")
	String email;
	@Column(name="age")
	int age;
	
	public Users() {
		super();
	}

	public Users(String name, String userName, String email, int age) {
		super();
	
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.age = age;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", userName=" + userName + ", email=" + email + ", age=" + age + "]";
	}
	
	
}


