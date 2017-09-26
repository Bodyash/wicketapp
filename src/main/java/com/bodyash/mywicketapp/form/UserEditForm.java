package com.bodyash.mywicketapp.form;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.page.BaseForm;
import com.bodyash.mywicketapp.page.HomePage;

public class UserEditForm extends BaseForm<UserModel> {
	
	@SpringBean
	private UserDao userDao;
	private UserModel user;
	private TextField email;
	private TextField firstname;
	private TextField secondname;
	private TextField middlename;

	public UserEditForm(String id, UserModel user) {
		super(id);
		this.user = user;
		
		email = new TextField("email", Model.of(user.getEmail()));
		email.add(EmailAddressValidator.getInstance());
		firstname = new TextField("firstname", Model.of(user.getFirstName()));
		secondname = new TextField("secondname", Model.of(user.getSecondName()));
		middlename = new TextField("middlename", Model.of(user.getMiddleName()));
		Button saveButton = new Button("save_button");
		
		add(email);
		add(firstname);
		add(secondname);
		add(middlename);
		add(saveButton);
	}
	
	@Override
	protected void onSubmit() {
		user.setEmail((String)this.email.getDefaultModelObject());
		user.setFirstName((String)this.firstname.getDefaultModelObject());
		user.setSecondName((String)this.secondname.getDefaultModelObject());
		user.setMiddleName((String)this.middlename.getDefaultModelObject());
		userDao.updateUser(user);
		setResponsePage(HomePage.class);
	}


}
