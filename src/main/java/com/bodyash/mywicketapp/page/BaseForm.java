package com.bodyash.mywicketapp.page;


import org.apache.wicket.Session;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

import com.bodyash.mywicketapp.WicketApplication;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.wicket.security.UserSession;


public abstract class BaseForm<T> extends Form<T>  {

	private static final long serialVersionUID = 1L;

	public BaseForm(String id) {
		super(id);
	}

	public BaseForm(String id, IModel<T> model) {
		super(id, model);
	}

	/**
	 * Get application specific UserSession
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UserSession<UserModel> getSession() {
		return (UserSession<UserModel>) Session.get();
	}

	/**
	 * Get application specific WebApplication 
	 */
	public WicketApplication getApp() {
		return (WicketApplication) getApplication();
	}

	/**
	 * Translate and post error message in form
	 * 
	 * @param message
	 */
	public void transError(String message) {
		error((message).toString());
	}

	/**
	 * Translate and flash info message
	 *  
	 * @param message
	 */
	public void flashInfo(String message) {
		getSession().info((message).toString());
	}
}
