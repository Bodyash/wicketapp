package com.bodyash.wicketapp.security;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;

public interface IAuthModel {
	
	public org.apache.wicket.authroles.authorization.strategies.role.Roles getRoles();
	public boolean hasAnyRole(Roles roles);
	public boolean hasRole(String role);

}
