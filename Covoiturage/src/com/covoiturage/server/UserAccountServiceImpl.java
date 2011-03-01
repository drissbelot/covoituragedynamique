package com.covoiturage.server;

import com.covoiturage.client.UserAccountService;
import com.covoiturage.shared.UserInfo;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class UserAccountServiceImpl extends RemoteServiceServlet implements UserAccountService{

	@Override
	public UserInfo login(String email, String password) {

			    UserService userService = UserServiceFactory.getUserService();
			    User user = userService.getCurrentUser();
			    UserInfo userInfo = new UserInfo();

			    if (user != null) {

			      userInfo.setLoggedIn(true);
			      userInfo.setEmailAddress(user.getEmail());
			      userInfo.setLogin(user.getNickname());
			      
			      
			    } else {
			      userInfo.setLoggedIn(false);
			      
			    }
			    return userInfo;


	}
	

}
