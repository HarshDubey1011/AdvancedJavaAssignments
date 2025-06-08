package com.cdac.acts.dao;

import java.sql.SQLException;
import java.util.Iterator;

public interface UsersDao {
	public boolean createUser(Users objUser);
	public Iterator<Users> listAllUsers() throws SQLException;
}
