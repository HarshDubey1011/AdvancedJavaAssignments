package com.cdac.acts.dao;

import java.util.Scanner;

// Plane Old Java Class
public class Users {
	String userName;
	String password;
	String name;
	String email;
	
	public Users() {
		super();
	}

	public Users(String userName, String password, String name, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static Users addUser(Scanner sc) {
		System.out.println("Enter the UserName: ");
		String userName = sc.next();
		
		System.out.println("Enter the Password: ");
		String password = sc.next();
		
		System.out.println("Enter the Name: ");
		String name = sc.next();
		
		System.out.println("Enter the Email: ");
		String email = sc.next();
		
		Users user = new Users(userName,password,name,email);
		return user;
	}

	@Override
	public String toString() {
		return "Users [userName=" + userName + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	

}
