/*
 * 
 */
package com.covoiturage.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	
	/**
	 * Login.
	 *
	 * @param login the login
	 * @param password the password
	 * @return the string
	 */
	String login(String login, String password);

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	String getUser();

}
