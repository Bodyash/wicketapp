package com.bodyash.wicketapp.security;

import org.apache.wicket.Page;

public interface ISecureApplication {
	Class<? extends Page> getLoginPage();
}
