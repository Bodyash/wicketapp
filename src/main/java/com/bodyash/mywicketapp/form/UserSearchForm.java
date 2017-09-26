package com.bodyash.mywicketapp.form;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.page.BaseForm;
import com.bodyash.mywicketapp.page.HomePage;

public class UserSearchForm extends BaseForm<UserModel>{
	private TextField name;
	private Button searchButton;
	public UserSearchForm(String id) {
		super(id);
		this.name = new TextField<String>("name", Model.of(""));
		this.searchButton = new Button("searchButton");
		
		add(name);
		add(searchButton);
		
	}
	
	@Override
	protected void onSubmit() {
		String search = (String)this.name.getDefaultModelObject();
		if (search != null){
			PageParameters pp = new PageParameters();
			pp.add("search", search);
			setResponsePage(HomePage.class, pp);
		}else{
			setResponsePage(HomePage.class);
		}
	}

}
