package com.bodyash.mywicketapp.panel;

import java.util.ArrayList;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.bodyash.mywicketapp.AppConfig;
import com.bodyash.mywicketapp.auth.dao.UserDao;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.form.UserSearchForm;
import com.bodyash.mywicketapp.page.HomePage;
import com.bodyash.mywicketapp.page.UserAddPage;
import com.bodyash.mywicketapp.page.UserEditPage;

@AuthorizeAction(action=Action.RENDER, roles="is_user")
public class UserListPanel extends Panel{
	
	@SpringBean
	private UserDao userDao;
	private static final long serialVersionUID = 1L;
	
	public UserListPanel(String id, String search) {
		super(id);
		ArrayList<UserModel> list = new ArrayList<>();
		list.addAll(userDao.findByUsername(search));
		init(list);
	}

	public UserListPanel(String id) {
		super(id);
		ArrayList<UserModel> list = new ArrayList<>();
		list.addAll(userDao.listUsers());
		init(list);
	}
	
	private void init(ArrayList<UserModel> list) {
		DataView<UserModel> dataView = new DataView<UserModel>("userList", new ListDataProvider<UserModel>(
                list)) {
					private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(Item<UserModel> arg0) {
				final UserModel user = (UserModel) arg0.getModelObject();
				arg0.add(new Label("id", user.getId()));
				arg0.add(new Label("email", user.getEmail()));
				arg0.add(new Label("firstname", user.getFirstName()));
				arg0.add(new Label("secondname", user.getSecondName()));
				arg0.add(new Label("middlename", user.getMiddleName()));

				final Button deleteButton = new Button("delete_button");
				deleteButton.setMarkupId(user.getId().toString());
				Form form = new Form("delete_form"){
					@Override
					protected void onBeforeRender() {
						add(deleteButton);
						super.onBeforeRender();
					}
					@Override
					protected void onSubmit() {
						userDao.deleteUser(Long.valueOf(deleteButton.getMarkupId()));
						setResponsePage(HomePage.class);
					}
				};
				arg0.add(form);
				arg0.add(new Link("user_edit"){

					@Override
					public void onClick() {
						PageParameters pp = new PageParameters();
						pp.add("id", user.getId());
						setResponsePage(UserEditPage.class, pp);
					}
					
				});
			}
        };
        add(new UserSearchForm("userSearchForm"));
        add(new Link("user_add"){
			@Override
			public void onClick() {
				setResponsePage(UserAddPage.class);
			}
        });
        add(dataView);
	}

}
