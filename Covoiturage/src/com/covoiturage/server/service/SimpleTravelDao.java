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

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleTravelDao.
 */
public class SimpleTravelDao extends ObjectifyDao<SimpleTravel> {

	/**
	 * Gets the simple travels.
	 *
	 * @param steps the steps
	 * @param departureStart the departure start
	 * @param departureEnd the departure end
	 * @param arrival the arrival
	 * @param distanceMax the distance max
	 * @param totalDistance the total distance
	 * @return the simple travels
	 */
	public static List<SimpleTravel> getSimpleTravels(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival,
			float distanceMax, double totalDistance) {
		return MapUtils.bufferRoute(steps, departureStart, departureEnd,
				arrival, distanceMax, totalDistance);

	}

	/**
	 * Gets the simple travels from user.
	 *
	 * @param userId the user id
	 * @return the simple travels from user
	 */
	public static List<SimpleTravel> getSimpleTravelsFromUser(Long userId) {
		Objectify ofy = ObjectifyService.begin();

		List<SimpleTravel> list = ofy.query(SimpleTravel.class)
				.filter("passenger", userId).list();
		list.size();
		return list;

	}

	/**
	 * Save journey passenger.
	 *
	 * @param steps the steps
	 * @param originAddress the origin address
	 * @param destinationAddress the destination address
	 * @param date the date
	 * @param departureStart the departure start
	 * @param departureEnd the departure end
	 * @param arrival the arrival
	 * @param passenger the passenger
	 * @param comment the comment
	 * @param distance the distance
	 * @param duration the duration
	 * @param mapImage the map image
	 * @return the simple travel
	 */
	public SimpleTravel saveJourneyPassenger(List<String> steps,
			String originAddress, String destinationAddress, Date date,
			Date departureStart, Date departureEnd, Date arrival,
			Long passenger, String comment, double distance, double duration,
			String mapImage) {
		SimpleTravel simpleTravel = new SimpleTravel();
		Objectify ofy = ObjectifyService.begin();

		simpleTravel.setSteps(steps);
		simpleTravel.setDate(date);
		simpleTravel.setPassenger(passenger);
		simpleTravel.setOriginAddress(originAddress);
		simpleTravel.setDestinationAddress(destinationAddress);
		simpleTravel.setDepartureStart(departureStart);
		simpleTravel.setDepartureEnd(departureEnd);
		simpleTravel.setArrival(arrival);
		simpleTravel.setComment(comment);
		simpleTravel.setDistance(distance);
		simpleTravel.setDuration(duration);

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

			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		ofy.put(simpleTravel);

		return simpleTravel;
	}

	/**
	 * Update simple travel.
	 *
	 * @param id the id
	 * @param statusDriver the status driver
	 * @param statusPassenger the status passenger
	 */
	public static void updateSimpleTravel(Long id, String statusDriver,
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

	/**
	 * Count simple travels.
	 *
	 * @return the long
	 */
	public Long countSimpleTravels() {
		return (long) this.listAll().size();
	}

	/**
	 * Find all simple travels.
	 *
	 * @return the list
	 */
	public List<SimpleTravel> findAllSimpleTravels() {
		return this.listAll();
	}

	/**
	 * Find simple travel.
	 *
	 * @param id the id
	 * @return the simple travel
	 */
	public SimpleTravel findSimpleTravel(Long id) {
		try {
			return this.get(id);
		} catch (EntityNotFoundException e) {

		}
		return null;
	}

	/**
	 * Persist.
	 *
	 * @param simpleTravel the simple travel
	 * @return the long
	 */
	public Long persist(SimpleTravel simpleTravel) {
		this.put(simpleTravel);
		return simpleTravel.getId();
	}

	/**
	 * Removes the.
	 *
	 * @param simpleTravel the simple travel
	 */
	public void remove(SimpleTravel simpleTravel) {
		this.delete(simpleTravel);
	}
}
