/*
 * 
 */
package com.covoiturage.shared;

import com.covoiturage.server.domain.UserInfo;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserInfoProxy.
 */
@ProxyFor(value = UserInfo.class, locator = ObjectifyLocator.class)
public interface UserInfoProxy extends EntityProxy {

	/**
	 * Gets the logged in.
	 *
	 * @return the logged in
	 */
	public boolean getLoggedIn();

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin();

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login);

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public String getEmailAddress();

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Gets the default user.
	 *
	 * @return the default user
	 */
	public UserInfoProxy getDefaultUser();

	/**
	 * Sets the logged in.
	 *
	 * @param b the new logged in
	 */
	public void setLoggedIn(boolean b);

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password);

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId();

}
