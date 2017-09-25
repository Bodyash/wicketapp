package com.bodyash.mywicketapp.panel;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

import com.bodyash.mywicketapp.auth.login.LoginPage;
import com.bodyash.mywicketapp.auth.register.RegisterPage;


// show for anonymous users only
@AuthorizeAction(action=Action.RENDER, roles="is_anonymous")
public class AnonymPanel extends Panel {
	private static final long serialVersionUID = 1L;

	public AnonymPanel(String id) {
		super(id);
		add(new BookmarkablePageLink<Void>("url_login", LoginPage.class));
		add(new BookmarkablePageLink<Void>("url_register", RegisterPage.class));
	}
}
