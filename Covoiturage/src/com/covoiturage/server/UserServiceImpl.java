/*
 * 
 */
package com.covoiturage.server;

import javax.servlet.http.HttpSession;

import com.covoiturage.client.UserService;
import com.covoiturage.server.domain.UserInfo;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserServiceImpl.
 */
public class UserServiceImpl extends RemoteServiceServlet implements
		UserService {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.covoiturage.client.UserService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public String login(String login, String password) {

		Objectify ofy = ObjectifyService.begin();
		UserInfo user = new UserInfo();
		user = ofy.query(UserInfo.class).filter("login", login).get();

		if (BCrypt.checkpw(password, user.getPassword())) {

			user.setLoggedIn(true);
			ofy.put(user);
			HttpSession httpSession = getThreadLocalRequest().getSession();
			httpSession.setMaxInactiveInterval(1000 * 60 * 5);
			httpSession.setAttribute("LOGGED_IN_USER", user.getId().toString());
			return httpSession.getId();
		} else
			return null;

	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.UserService#getUser()
	 */
	@Override
	public String getUser() {
		HttpSession httpSession = getThreadLocalRequest().getSession();
		return (String) httpSession.getAttribute("LOGGED_IN_USER");
	}

}
