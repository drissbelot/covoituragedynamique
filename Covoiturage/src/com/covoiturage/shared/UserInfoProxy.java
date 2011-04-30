package com.covoiturage.shared;

import com.covoiturage.server.domain.UserInfo;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.gwt.requestfactory.shared.EntityProxy;

import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(value=UserInfo.class,locator=ObjectifyLocator.class)
public interface UserInfoProxy extends EntityProxy {

	public boolean getLoggedIn();

	public String getLogin();

	public void setLogin(String login);

	public String getEmailAddress();

	public void setEmailAddress(String emailAddress);

	public UserInfoProxy getDefaultUser();

	public void setLoggedIn(boolean b);

	public void setPassword(String password);

	public String getPassword();


	public Long getId();

}
