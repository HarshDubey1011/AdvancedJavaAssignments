package com.cdac.acts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class JDBC {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in);) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/school";
            String user = "root";
            String pass = "harsh";
            Connection con = DriverManager.getConnection(url,user,pass);
            System.out.println("Connection established successfully!");
            
            // Create a table
            String columnName = "";
            String dataType = "";
            int primaryKeyNumber = 0;
            System.out.println("Create a table using the Java in mysql");
            System.out.println("Enter the Table Name: ");
            String tableName = sc.next();
            System.out.println("Enter the Number of Columns you wanna add: ");
            int colVal = sc.nextInt();
            Map<String,String> map = new LinkedHashMap<>();
            char ch;
            do {
            	System.out.println("a. Add Column\r\n"
            			+ "b. Set Primary Key\r\n"
            			+ "c. Save");
            	ch = sc.next().charAt(0);
            	
            	switch(ch) {
            	case 'a': {
            		if(colVal==0) {
            			System.out.println("Zero columns provided");
            			return;
            		}
            		
            		while(colVal!=0) {
            			System.out.println("Enter the Column Name");
                		columnName = sc.next();
                		System.out.println("1. Varchar\r\n"
                				+ "2. INT\r\n"
                				+ "3. Float");
                		int choice = sc.nextInt();
                		switch(choice) {
                		case 1 : {
                			dataType = "varchar";
                		}break;
                		case 2: {
                			dataType = "int";
                		}break;
                		case 3: {
                			dataType = "float";
                		}break;
                		default: System.out.println("Please provide the valid datatype");
                		}
                		map.put(columnName, dataType);
                		colVal--;
            		}
            	}break;
            	case 'b': {
            		int index = 1;
            		for(Map.Entry<String, String> e: map.entrySet()) {
            			System.out.println(index+" "+e.getKey());
            			index++;
            		}
            		System.out.println("Enter the column number in which you have to apply the primary key");
            		int colNum = sc.nextInt();
            		primaryKeyNumber = colNum;
             	}break;
            	case 'c': {
            	    System.out.println(map);
            	    System.out.println(map.size());
            	    StringBuilder sb = new StringBuilder();
            	    int primaryKeySetter = 1;
            	    for (Map.Entry<String, String> e : map.entrySet()) {
            	        sb.append(e.getKey()).append(" ").append(e.getValue());
            	        if (primaryKeySetter == primaryKeyNumber && e.getValue().equals("int")) {
            	            sb.append(" primary key");
            	        } else if (primaryKeySetter == primaryKeyNumber && e.getValue().equals("varchar")) {
            	            sb.append("(").append(255).append(") primary key");
            	        } else if(e.getValue().equals("varchar")) {
            	        	sb.append("(").append(255).append(")");
            	        }
            	        if (e != map.entrySet().toArray()[map.size() - 1]) {
            	            sb.append(", ");
            	        }
            	        primaryKeySetter++;
            	    }
            	    String query = "CREATE TABLE " + tableName + " (" + sb.toString() + ")";
            	    System.out.println(query);
            	    Statement stmt = con.createStatement();
            	    stmt.executeUpdate(query);
            	    System.out.println("Successfully Created Table");
            	} break;

            	default: {
            		System.out.println("Please choose the correct option");
            	}
            	}
            }while(ch!='d');
            
            con.close();
    } catch (ClassNotFoundException e) {
    		System.out.println("Jar file not properly installed");
            e.printStackTrace();
    } catch(SQLException e) {
    	System.out.println(e.getMessage() + " Sql Exception");
    	e.printStackTrace();
    }
	}

}
