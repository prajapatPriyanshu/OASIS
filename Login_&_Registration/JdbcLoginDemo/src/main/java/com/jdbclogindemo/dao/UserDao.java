package com.jdbclogindemo.dao;

import com.jdbclogindemo.pojo.User;

public interface UserDao {

	boolean checkUserCredentials(User user);
	boolean addNewUser(User user);
}
