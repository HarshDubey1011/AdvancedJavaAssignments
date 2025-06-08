package com.cdac.acts.DAO;

public class Student {
	Integer id;
	String Name;
	String email;
	Integer age;
	String city;
	
	
	public Student() {
		super();
	}


	public Student(Integer id, String name, String email, Integer age, String city) {
		super();
		this.id = id;
		Name = name;
		this.email = email;
		this.age = age;
		this.city = city;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", email=" + email + ", age=" + age + ", city=" + city + "]";
	}
	
	
	
}
