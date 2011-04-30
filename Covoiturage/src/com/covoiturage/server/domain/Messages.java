package com.covoiturage.server.domain;

import java.util.Date;



import javax.persistence.Entity;



@Entity
public class Messages extends DatastoreObject{


	private String message;
	private boolean read;
	private String subject;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private String from;
	private Date date;

	


	public Messages() {
	}

	public Messages(String message, boolean read, String from,
			Date date) {

		this.setMessage(message);
		this.setRead(read);
		this.setFrom(from);
		this.setDate(date);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean getRead() {
		return read;
	}

	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}
}
