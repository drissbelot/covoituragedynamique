/*
 * 
 */
package com.covoiturage.client;

import com.covoiturage.client.activity.FooterActivity;
import com.covoiturage.client.place.AddUserPlace;
import com.covoiturage.client.place.HistoryPlace;
import com.covoiturage.client.place.LoginPlace;
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
 * The Class FooterAppActivityMapper.
 */
public class FooterAppActivityMapper implements ActivityMapper {

	/** The client factory. */
	private final ClientFactory clientFactory;

	/**
	 * Instantiates a new footer app activity mapper.
	 * 
	 * @param clientFactory
	 *            the client factory
	 */
	public FooterAppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.activity.shared.ActivityMapper#getActivity(com.google.
	 * gwt.place.shared.Place)
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MapPlace)
			return new FooterActivity(clientFactory);
		else if (place instanceof ValidatePassengersPlace)
			return new FooterActivity(clientFactory);
		else if (place instanceof SettingsPlace)
			return new FooterActivity(clientFactory);
		else if (place instanceof LoginPlace)
			return new FooterActivity(clientFactory);
		else if (place instanceof HistoryPlace)
			return new FooterActivity(clientFactory);
		else if (place instanceof MessagesListPlace)
			return new FooterActivity(clientFactory);
		else if (place instanceof MessageDetailsPlace)
			return new FooterActivity(clientFactory);

		else if (place instanceof AddUserPlace)
			return new FooterActivity(clientFactory);
		else if (place instanceof ReplyMessagePlace)
			return new FooterActivity(clientFactory);
		else if (place instanceof TravelDetailsPlace)
			return new FooterActivity(clientFactory);
		return null;
	}

}
