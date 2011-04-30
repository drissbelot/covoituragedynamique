package com.covoiturage.server.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.covoiturage.server.MapUtils;
import com.covoiturage.server.domain.SimpleTravel;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class SimpleTravelDao extends ObjectifyDao<SimpleTravel> {

	public static List<SimpleTravel> getSimpleTravels(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival,
			float distanceMax) {
		return MapUtils.bufferRoute(steps, departureStart, departureEnd,
				arrival, distanceMax);

	}

	public static List<SimpleTravel> getSimpleTravelsFromUser(String userId) {
		Objectify ofy = ObjectifyService.begin();

		List<SimpleTravel> list = ofy.query(SimpleTravel.class)
				.filter("passenger", userId).list();
		list.size();
		return list;

	}

	public static SimpleTravel saveJourneyPassenger(List<String> steps,
			String originAddress, String destinationAddress, Date date,
			Date departureStart, Date departureEnd, Date arrival,
			Long passenger, String mapImage) {
		SimpleTravel simpleTravel = new SimpleTravel();
		Objectify ofy = ObjectifyService.begin();
		java.util.logging.Logger.getLogger("").warning("blabla");
		simpleTravel.setSteps(steps);
		simpleTravel.setDate(date);
		simpleTravel.setPassenger(passenger);
		simpleTravel.setOriginAddress(originAddress);
		simpleTravel.setDestinationAddress(destinationAddress);
		simpleTravel.setDepartureStart(departureStart);
		simpleTravel.setDepartureEnd(departureEnd);
		simpleTravel.setArrival(arrival);
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

				simpleTravel.setMapImageType(fetchResponseContentType);

				simpleTravel.setMapImage(fetchResponse.getContent());
				;

			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		ofy.put(simpleTravel);

		return simpleTravel;
	}

	public static void updateSimpleTravel(String id, String statusDriver,
			String statusPassenger) {

		SimpleTravel travel = new SimpleTravel();
		Objectify ofy = ObjectifyService.begin();

		travel = ofy.find(SimpleTravel.class, id);

		travel.setStatusDriver(statusDriver);
		travel.setStatusPassenger(statusPassenger);

		ofy.put(travel);

		if (statusDriver == "pending" || statusPassenger == "pending") {
			Queue reminderQueue = QueueFactory.getDefaultQueue();
			TaskOptions taskOptions = TaskOptions.Builder
					.withUrl("/reminderService");
			taskOptions.param("passenger", travel.getPassenger().toString());
			taskOptions.countdownMillis(travel.getDepartureStart().getTime()
					- System.currentTimeMillis() - 60 * 60 * 1000);
			reminderQueue.add(taskOptions);
		}

	}

	public Long countSimpleTravels() {
		return (long) this.listAll().size();
	}

	public List<SimpleTravel> findAllSimpleTravels() {
		return this.listAll();
	}

	public SimpleTravel findSimpleTravel(Long id) {
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	public String persist(SimpleTravel simpleTravel) {
		this.put(simpleTravel);
		return simpleTravel.getId().toString();
	}

	public void remove(SimpleTravel simpleTravel) {
		this.delete(simpleTravel);
	}
}
