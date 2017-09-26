package com.bodyash.mywicketapp.form;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.EmailAddressValidator;

import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.page.BaseForm;
import com.bodyash.mywicketapp.page.HomePage;

public class UserAddForm extends BaseForm<UserModel> {
	
	@SpringBean
	private UserDao userDao;
	private UserModel user;
	private TextField email;
	private TextField firstname;
	private TextField secondname;
	private TextField middlename;
	private PasswordTextField password;
	
	public UserAddForm(String id) {
		super(id);
		this.user = new UserModel();
		
		email = new TextField(UserModel.EMAIL, Model.of(""));
		firstname = new TextField(UserModel.FIRSTNAME, Model.of(""));
		secondname = new TextField(UserModel.SECONDNAME, Model.of(""));
		middlename = new TextField(UserModel.MIDDLENAME, Model.of(""));
		password = new PasswordTextField(UserModel.PASSWORD, Model.of(""));
		Button saveButton = new Button("add_button");
		
		add(email);
		add(firstname);
		add(secondname);
		add(middlename);
		add(password);
		add(saveButton);
	}

	@Override
	protected void onSubmit() {
		user.setEmail((String)this.email.getDefaultModelObject());
		user.setFirstName((String)this.firstname.getDefaultModelObject());
		user.setSecondName((String)this.secondname.getDefaultModelObject());
		user.setMiddleName((String)this.middlename.getDefaultModelObject());
		user.setPassword((String)this.password.getDefaultModelObject());
		if(userDao.getUser(user.getEmail()) == null){
			userDao.addUser(user);
		}else{
			transError("User email already registered");
		}
		
		setResponsePage(HomePage.class);
	}


}
