package com.bodyash.mywicketapp.panel;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

// show for authenticated users only
@AuthorizeAction(action=Action.RENDER, roles="is_user")
public class AuthPanel extends Panel {
	private static final long serialVersionUID = 1L;

	public AuthPanel(String id) {
		super(id);
		add(new Link<Void>("url_logout") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				getSession().invalidateNow();
				setResponsePage(getApplication().getHomePage());
			}
		});
	}
}
