package com.bodyash.mywicketapp.auth.register;

import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.page.BaseForm;


public class RegisterForm extends BaseForm<UserModel> {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private transient UserDao userDao;

	public RegisterForm(String id, IModel<UserModel> model) {
		super(id, model);
	}

	public RegisterForm(String id, UserModel user) {
		this(id, new CompoundPropertyModel<UserModel>(user));
	}

	@Override
	public void onSubmit() {
		UserModel user = getModelObject();
		//System.out.println(user.getEmail());
		System.out.println((userDao == null));
		userDao.addUser(user);

		flashInfo("You have successfully registered. You can login now.");

		setResponsePage(getApp().getLoginPage());
	}
}
