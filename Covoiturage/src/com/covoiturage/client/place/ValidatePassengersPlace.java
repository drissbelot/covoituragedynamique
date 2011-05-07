/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidatePassengersPlace.
 */
public class ValidatePassengersPlace extends Place {
	
	/** The validate passengers name. */
	private String validatePassengersName;

	/**
	 * Instantiates a new validate passengers place.
	 *
	 * @param token the token
	 */
	public ValidatePassengersPlace(String token) {
		this.validatePassengersName = token;
	}

	/**
	 * Gets the validate passengers name.
	 *
	 * @return the validate passengers name
	 */
	public String getValidatePassengersName() {
		return validatePassengersName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements
			PlaceTokenizer<ValidatePassengersPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(ValidatePassengersPlace place) {
			return place.getValidatePassengersName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public ValidatePassengersPlace getPlace(String token) {
			return new ValidatePassengersPlace(token);
		}
	}

}
