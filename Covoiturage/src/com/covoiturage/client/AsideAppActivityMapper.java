/*
 * 
 */
package com.covoiturage.client;

import com.covoiturage.client.activity.ValidatePassengersActivity;
import com.covoiturage.client.place.ValidatePassengersPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

// TODO: Auto-generated Javadoc
/**
 * The Class AsideAppActivityMapper.
 */
public class AsideAppActivityMapper implements ActivityMapper {
	
	/** The client factory. */
	private ClientFactory clientFactory;

	/**
	 * Instantiates a new aside app activity mapper.
	 *
	 * @param clientFactory the client factory
	 */
	public AsideAppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.activity.shared.ActivityMapper#getActivity(com.google.gwt.place.shared.Place)
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof ValidatePassengersPlace)
			return new ValidatePassengersActivity(clientFactory);

		return null;
	}

}
