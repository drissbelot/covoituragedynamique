/*
 * 
 */
package com.covoiturage.client;

import com.covoiturage.client.activity.HeaderActivity;
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
 * The Class HorizMasterAppActivityMapper.
 */
public class HorizMasterAppActivityMapper implements ActivityMapper {
	
	/** The client factory. */
	private final ClientFactory clientFactory;

	/**
	 * Instantiates a new horiz master app activity mapper.
	 *
	 * @param clientFactory the client factory
	 */
	public HorizMasterAppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.activity.shared.ActivityMapper#getActivity(com.google.gwt.place.shared.Place)
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MapPlace)
			return new HeaderActivity(clientFactory);
		else if (place instanceof ValidatePassengersPlace)
			return new HeaderActivity(clientFactory);
		else if (place instanceof SettingsPlace)
			return new HeaderActivity(clientFactory);
		else if (place instanceof HistoryPlace)
			return new HeaderActivity(clientFactory);
		else if (place instanceof MessagesListPlace)
			return new HeaderActivity(clientFactory);
		else if (place instanceof MessageDetailsPlace)
			return new HeaderActivity(clientFactory);
		else if (place instanceof ReplyMessagePlace)
			return new HeaderActivity(clientFactory);
		else if (place instanceof TravelDetailsPlace)
			return new HeaderActivity(clientFactory);
		return null;

	}

}
