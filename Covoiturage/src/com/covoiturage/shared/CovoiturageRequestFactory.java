/*
 * 
 */
package com.covoiturage.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating CovoiturageRequest objects.
 */
public interface CovoiturageRequestFactory extends RequestFactory {
	
	/**
	 * User info request.
	 *
	 * @return the user info request
	 */
	UserInfoRequest userInfoRequest();

	/**
	 * Journey request.
	 *
	 * @return the journey request
	 */
	JourneyRequest journeyRequest();

	/**
	 * Simple travel request.
	 *
	 * @return the simple travel request
	 */
	SimpleTravelRequest simpleTravelRequest();

	/**
	 * User info details request.
	 *
	 * @return the user info details request
	 */
	UserInfoDetailsRequest userInfoDetailsRequest();

	/**
	 * Messages request.
	 *
	 * @return the messages request
	 */
	MessagesRequest messagesRequest();

	/**
	 * Vehicles request.
	 *
	 * @return the vehicles request
	 */
	VehiclesRequest vehiclesRequest();
}
