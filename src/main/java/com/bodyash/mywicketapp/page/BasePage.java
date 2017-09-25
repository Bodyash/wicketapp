package com.bodyash.mywicketapp.page;

import org.apache.wicket.markup.html.WebPage;

import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.panel.AnonymPanel;
import com.bodyash.mywicketapp.panel.AuthPanel;
import com.bodyash.mywicketapp.wicket.security.UserSession;


abstract public class BasePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public BasePage() {

		// panel for guests
		add(new AnonymPanel("anonymPanel"));

		// panel for authenticated users
		add(new AuthPanel("authPanel"));
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserSession<UserModel> getSession() {
		return (UserSession<UserModel>)super.getSession();
	}

	public UserModel getUser() {
		return getSession().getUser();
	}
}
