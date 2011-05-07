/*
 * 
 */
package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class MapPlace.
 */
public class MapPlace extends Place {
	
	/** The map name. */
	private String mapName;

	/**
	 * Instantiates a new map place.
	 *
	 * @param token the token
	 */
	public MapPlace(String token) {
		this.mapName = token;
	}

	/**
	 * Gets the map name.
	 *
	 * @return the map name
	 */
	public String getMapName() {
		return mapName;
	}

	/**
	 * The Class Tokenizer.
	 */
	public static class Tokenizer implements PlaceTokenizer<MapPlace> {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getToken(com.google.gwt.place.shared.Place)
		 */
		@Override
		public String getToken(MapPlace place) {
			return place.getMapName();
		}

		/* (non-Javadoc)
		 * @see com.google.gwt.place.shared.PlaceTokenizer#getPlace(java.lang.String)
		 */
		@Override
		public MapPlace getPlace(String token) {
			return new MapPlace(token);
		}
	}

}
