package com.covoiturage.shared;

import com.covoiturage.server.domain.Messages;


import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(Messages.class)
public interface MessagesProxy extends EntityProxy{
	EntityProxyId<MessagesProxy> stableId();
	public String getId();

	public void setMessage(String message);

	public String getMessage();

	public void setRead(boolean read);

	public boolean isRead(); 
}
