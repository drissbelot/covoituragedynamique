package com.covoiturage.shared;

import java.util.Date;

import com.covoiturage.server.domain.Messages;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(Messages.class)
public interface MessagesProxy extends EntityProxy {
	EntityProxyId<MessagesProxy> stableId();

	public String getId();

	public void setMessage(String message);

	public String getMessage();

	public void setRead(boolean read);

	public boolean getRead();

	public String getFrom();

	public void setFrom(String from);

	public Date getDate();

	public void setDate(Date date);

	public void setSubject(String subject);

	public String getSubject();
}
