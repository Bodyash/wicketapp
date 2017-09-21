package com.bodyash.wicketapp.dao;

import java.util.List;

import javax.sql.DataSource;

import com.bodyash.wicketapp.bean.User;

public interface UserDao {
	
	public void setDataSource(DataSource ds);
	public void addUser(User u);
	public void updateUser(User u);
	public User getUser(int id);
	public void deleteUser(int id);
	public List<User> findByUsername(String searchName);
	public List<User> listUsers();
	

}
