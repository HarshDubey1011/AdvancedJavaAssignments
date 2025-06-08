package com.cdac.acts;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Entry {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Properties dbProperties = new Properties();
			dbProperties.load(new FileInputStream("application.properties"));
			String dbUrl = dbProperties.getProperty("connection.url");
			String dbUserName = dbProperties.getProperty("connection.username");
			String dbPassword = dbProperties.getProperty("connection.password");
			
			try (Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
				Scanner sc = new Scanner(System.in);) {
				DatabaseMetaData dmd = con.getMetaData();
				System.out.println("DataBaseMetaData"+dmd);
				ResultSet rs = dmd.getTables(null, null, "%", new String[] { "TABLE" });

				while (rs.next()) {
				    System.out.println("Table: " + rs.getString("TABLE_NAME"));
				}

				
				ResultSet rsColumns = dmd.getColumns(null, null, "userdetail",null);
				System.out.println("Get Columns"+rsColumns);
				while(rsColumns.next()) {
					for(int i = 1;i<6;i++) {
						System.out.println(rsColumns.getString(i));
					}
				}
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void createUser(Scanner scanner, PreparedStatement psInsert,Connection con) throws SQLException {
		System.out.println("Enter the UserName: ");
		String userName = scanner.next();
		
		System.out.println("Enter the Password: ");
		String password = scanner.next();
		
		System.out.println("Enter the Name: ");
		String name = scanner.next();
		
		System.out.println("Enter the Email: ");
		String email = scanner.next();
		
		String query = "Insert into userdetail(username,password,name,email) values(?,?,?,?)";
		psInsert = con.prepareStatement(query);
		psInsert.setString(1, userName);
		psInsert.setString(2, password);
		psInsert.setString(3, name);
		psInsert.setString(4, email);
		
		psInsert.executeUpdate();
		System.out.println("User Created");
	}

}
