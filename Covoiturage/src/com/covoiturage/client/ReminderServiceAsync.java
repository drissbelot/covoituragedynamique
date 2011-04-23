package com.covoiturage.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ReminderServiceAsync {
	void sendMessage(String userDetails, String subject, String text,
			String from, Date date, AsyncCallback<String> callback);

}
