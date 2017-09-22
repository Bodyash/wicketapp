package com.bodyash.wicketapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bodyash.wicketapp.dao.UserDao;
import com.bodyash.wicketapp.dao.UserDaoImpl;

@Configuration()
@ComponentScan("com.bodyash.wicketapp")
public class AppConfig {
	
	
	
	@Bean(name = "userDao")
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
}