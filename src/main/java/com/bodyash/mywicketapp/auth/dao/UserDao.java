package com.bodyash.mywicketapp.auth.dao;

import java.util.List;
import javax.sql.DataSource;
import com.bodyash.mywicketapp.auth.dao.UserModel;

public interface UserDao {
	
	public void setDataSource(DataSource ds);
	public void addUser(UserModel u);
	public void updateUser(UserModel u);
	public UserModel getUser(Long id);
	public void deleteUser(Long id);
	public List<UserModel> findByUsername(String searchName);
	public List<UserModel> listUsers();
	

}
