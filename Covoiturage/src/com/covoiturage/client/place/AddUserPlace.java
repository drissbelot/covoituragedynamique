/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class AddUserPlace.
 */
public class AddUserPlace extends Place {
	
	/** The add user name. */
	private String addUserName;

	/**
	 * Instantiates a new adds the user place.
	 *
	 * @param token the token
	 */
	public AddUserPlace(String token) {
		this.addUserName = token;
	}

	/**
	 * Gets the adds the user name.
	 *
	 * @return the adds the user name
	 */
	public String getAddUserName() {
		return addUserName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<AddUserPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(AddUserPlace place) {
			return place.getAddUserName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public AddUserPlace getPlace(String token) {
			return new AddUserPlace(token);
		}
	}

}
