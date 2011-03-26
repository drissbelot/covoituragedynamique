package com.covoiturage.client;

import com.covoiturage.client.activity.HeaderActivity;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.SettingsPlace;
import com.covoiturage.client.place.ValidatePassengersPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class HorizMasterAppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;
	public HorizMasterAppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory=clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if(place instanceof MapPlace)
			return new HeaderActivity(clientFactory);
		else if(place instanceof ValidatePassengersPlace)
			return new HeaderActivity(clientFactory);
		else if (place instanceof SettingsPlace)
			return new HeaderActivity(clientFactory);
		return null;

	}

}
