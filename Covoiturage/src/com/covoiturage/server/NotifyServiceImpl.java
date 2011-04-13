package com.covoiturage.server;

import java.util.Date;

import javax.persistence.EntityManager;

import com.covoiturage.client.NotifyService;

import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.domain.UserInfoDetails;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NotifyServiceImpl extends RemoteServiceServlet  implements NotifyService {

	private static final long serialVersionUID = 1L;


	

	@Override
	public String sendMessage(String userDetails, String subject, String text,
			String from, Date date) {
		UserInfoDetails user=	UserInfoDetails.findUserInfoDetails(userDetails);
		EntityManager em = EMF.get().createEntityManager();
		Messages message=new Messages();
		try{
		em.getTransaction().begin();
		message.setMessage(text);
		message.setRead(false);
		message.setDate(date);
		message.setFrom(from);
		message.setSubject(subject);
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
