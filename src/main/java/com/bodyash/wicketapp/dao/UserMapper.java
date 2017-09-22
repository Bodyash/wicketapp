package com.bodyash.wicketapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bodyash.wicketapp.bean.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet arg0, int arg1) throws SQLException {
		User u = new User();
		u.setId(arg0.getInt("id"));
		u.setUsername(arg0.getString("username"));
		u.setFirstName(arg0.getString("firstname"));
		u.setSecondName(arg0.getString("secondname"));
		u.setMiddleName(arg0.getString("middlename"));
		u.setPassword(arg0.getString("password"));
		return u;
	}

}
