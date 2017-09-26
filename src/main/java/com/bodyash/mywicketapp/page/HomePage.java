package com.bodyash.mywicketapp.page;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;

import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.panel.UserListPanel;



public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;
	@SpringBean
	private UserDao userDao;

	public HomePage() {

    	UserModel user = getUser();
    	String userName = "Anonymous";

    	// Set E-Mail as username if have one and link to add New User
    	if(Strings.isEmpty(user.getEmail()) == false) {
    		userName = user.getEmail();
    	}
    	
    	
        // Greeting
    	add(new Label("userGreeting", userName));
    	
    	
    	
    	
		//CRUD panel for authenticated users
    	if(this.getRequest().getRequestParameters().getParameterValue("search").toString() != null){
    		add(new UserListPanel("userListPanel", this.getRequest().getRequestParameters().getParameterValue("search").toString()));
    	}else{
    		add(new UserListPanel("userListPanel"));
    	}
		//use this option to TOTAL refresh the page + load fresh data from DB every time
		//setVersioned(false);
    }
}
