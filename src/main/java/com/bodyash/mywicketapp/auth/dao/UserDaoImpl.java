package com.bodyash.mywicketapp.auth.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;

public class UserDaoImpl implements UserDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient DataSource dataSource;
	private transient JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void addUser(UserModel u) {
		String SQL = "insert into Users (email, firstname, secondname, middlename, password) values (?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, u.getEmail(), u.getFirstName(), u.getSecondName(), u.getMiddleName(),
				u.getPassword());
	}

	@Override
	public void updateUser(UserModel u) {
		String SQL = "Update Users SET email = ?, firstname = ?, secondname = ?, middlename= ? Where id=" + u.getId();
		jdbcTemplateObject.update(SQL, u.getEmail(), u.getFirstName(), u.getSecondName(), u.getMiddleName());
	}

	@Override
	public UserModel getUser(String email) {
		String SQL = "select * from Users where email = ?";
		UserModel u = null;
		try{
			u = jdbcTemplateObject.queryForObject(SQL, new Object[] { email }, new UserMapper());
			return u;
		}catch(EmptyResultDataAccessException e){
			System.out.println("Size : " + e.getActualSize());
			return u;
		}
	}

	@Override
	public void deleteUser(Long id) {
		String SQL = "delete from Users where id = ?";
		System.out.println("deleting user with id " + id);
		jdbcTemplateObject.update(SQL, id);
		return;
	}

	@Override
	public List<UserModel> findByUsername(String searchName) {
		String SQL = "select * from Users";
		List<UserModel> users = jdbcTemplateObject.query(SQL, new UserMapper());
		Set<UserModel> userSet = new HashSet<UserModel>();
		for (UserModel userModel : users) {
			if (userModel.getFirstName().toLowerCase().contains(searchName.toLowerCase()) || userModel.getSecondName().toLowerCase().contains(searchName.toLowerCase())
					|| userModel.getMiddleName().toLowerCase().contains(searchName.toLowerCase())) {
				userSet.add(userModel);
			}
		}

		return new ArrayList<UserModel>(userSet);
	}

	@Override
	public List<UserModel> listUsers() {
		String SQL = "select * from Users";
		List<UserModel> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

	@Override
	public UserModel getUserById(long id) {
		String SQL = "select * from Users where id = ?";
		UserModel u = null;
		try{
			u = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
			return u;
		}catch(EmptyResultDataAccessException e){
			System.out.println("Size : " + e.getActualSize());
			return u;
		}
	}

}
