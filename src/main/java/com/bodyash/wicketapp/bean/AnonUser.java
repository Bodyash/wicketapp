package com.bodyash.wicketapp.bean;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;

public class AnonUser extends User {
	private static final long serialVersionUID = 1L;

	@Override
	public Roles getRoles() {
		// anonymous users have only one role
		return new Roles("is_anonymous");
	}

	@Override
	public boolean equals(Object user) {
		if (user instanceof AnonUser) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
