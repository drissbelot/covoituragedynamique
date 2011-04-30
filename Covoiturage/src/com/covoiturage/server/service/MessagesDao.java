package com.covoiturage.server.service;

import java.util.List;

import com.covoiturage.server.domain.Messages;
import com.google.appengine.api.datastore.EntityNotFoundException;



public class MessagesDao extends ObjectifyDao<Messages> {
	public Long countMessages(){
		return (long) this.listAll().size();
	}

	public List<Messages> findAllMessages(){
		return this.listAll();
	}

	public Messages findMessages(Long id){
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	public Long persist(Messages message){
		this.put(message);
		return message.getId();
	}

	public void remove(Messages message){
		this.delete(message);
	}
}
