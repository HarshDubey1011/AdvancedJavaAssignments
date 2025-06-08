package com.cdac.acts.DAO;

import java.util.Scanner;

public class Student {
	String Name;
	String email;
	Integer age;
	String city;
	
	
	public Student() {
		super();
	}


	public Student(String name, String email, Integer age, String city) {
		super();
		this.Name = name;
		this.email = email;
		this.age = age;
		this.city = city;
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
	
	public static Student addStudent(Scanner sc) {
		System.out.println("Enter the Name: ");
		String name = sc.next();
		System.out.println("Enter the Email: ");
		String email = sc.next();
		System.out.println("Enter the Age: ");
		Integer age = sc.nextInt();
		System.out.println("Enter the City: ");
		String city = sc.next();
		
		Student stude = new Student(name,email,age,city);
		return stude;
	}

	public static Integer updateStudent(Scanner sc) {
		System.out.println("Enter the ID of the student you want to update: ");
		Integer id = sc.nextInt();
		return id;
	}
	public static Integer deleteByID(Scanner sc) {
		System.out.println("Enter the ID you wanna delete: ");
		Integer id = sc.nextInt();
		
		return  id;
	}
	
	public static Integer getSingleStudent(Scanner sc) {
		System.out.println("Enter the ID to get a record of the Student");
		Integer id = sc.nextInt();
		
		return id;
	}

	@Override
	public String toString() {
		return "Student [Names=" + Name + ", email=" + email + ", age=" + age + ", city=" + city + "]";
	}
	
}
