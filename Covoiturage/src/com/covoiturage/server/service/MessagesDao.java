/*
 * 
 */
package com.covoiturage.server.service;

import java.util.List;

import com.covoiturage.server.domain.Messages;
import com.google.appengine.api.datastore.EntityNotFoundException;



// TODO: Auto-generated Javadoc
/**
 * The Class MessagesDao.
 */
public class MessagesDao extends ObjectifyDao<Messages> {
	
	/**
	 * Count messages.
	 *
	 * @return the long
	 */
	public Long countMessages(){
		return (long) this.listAll().size();
	}

	/**
	 * Find all messages.
	 *
	 * @return the list
	 */
	public List<Messages> findAllMessages(){
		return this.listAll();
	}

	/**
	 * Find messages.
	 *
	 * @param id the id
	 * @return the messages
	 */
	public Messages findMessages(Long id){
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	/**
	 * Persist.
	 *
	 * @param message the message
	 * @return the long
	 */
	public Long persist(Messages message){
		this.put(message);
		return message.getId();
	}

	/**
	 * Removes the.
	 *
	 * @param message the message
	 */
	public void remove(Messages message){
		this.delete(message);
	}
}
