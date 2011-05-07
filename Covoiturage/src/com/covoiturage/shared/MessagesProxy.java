/*
 * 
 */
package com.covoiturage.shared;

import java.util.Date;

import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessagesProxy.
 */
@ProxyFor(value = Messages.class, locator = ObjectifyLocator.class)
public interface MessagesProxy extends EntityProxy {

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId();

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message);

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage();

	/**
	 * Sets the read.
	 *
	 * @param read the new read
	 */
	public void setRead(boolean read);

	/**
	 * Gets the read.
	 *
	 * @return the read
	 */
	public boolean getRead();

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom();

	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(String from);

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate();

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date);

	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject);

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject();
}
