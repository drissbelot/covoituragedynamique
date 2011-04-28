package com.covoiturage.shared;

import com.covoiturage.server.domain.UserInfo;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(UserInfo.class)
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

	@Override
	EntityProxyId<UserInfoProxy> stableId();

	public String getId();

}
