package com.covoiturage.shared;

import java.util.List;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

import com.covoiturage.server.domain.Messages;

@Service(Messages.class)
public interface MessagesRequest extends RequestContext {
	Request<Long> countMessages();

	Request<List<MessagesProxy>> findAllMessages();

	Request<MessagesProxy> findMessages(String id);

	InstanceRequest<MessagesProxy, String> persist();

	InstanceRequest<MessagesProxy, Void> remove();

}
