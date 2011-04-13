package com.covoiturage.client;



import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("userService")

public interface UserService extends RemoteService{
String login(String login, String password);
String getUser();
	
}
