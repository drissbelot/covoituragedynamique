package com.covoiturage.client;

import com.covoiturage.shared.UserInfo;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserAccountServiceAsync {

	public void login(String lgin, String password, AsyncCallback<UserInfo> callback);

}
