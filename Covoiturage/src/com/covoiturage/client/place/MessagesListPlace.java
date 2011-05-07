/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class MessagesListPlace.
 */
public class MessagesListPlace extends Place {
	
	/** The messages name. */
	private String messagesName;

	/**
	 * Instantiates a new messages list place.
	 *
	 * @param token the token
	 */
	public MessagesListPlace(String token) {
		this.messagesName = token;
	}

	/**
	 * Gets the messages name.
	 *
	 * @return the messages name
	 */
	public String getMessagesName() {
		return messagesName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<MessagesListPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(MessagesListPlace place) {
			return place.getMessagesName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public MessagesListPlace getPlace(String token) {
			return new MessagesListPlace(token);
		}
	}

}
