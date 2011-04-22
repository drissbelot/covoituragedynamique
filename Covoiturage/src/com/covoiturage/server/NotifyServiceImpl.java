package com.covoiturage.server;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;

import com.covoiturage.client.NotifyService;
import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.domain.UserInfo;
import com.covoiturage.server.domain.UserInfoDetails;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NotifyServiceImpl extends RemoteServiceServlet implements
		NotifyService {

	private static final long serialVersionUID = 1L;

	@Override
	public String sendMessage(String userDetailsId, String subject,
			String text, String from, Date date) {
		UserInfoDetails userDetails = UserInfoDetails
				.findUserInfoDetails(userDetailsId);
		UserInfo user = UserInfo.findUserInfo(userDetails.getUser());
		EntityManager em = EMF.get().createEntityManager();
		Messages message = new Messages();
		try {
			em.getTransaction().begin();
			message.setMessage(text);
			message.setRead(false);
			message.setDate(date);
			message.setFrom(from);
			message.setSubject(subject);
			em.persist(message);
			em.getTransaction().commit();

		} finally {
			em.close();
		}
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = text;

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("dontreply@covdyn.appspot.com",
					"Covdyn Admin"));
			msg.addRecipient(
					Message.RecipientType.TO,
					new InternetAddress(user.getEmailAddress(), userDetails
							.getFirstName() + " " + userDetails.getLastName()));
			msg.setSubject(subject);
			msg.setText(msgBody);
			Transport.send(msg);

		} catch (AddressException e) {

		} catch (MessagingException e) {

		} catch (UnsupportedEncodingException e) {

		}

		ChannelServer.sendMessage(userDetails, text);
		return message.getId();

	}

}
