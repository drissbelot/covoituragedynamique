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
	public UserInfo login(String email, String password) {

		new AppMisc().populateDataStoreOnce();
		return UserInfo.toDTO(UserInfo.getDefaultUser());

		


	}
	

}
