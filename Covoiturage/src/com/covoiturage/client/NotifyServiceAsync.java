package com.covoiturage.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NotifyServiceAsync {
	void sendMessage(Long passenger, String subject, String text,
			String from, Date date, AsyncCallback<Long> asyncCallback);

}
