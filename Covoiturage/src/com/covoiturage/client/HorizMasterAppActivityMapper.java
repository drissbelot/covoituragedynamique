package com.covoiturage.client;

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
		// TODO Auto-generated method stub
		return null;
	}

}
