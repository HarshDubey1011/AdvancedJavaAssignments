package com.cdac.acts.Tester;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import com.cdac.acts.dao.Users;
import com.cdac.acts.dao.UsersDAOImpl;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		UsersDAOImpl udi = new UsersDAOImpl();
		Scanner sc = new Scanner(System.in);
		//Users userObj = Users.addUser(sc);
		//udi.createUser(userObj);
		Iterator<Users> itr =  udi.listAllUsers();
		while(itr.hasNext()) {
			Users data = itr.next();
			System.out.println(data);
		}
	}

}
