package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.MessagesDao;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(value = MessagesDao.class, locator = DaoServiceLocator.class)
public interface MessagesRequest extends RequestContext {
	Request<Long> countMessages();

	Request<List<MessagesProxy>> findAllMessages();

	Request<MessagesProxy> findMessages(Long id);

	Request<Long> persist(MessagesProxy message);

	Request<Void> remove(MessagesProxy message);

}
