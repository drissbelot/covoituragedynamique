/*
 * 
 */
package com.covoiturage.shared;

import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.MessagesDao;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessagesRequest.
 */
@Service(value = MessagesDao.class, locator = DaoServiceLocator.class)
public interface MessagesRequest extends RequestContext {
	
	/**
	 * Count messages.
	 *
	 * @return the request
	 */
	Request<Long> countMessages();

	/**
	 * Find all messages.
	 *
	 * @return the request
	 */
	Request<List<MessagesProxy>> findAllMessages();

	/**
	 * Find messages.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<MessagesProxy> findMessages(Long id);

	/**
	 * Persist.
	 *
	 * @param message the message
	 * @return the request
	 */
	Request<Long> persist(MessagesProxy message);

	/**
	 * Removes the.
	 *
	 * @param message the message
	 * @return the request
	 */
	Request<Void> remove(MessagesProxy message);

}
