/*
 * 
 */
package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.SimpleTravelDao;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface SimpleTravelRequest.
 */
@Service(value = SimpleTravelDao.class, locator = DaoServiceLocator.class)
public interface SimpleTravelRequest extends RequestContext {

	/**
	 * Count simple travels.
	 *
	 * @return the request
	 */
	Request<Long> countSimpleTravels();

	/**
	 * Find all simple travels.
	 *
	 * @return the request
	 */
	Request<List<SimpleTravelProxy>> findAllSimpleTravels();

	/**
	 * Find simple travel.
	 *
	 * @param id the id
	 * @return the request
	 */
	Request<SimpleTravelProxy> findSimpleTravel(Long id);

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
	 * @param id the id
	 * @param comment the comment
	 * @param distance the distance
	 * @param duration the duration
	 * @param mapUrl the map url
	 * @return the request
	 */
	Request<SimpleTravelProxy> saveJourneyPassenger(List<String> steps,
			String originAddress, String destinationAddress, Date date,
			Date departureStart, Date departureEnd, Date arrival, Long id,
			String comment, double distance, double duration, String mapUrl);

	/**
	 * Persist.
	 *
	 * @param simpleTravel the simple travel
	 * @return the request
	 */
	Request<Long> persist(SimpleTravelProxy simpleTravel);

	/**
	 * Removes the.
	 *
	 * @param simpleTravel the simple travel
	 * @return the request
	 */
	Request<Void> remove(SimpleTravelProxy simpleTravel);

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
	Request<List<SimpleTravelProxy>> getSimpleTravels(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival,
			float distanceMax, double totalDistance);

	/**
	 * Gets the simple travels from user.
	 *
	 * @param userId the user id
	 * @return the simple travels from user
	 */
	Request<List<SimpleTravelProxy>> getSimpleTravelsFromUser(Long userId);

	/**
	 * Update simple travel.
	 *
	 * @param simpleTravel the simple travel
	 * @param statusDriver the status driver
	 * @param statusPassenger the status passenger
	 * @return the request
	 */
	Request<Void> updateSimpleTravel(Long simpleTravel, String statusDriver,
			String statusPassenger);

}
