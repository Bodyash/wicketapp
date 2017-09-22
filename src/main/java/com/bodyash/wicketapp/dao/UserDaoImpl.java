package com.bodyash.wicketapp.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.bodyash.wicketapp.bean.User;

public class UserDaoImpl implements UserDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public void addUser(User u) {
		String SQL = "insert into Users (username, firstname, secondname, middlename, password) values (?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(SQL, u.getUsername(), u.getFirstName(), u.getSecondName(), u.getMiddleName(),
				u.getPassword());
	}

	@Override
	public void updateUser(User u) {
		// TODO Make this method work
	}

	@Override
	public User getUser(int id) {
		String SQL = "select * from Users where id = ?";
		User u = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
		return u;
	}

	@Override
	public void deleteUser(int id) {
		String SQL = "delete from Users where id = ?";
		jdbcTemplateObject.update(SQL, id);
		return;
	}

	@Override
	public List<User> findByUsername(String searchName) {
		// TODO And make this Method working too
		return null;
	}

	@Override
	public List<User> listUsers() {
		String SQL = "select * from Users";
		List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

}
