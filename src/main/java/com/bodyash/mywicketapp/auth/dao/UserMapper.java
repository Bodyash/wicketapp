package com.bodyash.mywicketapp.auth.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bodyash.mywicketapp.auth.dao.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet arg0, int arg1) throws SQLException {
		UserModel u = new UserModel();
		u.setId(arg0.getLong("id"));
		u.setEmail(arg0.getString("email"));
		u.setPassword(arg0.getString("password"));
		return u;
	}

}
