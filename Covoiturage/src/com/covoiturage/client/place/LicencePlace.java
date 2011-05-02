package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LicencePlace extends Place {
	private String licenceName;

	public LicencePlace(String token) {
		this.licenceName = token;
	}

	public String getLicenceName() {
		return licenceName;
	}

	public static class Tokenizer implements PlaceTokenizer<LicencePlace> {
		@Override
		public String getToken(LicencePlace place) {
			return place.getLicenceName();
		}

		@Override
		public LicencePlace getPlace(String token) {
			return new LicencePlace(token);
		}
	}

}
