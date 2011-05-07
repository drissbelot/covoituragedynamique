/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class LicencePlace.
 */
public class LicencePlace extends Place {
	
	/** The licence name. */
	private String licenceName;

	/**
	 * Instantiates a new licence place.
	 *
	 * @param token the token
	 */
	public LicencePlace(String token) {
		this.licenceName = token;
	}

	/**
	 * Gets the licence name.
	 *
	 * @return the licence name
	 */
	public String getLicenceName() {
		return licenceName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<LicencePlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(LicencePlace place) {
			return place.getLicenceName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public LicencePlace getPlace(String token) {
			return new LicencePlace(token);
		}
	}

}
