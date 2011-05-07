/*
 * 
 */
package com.covoiturage.client;

import com.covoiturage.client.activity.MenuActivity;
import com.covoiturage.client.place.HistoryPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.MessageDetailsPlace;
import com.covoiturage.client.place.MessagesListPlace;
import com.covoiturage.client.place.ReplyMessagePlace;
import com.covoiturage.client.place.SettingsPlace;
import com.covoiturage.client.place.TravelDetailsPlace;
import com.covoiturage.client.place.ValidatePassengersPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

// TODO: Auto-generated Javadoc
/**
 * The Class VertMasterAppActivityMapper.
 */
public class VertMasterAppActivityMapper implements ActivityMapper {
	
	/** The client factory. */
	private final ClientFactory clientFactory;

	/**
	 * Instantiates a new vert master app activity mapper.
	 *
	 * @param clientFactory the client factory
	 */
	public VertMasterAppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.activity.shared.ActivityMapper#getActivity(com.google.gwt.place.shared.Place)
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MapPlace)
			return new MenuActivity(clientFactory);
		else if (place instanceof ValidatePassengersPlace)
			return new MenuActivity(clientFactory);
		else if (place instanceof SettingsPlace)
			return new MenuActivity(clientFactory);
		else if (place instanceof HistoryPlace)
			return new MenuActivity(clientFactory);
		else if (place instanceof MessageDetailsPlace)
			return new MenuActivity(clientFactory);
		else if (place instanceof MessagesListPlace)
			return new MenuActivity(clientFactory);
		else if (place instanceof ReplyMessagePlace)
			return new MenuActivity(clientFactory);
		else if (place instanceof TravelDetailsPlace)
			return new MenuActivity(clientFactory);
		return null;

	}

}
