/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class TravelDetailsPlace.
 */
public class TravelDetailsPlace extends Place {
	
	/** The travel details name. */
	private final String travelDetailsName;

	/**
	 * Instantiates a new travel details place.
	 *
	 * @param token the token
	 */
	public TravelDetailsPlace(String token) {
		this.travelDetailsName = token;
	}

	/**
	 * Gets the travel details name.
	 *
	 * @return the travel details name
	 */
	public String getTravelDetailsName() {
		return travelDetailsName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<TravelDetailsPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(TravelDetailsPlace place) {
			return place.getTravelDetailsName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public TravelDetailsPlace getPlace(String token) {
			return new TravelDetailsPlace(token);
		}
	}

}
