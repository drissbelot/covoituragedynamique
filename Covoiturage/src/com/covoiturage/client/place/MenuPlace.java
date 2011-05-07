/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuPlace.
 */
public class MenuPlace extends Place {
	
	/** The menu name. */
	private String menuName;

	/**
	 * Instantiates a new menu place.
	 *
	 * @param token the token
	 */
	public MenuPlace(String token) {
		this.menuName = token;
	}

	/**
	 * Gets the menu name.
	 *
	 * @return the menu name
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<MenuPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(MenuPlace place) {
			return place.getMenuName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public MenuPlace getPlace(String token) {
			return new MenuPlace(token);
		}
	}

}
