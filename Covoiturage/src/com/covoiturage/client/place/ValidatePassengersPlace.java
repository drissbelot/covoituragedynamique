package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ValidatePassengersPlace extends Place{
	private String validatePassengersName;

    public ValidatePassengersPlace(String token) {
        this.validatePassengersName = token;
    }

    public String getValidatePassengersName() {
        return validatePassengersName;
    }

    public static class Tokenizer implements PlaceTokenizer<ValidatePassengersPlace> {
        @Override
        public String getToken(ValidatePassengersPlace place) {
            return place.getValidatePassengersName();
        }

        @Override
        public ValidatePassengersPlace getPlace(String token) {
            return new ValidatePassengersPlace(token);
        }
    }

}
