package com.covoiturage.client;

import com.covoiturage.client.activity.FooterActivity;
import com.covoiturage.client.place.FooterPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class FooterAppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;
	public FooterAppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory=clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if(place instanceof FooterPlace)
			return new FooterActivity(clientFactory);
		return null;

	}

}
