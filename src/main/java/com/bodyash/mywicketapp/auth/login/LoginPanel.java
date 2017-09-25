package com.bodyash.mywicketapp.auth.login;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.bodyash.mywicketapp.auth.dao.UserModel;


public class LoginPanel extends Panel {
	private static final long serialVersionUID = 1L;

	public LoginPanel(String id, UserModel user) {
		super(id);

		LoginForm loginForm = new LoginForm("loginForm", user);

		loginForm.add(new RequiredTextField<String>(UserModel.EMAIL)
			.add(EmailAddressValidator.getInstance()));
		loginForm.add(new PasswordTextField(UserModel.PASSWORD));

		add(loginForm);
	}
}
