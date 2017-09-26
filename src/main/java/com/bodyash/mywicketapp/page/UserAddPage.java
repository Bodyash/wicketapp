package com.bodyash.mywicketapp.page;

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.form.UserAddForm;

public class UserAddPage extends BasePage{
	
	public UserAddPage(){
		UserAddForm form = new UserAddForm("userAddForm");
		add(form);
	}

}
