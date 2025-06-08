package com.cdac.acts.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;


public class UsersDAOImpl implements UsersDao {
	Connection con;
	PreparedStatement psCreateUser;
	PreparedStatement psAllUsers;
	
	public UsersDAOImpl() throws IOException, SQLException {
		try {
			Properties dbProperties = new Properties();
			dbProperties.load(new FileInputStream("application.properties"));
			String dbUrl = dbProperties.getProperty("connection.url");
			String dbUserName = dbProperties.getProperty("connection.username");
			String dbPassword = dbProperties.getProperty("connection.password");
			String sqlCreateUser = dbProperties.getProperty("sql.createUser");
			String allUsers = dbProperties.getProperty("sql.allUsers");
			
			con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			psCreateUser = con.prepareStatement(sqlCreateUser);
			psAllUsers = con.prepareStatement(allUsers);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean createUser(Users objUser) {
		// TODO Auto-generated method stub
		try {
			psCreateUser.setString(1, objUser.getUserName());
			psCreateUser.setString(2, objUser.getPassword());
			psCreateUser.setString(3, objUser.getName());
			psCreateUser.setString(4, objUser.getEmail());
			
			psCreateUser.executeUpdate();
			System.out.println("User Created Successfully!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public Iterator<Users> listAllUsers() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Users> listUsers = new ArrayList<>();
		try(ResultSet resultAllUsers = psAllUsers.executeQuery();) {
			
			while(resultAllUsers.next()) {
				String userName = resultAllUsers.getString(1);
				String password = resultAllUsers.getString(2);
				String name = resultAllUsers.getString(3);
				String email = resultAllUsers.getString(4);
				Users objUser = new Users(userName,password,name,email);
				listUsers.add(objUser);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listUsers.iterator();
	}

}
