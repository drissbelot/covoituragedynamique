package com.covoiturage.client;

import com.covoiturage.shared.UserInfo;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("userAccount")
public interface UserAccountService extends RemoteService{
	public UserInfo login(String email, String password);

	public UserInfo addUser(String login, String password);

}
