package com.bodyash.wicketapp.security;

public interface IUserSession<T extends IAuthModel> {
	
	T getUser();

	void setUser(T user);

}
