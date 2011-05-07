/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageDetailsPlace.
 */
public class MessageDetailsPlace extends Place {
	
	/** The message details name. */
	private String messageDetailsName;

	/**
	 * Instantiates a new message details place.
	 *
	 * @param token the token
	 */
	public MessageDetailsPlace(String token) {
		this.messageDetailsName = token;
	}

	/**
	 * Gets the message details name.
	 *
	 * @return the message details name
	 */
	public String getMessageDetailsName() {
		return messageDetailsName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements
			PlaceTokenizer<MessageDetailsPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(MessageDetailsPlace place) {
			return place.getMessageDetailsName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public MessageDetailsPlace getPlace(String token) {
			return new MessageDetailsPlace(token);
		}
	}

}
