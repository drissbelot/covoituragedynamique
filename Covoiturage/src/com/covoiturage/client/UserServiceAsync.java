/*
 * 
 */
package com.covoiturage.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserServiceAsync.
 */
public interface UserServiceAsync {

	/**
	 * Login.
	 *
	 * @param login the login
	 * @param password the password
	 * @param callback the callback
	 */
	void login(String login, String password, AsyncCallback<String> callback);

	/**
	 * Gets the user.
	 *
	 * @param callback the callback
	 * @return the user
	 */
	void getUser(AsyncCallback<String> callback);

}
