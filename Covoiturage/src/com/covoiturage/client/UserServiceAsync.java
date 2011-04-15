package com.covoiturage.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync {

	void login(String login, String password, AsyncCallback<String> callback);

	void getUser(AsyncCallback<String> callback);

}
