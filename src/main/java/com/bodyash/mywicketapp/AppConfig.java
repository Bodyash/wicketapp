package com.bodyash.mywicketapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.auth.dao.UserDaoImpl;


@Configuration()
@ComponentScan("com.bodyash.mywicketapp")
public class AppConfig {
	
	@Bean(name = "userDao")
	public UserDao userDao() {
		UserDao dao = new UserDaoImpl();
		dao.setDataSource(this.dataSource());
		return dao;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mywicketapp?useUnicode=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("test1230");
		return dataSource;
	}
	
}