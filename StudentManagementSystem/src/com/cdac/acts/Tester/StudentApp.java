package com.cdac.acts.Tester;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import com.cdac.acts.DAO.Student;
import com.cdac.acts.DAO.StudentDAOImpl;

public class StudentApp {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		try(Scanner sc = new Scanner(System.in);) {
			StudentDAOImpl sdi = new StudentDAOImpl();
			
		    char ch;
		    
		    do {
		    	System.out.println("a. Add Student\r\n"
			    		+ "b. Update Student\r\n"
			    		+ "c. Delete Student\r\n"
			    		+ "d. View Student By ID\r\n"
			    		+ "e. View All Students \r\n"
			    		+ "f. Exit");
		    	
		    	System.out.println("Enter your choice");
		    	ch = sc.next().charAt(0);
		    	switch(ch) {
		    	case 'a': {
		    		Student stud = Student.addStudent(sc);
		    		sdi.addStudent(stud);
		    	}break;
		    	case 'b': {
		    		// Update student;
		    		Integer id = Student.updateStudent(sc);
		    		Student stud = sdi.getStudentById(id);
		    		System.out.println("Enter the New Name: ");
		    		String name = sc.next();
		    		stud.setName(name);
		    		sdi.updateStudent(stud);
		    	}break;
		    	case 'c': {
		    		//delete student
		    		Integer id = Student.deleteByID(sc);
		    		sdi.deleteStudent(id);
		    	}break;
		    	case 'd': {
		    		Integer id = Student.getSingleStudent(sc);
		    		Student stud = sdi.getStudentById(id);
		    		System.out.println(stud);
		    	}break;
		    	case 'e': {
		    		Iterator<Student> itr = sdi.getAllStudents();
		    		while(itr.hasNext()) {
		    			Student data = itr.next();
		    			System.out.println(data);
		    		}
		    	}break;
		    	case 'f': {
		    		System.exit(1);
		    	}
		    	default : {
		    		System.out.println("Enter correct choice");
		    	}
		    	}
		    }while(ch!='f');
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
