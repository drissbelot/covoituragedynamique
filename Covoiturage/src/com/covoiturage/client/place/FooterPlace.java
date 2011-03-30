package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class FooterPlace extends Place{

	private String FooterName;

    public FooterPlace(String token) {
        this.FooterName = token;
    }

    public String getFooterName() {
        return FooterName;
    }

    public static class Tokenizer implements PlaceTokenizer<FooterPlace> {
        
        public String getToken(FooterPlace place) {
            return place.getFooterName();
        }

       
        public FooterPlace getPlace(String token) {
            return new FooterPlace(token);
        }


    }

}
