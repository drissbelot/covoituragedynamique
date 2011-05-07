/*
 * 
 */
package com.covoiturage.server;

import java.io.IOException;
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.domain.UserInfo;
import com.covoiturage.server.domain.UserInfoDetails;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

// TODO: Auto-generated Javadoc
/**
 * The Class ReminderServiceImpl.
 */
public class ReminderServiceImpl extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userDetailsId = request.getParameter("passenger");
		Objectify ofy=  ObjectifyService.begin();
		UserInfoDetails userDetails = ofy.find(UserInfoDetails.class,userDetailsId);
		UserInfo user = ofy.find(UserInfo.class,userDetails.getUser());
		String text = "Someone not replying";

		Messages message = new Messages();
		
			
			message.setMessage(text);
			message.setRead(false);
			message.setDate(new Date(System.currentTimeMillis()));
			message.setFrom("Covdyn Admin");
			// TODO affiner (peut-être en passant plus de paramètres)
			message.setSubject(text);
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
			msg.setSubject(text);
			msg.setText(msgBody);
			Transport.send(msg);

		} catch (AddressException e) {

		} catch (MessagingException e) {

		} catch (UnsupportedEncodingException e) {

		}

		ChannelServer.sendMessage(userDetails, text);

	}

}
