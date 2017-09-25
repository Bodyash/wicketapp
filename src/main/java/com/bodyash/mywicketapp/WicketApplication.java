package com.bodyash.mywicketapp;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bodyash.mywicketapp.auth.dao.UserAnonymous;
import com.bodyash.mywicketapp.auth.dao.UserModel;
import com.bodyash.mywicketapp.auth.login.LoginPage;
import com.bodyash.mywicketapp.auth.register.RegisterPage;
import com.bodyash.mywicketapp.page.HomePage;
import com.bodyash.mywicketapp.wicket.security.ISecureApplication;
import com.bodyash.mywicketapp.wicket.security.UserRoleAuthorizationStrategy;
import com.bodyash.mywicketapp.wicket.security.UserRolesAuthorizer;
import com.bodyash.mywicketapp.wicket.security.UserSession;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.bodyash.mywicketapp.Start#main(String[])
 */
public class WicketApplication extends WebApplication implements ISecureApplication {

	public WicketApplication() {
	}

	// start page
	@Override
	public Class<HomePage> getHomePage() {
		return HomePage.class;
	}

	// page for auth
	@Override
	public Class<LoginPage> getLoginPage() {
		return LoginPage.class;
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new UserSession<UserModel>(request, new UserAnonymous());
	}

	protected void initSpring() {
		// Initialize Spring Dependency Injection
		AnnotationConfigApplicationContext springContext = 
		         new AnnotationConfigApplicationContext();
		    springContext.register(AppConfig.class);
		    springContext.refresh();
		    getComponentInstantiationListeners().add(new SpringComponentInjector(this, 
		         springContext, false));
	}

	@Override
	public void init() {
		initSpring();
		// don't throw exceptions for missing translations
		getResourceSettings().setThrowExceptionOnMissingResource(false);

		// enable ajax debug etc.
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);

		// customized auth strategy
		getSecuritySettings().setAuthorizationStrategy(new UserRoleAuthorizationStrategy(new UserRolesAuthorizer()));

		// make markup friendly as in deployment-mode
		getMarkupSettings().setStripWicketTags(true);

		// page mounts / SEO
		mountPage("/login/", LoginPage.class);
		mountPage("/register/", RegisterPage.class);
	}
}
