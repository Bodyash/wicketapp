package com.bodyash.mywicketapp.auth.register;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;

import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.auth.page.AuthBasePage;


@AuthorizeInstantiation("is_anonymous")
public class RegisterPage extends AuthBasePage {
	private static final long serialVersionUID = 1L;

	public RegisterPage() {
		UserModel user = new UserModel();
		add(new RegisterPanel("registerPanel", user));
	}
}
