package com.covoiturage.server;

import com.covoiturage.client.UserAccountService;
import com.covoiturage.shared.UserInfo;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UserAccountServiceImpl extends RemoteServiceServlet implements UserAccountService{

	@Override
	public UserInfo login(String requestUri) {

			    UserService userService = UserServiceFactory.getUserService();
			    User user = userService.getCurrentUser();
			    UserInfo userInfo = new UserInfo();

			    if (user != null) {

			      userInfo.setLoggedIn(true);
			      userInfo.setEmailAddress(user.getEmail());
			      userInfo.setLogin(user.getNickname());
			      userInfo.setLogoutUrl(userService.createLogoutURL(requestUri));

			      
			      
			    } else {
			      userInfo.setLoggedIn(false);
			      userInfo.setLoginUrl(userService.createLoginURL(requestUri));

			    }
			    return userInfo;


	}
	

}
