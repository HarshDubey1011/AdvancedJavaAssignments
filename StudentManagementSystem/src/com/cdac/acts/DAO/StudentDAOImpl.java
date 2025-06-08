package com.cdac.acts.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentDAOImpl implements StudentDAO {
	Connection con;
	PreparedStatement pCreateStudent;
	PreparedStatement pGetStudent;
	PreparedStatement pUpdateStudent;
	PreparedStatement pDeleteStudent;
	PreparedStatement pGetSingleStudent;
	
	public StudentDAOImpl() throws FileNotFoundException, IOException, SQLException {
		Properties dbProperties = new Properties();
		dbProperties.load(new FileInputStream("application.properties"));
		String url = dbProperties.getProperty("connection.url");
		String user = dbProperties.getProperty("connection.username");
		String pass = dbProperties.getProperty("connection.password");
		String createStudent = dbProperties.getProperty("sql.insertStudent");
		String getStudent = dbProperties.getProperty("sql.getStudent");
		String updateStudent = dbProperties.getProperty("sql.updateStudent");
		String deleteStudent = dbProperties.getProperty("sql.deleteStudent");
		String getStudentById = dbProperties.getProperty("sql.getStudentByID");
		
		
		con = DriverManager.getConnection(url,user,pass);
		pCreateStudent = con.prepareStatement(createStudent);
		pGetStudent = con.prepareStatement(getStudent);
		pUpdateStudent = con.prepareStatement(updateStudent);
		pDeleteStudent = con.prepareStatement(deleteStudent);
		pGetSingleStudent = con.prepareStatement(getStudentById);
	}
	@Override
	public boolean addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		try {
			pCreateStudent.setString(1, student.getName());
			pCreateStudent.setString(2, student.getEmail());
			pCreateStudent.setInt(3, student.getAge());
			pCreateStudent.setString(4, student.getCity());
			
			pCreateStudent.executeUpdate();
			System.out.println("Student added to database successfully!");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		try {
			pUpdateStudent.setString(1, student.getName());
			pUpdateStudent.setInt(2, student.getAge());
			pUpdateStudent.executeUpdate();
			System.out.println("Student Updated Successfully!");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		try {
			pDeleteStudent.setInt(1, id);
			pDeleteStudent.executeUpdate();
			System.out.println("Deleted Successfully!");
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Student stud = null;
		try {
			pGetSingleStudent.setInt(1, id);
			ResultSet rs = pGetSingleStudent.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString(2);
				String email = rs.getString(3);
				Integer age = rs.getInt(4);
				String city = rs.getString(5);
				
				stud = new Student(name,email,age,city);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return stud;
	}

	@Override
	public Iterator<Student> getAllStudents() throws SQLException {
		// TODO Auto-generated method stub
		List<Student> studentStud = new ArrayList<>();
		try(ResultSet rs = pGetStudent.executeQuery();) {
			
			while(rs.next()) {
				
				String name = rs.getString(2);
				String email = rs.getString(3);
				Integer age = rs.getInt(4);
				String city = rs.getString(5);
				Student s = new Student(name,email,age,city);
				studentStud.add(s);
			}
			
		}catch(SQLException e) {
				System.out.println(e.getMessage());
		}
		return studentStud.iterator();
	}

}
