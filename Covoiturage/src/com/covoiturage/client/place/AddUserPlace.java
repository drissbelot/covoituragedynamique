package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AddUserPlace extends Place{
	private String addUserName;

    public AddUserPlace(String token) {
        this.addUserName = token;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public static class Tokenizer implements PlaceTokenizer<AddUserPlace> {
        @Override
        public String getToken(AddUserPlace place) {
            return place.getAddUserName();
        }

        @Override
        public AddUserPlace getPlace(String token) {
            return new AddUserPlace(token);
        }
    }

}
