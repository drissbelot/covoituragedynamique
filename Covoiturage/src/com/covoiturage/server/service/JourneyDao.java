/*
 * 
 */
package com.covoiturage.server.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.covoiturage.server.MapUtils;
import com.covoiturage.server.domain.Journey;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

// TODO: Auto-generated Javadoc
/**
 * The Class JourneyDao.
 */
public class JourneyDao extends ObjectifyDao<Journey> {
	
	/**
	 * Gets the journeys.
	 *
	 * @param steps the steps
	 * @param departureStart the departure start
	 * @param departureEnd the departure end
	 * @param arrival the arrival
	 * @param distanceMax the distance max
	 * @return the journeys
	 */
	public static List<Journey> getJourneys(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival,
			float distanceMax) {

		return MapUtils.bufferRouteJourney(steps, distanceMax, departureStart,
				departureEnd, arrival);

	}

	/**
	 * Gets the journeys from user.
	 *
	 * @param id the id
	 * @return the journeys from user
	 */
	public static List<Journey> getJourneysFromUser(Long id) {
		Objectify ofy = ObjectifyService.begin();

		List<Journey> list = ofy.query(Journey.class).filter("driver", id)
				.list();

		return list;
	}

	/**
	 * Save journey driver.
	 *
	 * @param steps the steps
	 * @param date the date
	 * @param departureStart the departure start
	 * @param departureEnd the departure end
	 * @param arrival the arrival
	 * @param driver the driver
	 * @param originAddress the origin address
	 * @param destinationAddress the destination address
	 * @param waypoints the waypoints
	 * @param stepsDetails the steps details
	 * @param passengersTravels the passengers travels
	 * @param comment the comment
	 * @param duration the duration
	 * @param distance the distance
	 * @param places the places
	 * @param mapImage the map image
	 * @return the journey
	 */
	public static Journey saveJourneyDriver(List<String> steps, Date date,
			Date departureStart, Date departureEnd, Date arrival, Long driver,
			String originAddress, String destinationAddress,
			List<String> waypoints, List<String> stepsDetails,
			List<Long> passengersTravels, String comment, double duration,
			double distance, int places, String mapImage) {
		Journey journey = new Journey();
		Objectify ofy = ObjectifyService.begin();
		journey.setSteps(steps);
		journey.setDate(date);
		journey.setDriver(driver);
		journey.setOriginAddress(originAddress);
		journey.setDestinationAddress(destinationAddress);
		journey.setWaypoints(waypoints);
		journey.setStepsDetails(stepsDetails);
		journey.setDepartureStart(departureStart);
		journey.setDepartureEnd(departureEnd);
		journey.setArrival(arrival);
		journey.setPassengersTravels(passengersTravels);
		journey.setComment(comment);
		journey.setDuration(duration);
		journey.setDistance(distance);
		journey.setVersion(places);
		URLFetchService fetchService = URLFetchServiceFactory
				.getURLFetchService();

		try {

			HTTPResponse fetchResponse = fetchService.fetch(new URL(mapImage));

			String fetchResponseContentType = null;
			for (HTTPHeader header : fetchResponse.getHeaders()) {

				if (header.getName().equalsIgnoreCase("content-type")) {
					fetchResponseContentType = header.getValue();
					break;
				}
			}

			if (fetchResponseContentType != null) {

				journey.setMapImageType(fetchResponseContentType);

				journey.setMapImage(fetchResponse.getContent());

			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		ofy.put(journey);

		return journey;
	}

	/**
	 * Update journey.
	 *
	 * @param journeyId the journey id
	 * @param simpleTravelId the simple travel id
	 * @param steps the steps
	 * @return the journey
	 */
	public static Journey updateJourney(Long journeyId, Long simpleTravelId,
			List<String> steps) {
		Journey journey = new Journey();
		Objectify ofy = ObjectifyService.begin();

		Query<Journey> query = ofy.query(Journey.class).filter("id", journeyId);
		List<Journey> results = query.list();

		if (results.size() != 0) {

			journey = results.get(0);

			journey.getPassengersTravels().add(simpleTravelId);
			journey.getWaypoints().addAll(steps);
			ofy.put(journey);
		}

		return journey;

	}

	/**
	 * Count journeys.
	 *
	 * @return the long
	 */
	public Long countJourneys() {
		return (long) this.listAll().size();
	}

	/**
	 * Find all journeys.
	 *
	 * @return the list
	 */
	public List<Journey> findAllJourneys() {
		return this.listAll();
	}

	/**
	 * Find journey.
	 *
	 * @param id the id
	 * @return the journey
	 */
	public Journey findJourney(Long id) {
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	/**
	 * Persist.
	 *
	 * @param journey the journey
	 * @return the long
	 */
	public Long persist(Journey journey) {
		this.put(journey);
		return journey.getId();
	}

	/**
	 * Removes the.
	 *
	 * @param journey the journey
	 */
	public void remove(Journey journey) {
		this.delete(journey);
	}
}
