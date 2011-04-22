package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ReplyMessagePlace extends Place {
	private final String replyMessagesName;

	public ReplyMessagePlace(String token) {
		this.replyMessagesName = token;
	}

	public String getReplyMessagesName() {
		return replyMessagesName;
	}

	public static class Tokenizer implements PlaceTokenizer<ReplyMessagePlace> {
		@Override
		public String getToken(ReplyMessagePlace place) {
			return place.getReplyMessagesName();
		}

		@Override
		public ReplyMessagePlace getPlace(String token) {
			return new ReplyMessagePlace(token);
		}
	}
}
