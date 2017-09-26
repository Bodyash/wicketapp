package com.bodyash.mywicketapp.page;

import org.apache.wicket.spring.injection.annot.SpringBean;

import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.form.UserEditForm;

public class UserEditPage extends BasePage{

	private static final long serialVersionUID = 1L;
	@SpringBean
	private UserDao userDao;
	public UserEditPage(){
		UserEditForm form = new UserEditForm("userEditForm", userDao.getUserById(this.getRequest().getRequestParameters().getParameterValue("id").toLong()));
		add(form);
	}

}
