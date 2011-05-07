/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class SettingsPlace.
 */
public class SettingsPlace extends Place {
	
	/** The settings name. */
	private String settingsName;

	/**
	 * Instantiates a new settings place.
	 *
	 * @param token the token
	 */
	public SettingsPlace(String token) {
		this.settingsName = token;
	}

	/**
	 * Gets the settings name.
	 *
	 * @return the settings name
	 */
	public String getSettingsName() {
		return settingsName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<SettingsPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(SettingsPlace place) {
			return place.getSettingsName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public SettingsPlace getPlace(String token) {
			return new SettingsPlace(token);
		}
	}

}
