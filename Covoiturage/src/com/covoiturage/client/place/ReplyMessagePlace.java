/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class ReplyMessagePlace.
 */
public class ReplyMessagePlace extends Place {
	
	/** The reply messages name. */
	private final String replyMessagesName;

	/**
	 * Instantiates a new reply message place.
	 *
	 * @param token the token
	 */
	public ReplyMessagePlace(String token) {
		this.replyMessagesName = token;
	}

	/**
	 * Gets the reply messages name.
	 *
	 * @return the reply messages name
	 */
	public String getReplyMessagesName() {
		return replyMessagesName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<ReplyMessagePlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(ReplyMessagePlace place) {
			return place.getReplyMessagesName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public ReplyMessagePlace getPlace(String token) {
			return new ReplyMessagePlace(token);
		}
	}
}
