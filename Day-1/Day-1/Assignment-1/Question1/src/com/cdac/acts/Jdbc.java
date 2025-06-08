package com.cdac.acts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
     public static void main(String[] args) {
         try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/demodb";
                String user = "root";
                String pass = "harsh";
                Connection con = DriverManager.getConnection(url,user,pass);
                System.out.println("Connection established successfully!");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from UserTable");
                
//                // To Insert the data into the table
//                String query = "Insert into usertable(user_name,password,email,city,name) values(?,?,?,?,?)";
//                PreparedStatement pstmt = con.prepareStatement(query);
//                pstmt.setString(1, "rahul");
//                pstmt.setString(2, "rahul@123");
//                pstmt.setString(3, "rahul@123");
//                pstmt.setString(4, "mumbai");
//                pstmt.setString(5, "rahul");
//                pstmt.executeUpdate();
//                System.out.println("Data inserted successfully!");
                
                // To query the data from the table
                
                String query2 = "SELECT * FROM UserTable WHERE city = ?";
                PreparedStatement pstmtCity = con.prepareStatement(query2);
                pstmtCity.setString(1,"anuppur");
                ResultSet rsCity = pstmtCity.executeQuery();
                
                System.out.println("-------Fetching Data Using The City---------");
                while(rsCity.next()) {
                    String userName = rsCity.getString("user_name");
                    String password = rsCity.getString("password");
                    String email = rsCity.getString("email");
                    String city = rsCity.getString("city");
                    String name = rsCity.getString("name");
                    
                    System.out.println("UserName: "+userName+",Password: "+password+",Email: "+email+",City: "+city+",Name: "+name);
                }
                
                System.out.println("-------Fetching Data Using The City---------");
                System.out.println("-------Updating City Based on UserName---------");
                // Updating the city based on user_name
                String queryUpdate = "Update UserTable set city = ? where user_name = ?";
                PreparedStatement pstmtUpdate = con.prepareStatement(queryUpdate);
                pstmtUpdate.setString(1, "bangalore");
                pstmtUpdate.setString(2,"rahul");
                int updatedRows = pstmtUpdate.executeUpdate();
                System.out.println("Number of rows effected "+updatedRows);
                
                
                String query3 = "SELECT * FROM UserTable WHERE user_name = ?";
                PreparedStatement pstmtUser = con.prepareStatement(query3);
                pstmtUser.setString(1,"rahul");
                ResultSet rsUser = pstmtUser.executeQuery();
                
                System.out.println("-------Fetching Data Using The UserName---------");
                while(rsUser.next()) {
                    String userName = rsUser.getString("user_name");
                    String password = rsUser.getString("password");
                    String email = rsUser.getString("email");
                    String city = rsUser.getString("city");
                    String name = rsUser.getString("name");
                    
                    System.out.println("UserName: "+userName+",Password: "+password+",Email: "+email+",City: "+city+",Name: "+name);
                }
                // To get all the data
                System.out.println("-------Get All The Data---------");
                while(rs.next()) {
                    int id = rs.getInt("id");
                    String userName = rs.getString("user_name");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String city = rs.getString("city");
                    String name = rs.getString("name");
                    
                    System.out.println("ID: "+id+",UserName: "+userName+",Password: "+password+",Email: "+email+",City: "+city+",Name: "+name);
                }
                System.out.println("-------Get All The Data---------");
                st.close();
                rs.close();
                con.close();
        } catch (ClassNotFoundException e) {
        		System.out.println("Jar file not properly installed");
                e.printStackTrace();
        } catch(SQLException e) {
        	System.out.println(e.getMessage() + "Sql Exception");
        	e.printStackTrace();
        }
    }
}