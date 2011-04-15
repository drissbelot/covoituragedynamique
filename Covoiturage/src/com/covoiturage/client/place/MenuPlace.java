package com.covoiturage.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MenuPlace extends Place {
	private String menuName;

	public MenuPlace(String token) {
		this.menuName = token;
	}

	public String getMenuName() {
		return menuName;
	}

	public static class Tokenizer implements PlaceTokenizer<MenuPlace> {
		@Override
		public String getToken(MenuPlace place) {
			return place.getMenuName();
		}

		@Override
		public MenuPlace getPlace(String token) {
			return new MenuPlace(token);
		}
	}

}
