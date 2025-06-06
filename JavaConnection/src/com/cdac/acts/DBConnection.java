package com.cdac.acts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/demodb";
		String user = "root";
		String password = "harsh";
		
		try {
			// Here we do the define the mysql driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// asking the driver manager to get connection based on url
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("Connections is successfull");
			// using Statement Interface to fetch static queries
			String query = "Select * from UserTable";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// Using the sub interface of statement interface the Prepared Interface to fetch queries
	
// 1. Register the user
//			String insertQuery = "Insert into UserTable (user_name, password, name, email, city) VAlUES (?,?,?,?,?)";
//			PreparedStatement pstmt  = con.prepareStatement(insertQuery);
//			pstmt.setString(1, "Neha");
//			pstmt.setString(2, "neha65");
//			pstmt.setString(3, "Neha");
//			pstmt.setString(4, "Neha12324@gmail.com");
//			pstmt.setString(5, "Delhi");
//			pstmt.executeUpdate();
//			System.out.println("Data added successfully!");
			
	// 2. Display Information based on the city
			String lstUsersCity = "Select * from UserTable where city=?";
			PreparedStatement pstmtCity = con.prepareStatement(lstUsersCity);
			pstmtCity.setString(1, "Delhi");
			ResultSet rsCity = pstmtCity.executeQuery();
			
			while(rsCity.next()) {
				int id = rsCity.getInt("id");
				String user_name = rsCity.getString("user_name");
				String pass = rsCity.getString("password");
				String name = rsCity.getString("name");
				String email = rsCity.getString("email");
				String city = rsCity.getString("city");
				System.out.println("------Fetching Details Based on the City---------");
				System.out.println("ID: " + id + ", Username: " + user_name + ", Password: " + pass + ", Name: " + name + ", Email: " + email + ", City: " + city);
				System.out.println("----------Fetching Detials Based on the City---------");
			}
			
	// 3. Update the password of user
		String updateQuery = "Update UserTable set password = ? where user_name = ?";
		PreparedStatement pstmtUpdate = con.prepareStatement(updateQuery);
		pstmtUpdate.setString(1, "TrumpVsElon");
		pstmtUpdate.setString(2, "Neha");
		int updatedRows = pstmtUpdate.executeUpdate();
		System.out.println("Updated Rows: "+ updatedRows);
		System.out.println("Data updated successfully!");
		
		
	// 4. Display User Information Based on User Name
		String userQuery = "Select name,email,city from UserTable where user_name = ?";
		PreparedStatement pstmtUser = con.prepareStatement(userQuery);
		pstmtUser.setString(1, "harsh");
		ResultSet rsUser = pstmtUser.executeQuery();
		
		System.out.println("---------Display Information Based on UserName------------");
		while(rsUser.next()) {
			String name = rsUser.getString("name");
			String email = rsUser.getString("email");
			String city = rsUser.getString("city");
			System.out.println("------Fetching Details Based on the City---------");
			System.out.println("Name: "+name+" "+"Email: "+email+" "+" "+"City: "+city);
			System.out.println("----------Fetching Detials Based on the City---------");
		}
		
			System.out.println("-------Getting All the details---------");
			while(rs.next()) {
				int id = rs.getInt("id");
				String user_name = rs.getString("user_name");
				String pass = rs.getString("password");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String city = rs.getString("city");
				
				System.out.println("ID: " + id + ", Username: " + user_name + ", Password: " + pass + ", Name: " + name + ", Email: " + email + ", City: " + city);
				
			}
			System.out.println("---------Getting All the details----------");
			con.close();
		}catch(ClassNotFoundException e) {
			System.out.println("Jar file not found!");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("username or password not found!");
			e.printStackTrace();
		}
	}
}
