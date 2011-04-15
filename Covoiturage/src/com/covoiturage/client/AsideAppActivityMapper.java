package com.covoiturage.client;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.covoiturage.client.place.ValidatePassengersPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AsideAppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;

	public AsideAppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof ValidatePassengersPlace)
			return new ValidatePassengersActivity(clientFactory);

		return null;
	}

}
