package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MapPlace extends Place{
	private String mapName;

    public MapPlace(String token) {
        this.mapName = token;
    }

    public String getMapName() {
        return mapName;
    }

    public static class Tokenizer implements PlaceTokenizer<MapPlace> {
        @Override
        public String getToken(MapPlace place) {
            return place.getMapName();
        }

        @Override
        public MapPlace getPlace(String token) {
            return new MapPlace(token);
        }
    }

}
