package com.bodyash.mywicketapp.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.util.string.Strings;

import com.bodyash.mywicketapp.auth.dao.UserModel;



public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;

	public HomePage() {

    	UserModel user = getUser();
    	String userName = "Anonymous";

    	// Set E-Mail as username if have one
    	if(Strings.isEmpty(user.getEmail()) == false) {
    		userName = user.getEmail();
    	}
    	
        // Greeting
    	add(new Label("userGreeting", userName));
    }
}
