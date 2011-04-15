package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MessagesListPlace extends Place {
	private String messagesName;

	public MessagesListPlace(String token) {
		this.messagesName = token;
	}

	public String getMessagesName() {
		return messagesName;
	}

	public static class Tokenizer implements PlaceTokenizer<MessagesListPlace> {
		@Override
		public String getToken(MessagesListPlace place) {
			return place.getMessagesName();
		}

		@Override
		public MessagesListPlace getPlace(String token) {
			return new MessagesListPlace(token);
		}
	}

}
