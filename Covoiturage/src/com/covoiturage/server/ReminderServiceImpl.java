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
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.domain.UserInfo;
import com.covoiturage.server.domain.UserInfoDetails;

public class ReminderServiceImpl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userDetailsId = request.getParameter("passenger");
		UserInfoDetails userDetails = UserInfoDetails
				.findUserInfoDetails(userDetailsId);
		UserInfo user = UserInfo.findUserInfo(userDetails.getUser());
		String text = "Someone not replying";
		EntityManager em = EMF.get().createEntityManager();
		Messages message = new Messages();
		try {
			em.getTransaction().begin();
			message.setMessage(text);
			message.setRead(false);
			message.setDate(new Date(System.currentTimeMillis()));
			message.setFrom("Covdyn Admin");
			// TODO affiner (peut-être en passant plus de paramètres)
			message.setSubject(text);
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
