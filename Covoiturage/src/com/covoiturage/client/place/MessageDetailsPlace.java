package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MessageDetailsPlace extends Place {
	private String messageDetailsName;

    public MessageDetailsPlace(String token) {
        this.messageDetailsName = token;
    }

    public String getMessageDetailsName() {
        return messageDetailsName;
    }

    public static class Tokenizer implements PlaceTokenizer<MessageDetailsPlace> {
        @Override
        public String getToken(MessageDetailsPlace place) {
            return place.getMessageDetailsName();
        }

        @Override
        public MessageDetailsPlace getPlace(String token) {
            return new MessageDetailsPlace(token);
        }
    }

}
