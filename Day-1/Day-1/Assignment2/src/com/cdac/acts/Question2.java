package com.cdac.acts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in);) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/school";
            String user = "root";
            String pass = "harsh";
            Connection con = DriverManager.getConnection(url,user,pass);
            System.out.println("Connection established successfully!");
		}catch(ClassNotFoundException e) {
			System.out.println("Jar file not loaded correctly");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("Sql Exception");
			e.printStackTrace();
		}
	}

}
