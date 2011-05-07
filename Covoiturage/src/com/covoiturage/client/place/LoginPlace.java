/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginPlace.
 */
public class LoginPlace extends Place {
	
	/** The login name. */
	private String loginName;

	/**
	 * Instantiates a new login place.
	 *
	 * @param token the token
	 */
	public LoginPlace(String token) {
		this.loginName = token;
	}

	/**
	 * Gets the login name.
	 *
	 * @return the login name
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(LoginPlace place) {
			return place.getLoginName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public LoginPlace getPlace(String token) {
			return new LoginPlace(token);
		}
	}

}
