/*
 * 
 */
package com.covoiturage.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

// TODO: Auto-generated Javadoc
/**
 * The Interface NotifyServiceAsync.
 */
public interface NotifyServiceAsync {
	
	/**
	 * Send message.
	 *
	 * @param passenger the passenger
	 * @param subject the subject
	 * @param text the text
	 * @param from the from
	 * @param date the date
	 * @param asyncCallback the async callback
	 */
	void sendMessage(Long passenger, String subject, String text,
			String from, Date date, AsyncCallback<Long> asyncCallback);

}
