package com.covoiturage.client;

import com.covoiturage.client.activity.AddUserActivity;
import com.covoiturage.client.activity.HistoryActivity;
import com.covoiturage.client.activity.LoginActivity;
import com.covoiturage.client.activity.MapActivity;
import com.covoiturage.client.activity.MessageDetailsActivity;
import com.covoiturage.client.activity.MessagesListActivity;
import com.covoiturage.client.activity.SettingsActivity;
import com.covoiturage.client.place.AddUserPlace;
import com.covoiturage.client.place.HistoryPlace;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.MessageDetailsPlace;
import com.covoiturage.client.place.MessagesListPlace;
import com.covoiturage.client.place.SettingsPlace;
import com.covoiturage.client.place.ValidatePassengersPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class MainAppActivityMapper implements ActivityMapper {
	private ClientFactory clientFactory;

	public MainAppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof LoginPlace)
			return new LoginActivity(clientFactory);
		else if (place instanceof AddUserPlace)
			return new AddUserActivity(clientFactory);
		else if (place instanceof MapPlace)
			return new MapActivity(clientFactory);
		else if (place instanceof ValidatePassengersPlace)
			return new MapActivity(clientFactory);
		else if (place instanceof SettingsPlace)
			return new SettingsActivity(clientFactory);
		else if (place instanceof HistoryPlace)
			return new HistoryActivity(clientFactory);
		else if (place instanceof MessagesListPlace)
			return new MessagesListActivity(clientFactory);
		else if (place instanceof MessageDetailsPlace)
			return new MessageDetailsActivity(clientFactory);
		return null;
	}

}
