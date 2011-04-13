package com.covoiturage.client;





import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("notifyService")

public interface NotifyService extends RemoteService{
	String sendMessage(String userDetails, String text);
	
}
