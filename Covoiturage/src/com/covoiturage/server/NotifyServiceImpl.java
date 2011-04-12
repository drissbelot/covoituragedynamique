package com.covoiturage.server;








import javax.persistence.EntityManager;

import com.covoiturage.client.NotifyService;

import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.domain.UserInfoDetails;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NotifyServiceImpl extends RemoteServiceServlet  implements NotifyService {

	private static final long serialVersionUID = 1L;


	public void sendMessage(String userId, String text){
		UserInfoDetails user=	UserInfoDetails.findUserInfoDetails(userId);
		
		Messages message=new Messages();
		message.setMessage(text);
		message.setRead(false);
		EntityManager em = EMF.get().createEntityManager();
		em.persist(message);

		
		em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		user.addMessage(message.getId());
		em.getTransaction().commit();
		//TODO envoyer mail
		ChannelServer.sendMessage(user,	text);
	}


}
