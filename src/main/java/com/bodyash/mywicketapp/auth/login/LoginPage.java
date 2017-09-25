package com.bodyash.mywicketapp.auth.login;

import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.auth.page.AuthBasePage;

public class LoginPage extends AuthBasePage {
	private static final long serialVersionUID = 1L;

	public LoginPage() {
		UserModel userModel = new UserModel();
		add(new LoginPanel("loginPanel", userModel));
	}	
}
