package com.cdac.acts.DAO;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public interface StudentDAO {
	boolean addStudent(Student student) throws SQLException;
	boolean updateStudent(Student student) throws SQLException;
	boolean deleteStudent(int id);
	Student getStudentById(int id);
	Iterator<Student> getAllStudents() throws SQLException;
}
