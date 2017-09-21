package com.bodyash.wicketapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bodyash.wicketapp.bean.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
