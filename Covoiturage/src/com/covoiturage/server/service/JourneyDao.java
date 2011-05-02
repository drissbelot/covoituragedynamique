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

public class JourneyDao extends ObjectifyDao<Journey> {
	public static List<Journey> getJourneys(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival,
			float distanceMax) {

		return MapUtils.bufferRouteJourney(steps, distanceMax, departureStart,
				departureEnd, arrival);

	}

	public static List<Journey> getJourneysFromUser(Long id) {
		Objectify ofy = ObjectifyService.begin();

		List<Journey> list = ofy.query(Journey.class).filter("driver", id)
				.list();

		return list;
	}

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

	public Long countJourneys() {
		return (long) this.listAll().size();
	}

	public List<Journey> findAllJourneys() {
		return this.listAll();
	}

	public Journey findJourney(Long id) {
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	public Long persist(Journey journey) {
		this.put(journey);
		return journey.getId();
	}

	public void remove(Journey journey) {
		this.delete(journey);
	}
}
