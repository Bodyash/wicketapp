package com.bodyash.mywicketapp.auth.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.util.io.IClusterable;
import org.apache.wicket.util.string.Strings;

import com.bodyash.mywicketapp.wicket.security.IAuthModel;


@Entity
@Table(name = "user")
public class UserModel implements IClusterable, IAuthModel {

	private static final long serialVersionUID = 1L;

	// For criteria API and search
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String FIRSTNAME = "firstname";
	public static final String SECONDNAME = "secondname";
	public static final String MIDDLENAME = "middlename";

	@Id @GeneratedValue private Long id;
	@Column(nullable=false, unique=true) private String email;
	@Column(nullable=false) private String password;
	private String firstName;
	private String secondName;
	private String middleName;

	@Override
	public boolean equals(Object user) {
		if(getId() != null && user instanceof UserModel) {
			return getId().equals(((UserModel)user).getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		if(getId() == null) {
			return 0;
		}
		return getId().intValue();
	}

	/* /utils */

	@Override
	public Roles getRoles() {
		// in real world get roles from DB or AS
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

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
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

	public boolean isPassword(String plainText) {
		if (Strings.isEmpty(plainText)) {
			return false;
		}
		return password.equals(plainText);
	}
}
