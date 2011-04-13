package com.covoiturage.server;

import javax.persistence.EntityManager;

import com.covoiturage.client.NotifyService;

import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.domain.UserInfoDetails;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NotifyServiceImpl extends RemoteServiceServlet  implements NotifyService {

	private static final long serialVersionUID = 1L;


	public String sendMessage(String userId, String text){
		UserInfoDetails user=	UserInfoDetails.findUserInfoDetails(userId);
		EntityManager em = EMF.get().createEntityManager();
		Messages message=new Messages();
		try{
		em.getTransaction().begin();
		message.setMessage(text);
		message.setRead(false);
		em.persist(message);		
		em.getTransaction().commit();
		
		}
		finally{
			em.close();
		}
		//TODO envoyer mail
		ChannelServer.sendMessage(user,	text);
		return message.getId();
	}


}
