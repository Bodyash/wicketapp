package com.bodyash.mywicketapp.auth.dao;

import java.io.Serializable;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

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
		// TODO Make this method work
	}

	@Override
	public UserModel getUser(Long id) {
		String SQL = "select * from Users where id = ?";
		UserModel u = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
		return u;
	}

	@Override
	public void deleteUser(Long id) {
		String SQL = "delete from Users where id = ?";
		jdbcTemplateObject.update(SQL, id);
		return;
	}

	@Override
	public List<UserModel> findByUsername(String searchName) {
		// TODO And make this Method working too
		return null;
	}

	@Override
	public List<UserModel> listUsers() {
		String SQL = "select * from Users";
		List<UserModel> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

}
