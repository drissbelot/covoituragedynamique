package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TravelDetailsPlace extends Place {
	private final String travelDetailsName;

	public TravelDetailsPlace(String token) {
		this.travelDetailsName = token;
	}

	public String getTravelDetailsName() {
		return travelDetailsName;
	}

	public static class Tokenizer implements PlaceTokenizer<TravelDetailsPlace> {
		@Override
		public String getToken(TravelDetailsPlace place) {
			return place.getTravelDetailsName();
		}

		@Override
		public TravelDetailsPlace getPlace(String token) {
			return new TravelDetailsPlace(token);
		}
	}

}
