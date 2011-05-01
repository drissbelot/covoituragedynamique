package com.covoiturage.server.service;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.MapUtils;
import com.covoiturage.server.domain.Journey;
import com.google.appengine.api.datastore.EntityNotFoundException;
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
