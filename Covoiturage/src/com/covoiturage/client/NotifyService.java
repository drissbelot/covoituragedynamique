/*
 * 
 */
package com.covoiturage.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

// TODO: Auto-generated Javadoc
/**
 * The Interface NotifyService.
 */
@RemoteServiceRelativePath("notifyService")
public interface NotifyService extends RemoteService {

	/**
	 * Send message.
	 *
	 * @param passenger the passenger
	 * @param subject the subject
	 * @param text the text
	 * @param from the from
	 * @param date the date
	 * @return the long
	 */
	long sendMessage(Long passenger, String subject, String text, String from,
			Date date);

}
