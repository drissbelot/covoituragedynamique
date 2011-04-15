package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HistoryPlace extends Place {
	private String historyName;

	public HistoryPlace(String token) {
		this.historyName = token;
	}

	public String getHistoryName() {
		return historyName;
	}

	public static class Tokenizer implements PlaceTokenizer<HistoryPlace> {
		@Override
		public String getToken(HistoryPlace place) {
			return place.getHistoryName();
		}

		@Override
		public HistoryPlace getPlace(String token) {
			return new HistoryPlace(token);
		}
	}

}
