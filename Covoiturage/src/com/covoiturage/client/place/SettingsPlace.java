package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SettingsPlace extends Place {
	private String settingsName;

	public SettingsPlace(String token) {
		this.settingsName = token;
	}

	public String getSettingsName() {
		return settingsName;
	}

	public static class Tokenizer implements PlaceTokenizer<SettingsPlace> {
		@Override
		public String getToken(SettingsPlace place) {
			return place.getSettingsName();
		}

		@Override
		public SettingsPlace getPlace(String token) {
			return new SettingsPlace(token);
		}
	}

}
