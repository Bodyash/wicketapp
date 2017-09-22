package com.bodyash.wicketapp.pages;

import org.apache.wicket.markup.html.WebPage;

import com.bodyash.wicketapp.bean.User;
import com.bodyash.wicketapp.security.UserSession;

public class BasePage extends WebPage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public UserSession<User> getSession() {
		return (UserSession<User>)super.getSession();
	}

}
