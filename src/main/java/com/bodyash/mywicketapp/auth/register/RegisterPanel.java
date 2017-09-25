package com.bodyash.mywicketapp.auth.register;

import static org.apache.wicket.validation.validator.StringValidator.minimumLength;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.auth.dao.UserModel;



public class RegisterPanel extends Panel {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private UserDao userDao;

	public RegisterPanel(String id, UserModel user) {
		super(id);

		RegisterForm registerForm = new RegisterForm("registerForm", user);

		// check with regexp for valid email
		// then check if not already registered
		registerForm.add(new RequiredTextField<String>(UserModel.EMAIL)
			.add(EmailAddressValidator.getInstance()));

		// minimum 3 chars length
		registerForm.add(new PasswordTextField(UserModel.PASSWORD)
			.add(minimumLength(3)));

		add(registerForm);
	}
}
