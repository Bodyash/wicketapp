package com.bodyash.wicketapp.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.util.io.IClusterable;

import com.bodyash.wicketapp.security.IAuthModel;

public class User implements IAuthModel, IClusterable {


	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String firstName;
	private String secondName;
	private String middleName;
	private String password;
	
	public User(){}
	
	public User(Long id, String username, String firstName, String secondName, String middleName, String password) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.secondName = secondName;
		this.middleName = middleName;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		// TODO Password Encrypt?
		this.password = password;
	}
	

	@Override
	public Roles getRoles() {
		// TODO maybe there must be real Roles?
		return new Roles("is_user");
	}

	@Override
	public boolean hasAnyRole(Roles roles) {
		return getRoles().hasAnyRole(roles);
	}

	@Override
	public boolean hasRole(String role) {
		return hasAnyRole(new Roles(role));
	}

}
