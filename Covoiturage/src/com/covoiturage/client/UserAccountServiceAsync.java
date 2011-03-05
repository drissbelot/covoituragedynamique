package com.covoiturage.client;

import com.covoiturage.shared.UserInfo;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserAccountServiceAsync {

	public void login(String email, String password, AsyncCallback<UserInfo> callback);

	void addUser(String login, String password, AsyncCallback<UserInfo> callback);

}
