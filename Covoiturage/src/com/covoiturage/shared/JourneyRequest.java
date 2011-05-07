/*
 * 
 */
package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.JourneyDao;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface JourneyRequest.
 */
@Service(value = JourneyDao.class, locator = DaoServiceLocator.class)
public interface JourneyRequest extends RequestContext {

	/**
	 * Count journeys.
	 *
	 * @return the request
	 */
	Request<Long> countJourneys();

	/**
	 * Find all journeys.
	 *
	 * @return the request
	 */
	Request<List<JourneyProxy>> findAllJourneys();

	/**
	 * Find journey.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<JourneyProxy> findJourney(Long id);

	/**
	 * Save journey driver.
	 *
	 * @param steps the steps
	 * @param date the date
	 * @param departureStart the departure start
	 * @param departureEnd the departure end
	 * @param arrival the arrival
	 * @param id the id
	 * @param originAddress the origin address
	 * @param destinationAddress the destination address
	 * @param waypoints the waypoints
	 * @param stepsDetails the steps details
	 * @param passengers the passengers
	 * @param comment the comment
	 * @param duration the duration
	 * @param distance the distance
	 * @param places the places
	 * @param mapImage the map image
	 * @return the request
	 */
	Request<JourneyProxy> saveJourneyDriver(List<String> steps, Date date,
			Date departureStart, Date departureEnd, Date arrival, Long id,
			String originAddress, String destinationAddress,
			List<String> waypoints, List<String> stepsDetails,
			List<Long> passengers, String comment, double duration,
			double distance, int places, String mapImage);

	/**
	 * Persist.
	 *
	 * @param journey the journey
	 * @return the request
	 */
	Request<Long> persist(JourneyProxy journey);

	/**
	 * Removes the.
	 *
	 * @param journey the journey
	 * @return the request
	 */
	Request<Void> remove(JourneyProxy journey);

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
	Request<List<JourneyProxy>> getJourneys(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival,
			float distanceMax);

	/**
	 * Gets the journeys from user.
	 *
	 * @param id the id
	 * @return the journeys from user
	 */
	Request<List<JourneyProxy>> getJourneysFromUser(Long id);

	/**
	 * Update journey.
	 *
	 * @param journeyId the journey id
	 * @param simpleTravelId the simple travel id
	 * @param steps the steps
	 * @return the request
	 */
	Request<JourneyProxy> updateJourney(Long journeyId, Long simpleTravelId,
			List<String> steps);

}
