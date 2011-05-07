/*
 * 
 */
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


import com.covoiturage.client.NotifyService;
import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.domain.UserInfo;
import com.covoiturage.server.domain.UserInfoDetails;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

// TODO: Auto-generated Javadoc
/**
 * The Class NotifyServiceImpl.
 */
public class NotifyServiceImpl extends RemoteServiceServlet implements
		NotifyService {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see com.covoiturage.client.NotifyService#sendMessage(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public long sendMessage(Long userDetailsId, String subject,
			String text, String from, Date date) {
		Objectify ofy=  ObjectifyService.begin();
		UserInfoDetails userDetails = ofy.find(UserInfoDetails.class,userDetailsId);
		UserInfo user = ofy.find(UserInfo.class,userDetails.getUser());
		Messages message = new Messages();
	

			message.setMessage(text);
			message.setRead(false);
			message.setDate(date);
			message.setFrom(from);
			message.setSubject(subject);

			ofy.put(message);
	
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
