package com.covoiturage.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("notifyService")
public interface NotifyService extends RemoteService {

	String sendMessage(String userDetails, String subject, String text,
			String from, Date date);

}
