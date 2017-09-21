package com.bodyash.wicketapp.bean;

public class User {
	private int id;
	private String username;
	private String firstName;
	private String secondName;
	private String middleName;
	private String password;
	
	public User(int id, String username, String firstName, String secondName, String middleName, String password) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.secondName = secondName;
		this.middleName = middleName;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		this.password = password;
	}

}
