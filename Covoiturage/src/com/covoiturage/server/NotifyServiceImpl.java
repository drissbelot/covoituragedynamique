package com.covoiturage.server;






import com.covoiturage.client.NotifyService;

import com.covoiturage.server.domain.UserInfoDetails;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NotifyServiceImpl extends RemoteServiceServlet  implements NotifyService {

	private static final long serialVersionUID = 1L;
	
	
	public void sendMessage(String userId, String text){
	UserInfoDetails user=	UserInfoDetails.findUserInfoDetails(userId);

	ChannelServer.sendMessage(user,	text);
	}


}
