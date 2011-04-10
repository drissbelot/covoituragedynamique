package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MessagesPlace extends Place{
	private String messagesName;

    public MessagesPlace(String token) {
        this.messagesName = token;
    }

    public String getMessagesName() {
        return messagesName;
    }

    public static class Tokenizer implements PlaceTokenizer<MessagesPlace> {
        @Override
        public String getToken(MessagesPlace place) {
            return place.getMessagesName();
        }

        @Override
        public MessagesPlace getPlace(String token) {
            return new MessagesPlace(token);
        }
    }

}
