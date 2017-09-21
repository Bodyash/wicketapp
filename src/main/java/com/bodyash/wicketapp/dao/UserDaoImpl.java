package com.bodyash.wicketapp.dao;

import java.util.List;

import javax.sql.DataSource;

import com.bodyash.wicketapp.bean.User;

public class UserDaoImpl implements UserDao {

	private DataSource dataSource;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;

	}

	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findByUsername(String searchName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
