package com.covoiturage.client;




import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NotifyServiceAsync {
	void sendMessage(String userDetails, String text, AsyncCallback<String> callback);
	

}
