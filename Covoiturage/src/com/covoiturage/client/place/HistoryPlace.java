/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class HistoryPlace.
 */
public class HistoryPlace extends Place {
	
	/** The history name. */
	private String historyName;

	/**
	 * Instantiates a new history place.
	 *
	 * @param token the token
	 */
	public HistoryPlace(String token) {
		this.historyName = token;
	}

	/**
	 * Gets the history name.
	 *
	 * @return the history name
	 */
	public String getHistoryName() {
		return historyName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<HistoryPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(HistoryPlace place) {
			return place.getHistoryName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public HistoryPlace getPlace(String token) {
			return new HistoryPlace(token);
		}
	}

}
