/*
 * 
 */
package com.covoiturage.server.domain;

import java.util.Date;



import javax.persistence.Entity;



// TODO: Auto-generated Javadoc
/**
 * The Class Messages.
 */
@Entity
public class Messages extends DatastoreObject{


	/** The message. */
	private String message;
	
	/** The read. */
	private boolean read;
	
	/** The subject. */
	private String subject;

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/** The from. */
	private String from;
	
	/** The date. */
	private Date date;

	


	/**
	 * Instantiates a new messages.
	 */
	public Messages() {
	}

	/**
	 * Instantiates a new messages.
	 *
	 * @param message the message
	 * @param read the read
	 * @param from the from
	 * @param date the date
	 */
	public Messages(String message, boolean read, String from,
			Date date) {

		this.setMessage(message);
		this.setRead(read);
		this.setFrom(from);
		this.setDate(date);
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the read.
	 *
	 * @param read the new read
	 */
	public void setRead(boolean read) {
		this.read = read;
	}

	/**
	 * Gets the read.
	 *
	 * @return the read
	 */
	public boolean getRead() {
		return read;
	}

	
	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
}
