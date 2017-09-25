package com.bodyash.mywicketapp.auth.login;

import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.page.BaseForm;


public class LoginForm extends BaseForm<UserModel> {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private UserDao userDao;

	public LoginForm(String id, IModel<UserModel> model) {
		super(id, model);
	}

	public LoginForm(String id, UserModel userModel) {
		this(id, new CompoundPropertyModel<UserModel>(userModel));
	}

	@Override
	public void onSubmit() {
		UserModel user = userDao.getUser(getModelObject().getId());

		// check if user can login and do login
		if(user != null
				&& user.getPassword().equals((getModelObject().getPassword()))
				&& user.hasRole("is_user")) {

			// login user
			getSession().setUser(user);

			// goto home page
			setResponsePage(getApp().getHomePage());
			return;
		}

		transError("Wrong user data.");
	}
}
