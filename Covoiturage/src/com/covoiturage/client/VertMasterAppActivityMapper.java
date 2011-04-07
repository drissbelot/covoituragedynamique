package com.covoiturage.client;

import com.covoiturage.client.activity.HistoryActivity;
import com.covoiturage.client.activity.MenuActivity;
import com.covoiturage.client.place.HistoryPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.SettingsPlace;
import com.covoiturage.client.place.ValidatePassengersPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class VertMasterAppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;
	public VertMasterAppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if(place instanceof MapPlace)
			return new MenuActivity(clientFactory);
			else if(place instanceof ValidatePassengersPlace)
				return new MenuActivity(clientFactory);	
			else if(place instanceof SettingsPlace)
				return new MenuActivity(clientFactory);
			else if(place instanceof HistoryPlace)
				return new HistoryActivity(clientFactory);
			return null;

	}

}
