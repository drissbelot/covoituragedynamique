/*
 * 
 */
package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.domain.Journey;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

// TODO: Auto-generated Javadoc
/**
 * The Interface JourneyProxy.
 */
@ProxyFor(value = Journey.class, locator = ObjectifyLocator.class)
public interface JourneyProxy extends EntityProxy {

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate();

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date);

	/**
	 * Gets the origin address.
	 *
	 * @return the origin address
	 */
	public String getOriginAddress();

	/**
	 * Gets the destination address.
	 *
	 * @return the destination address
	 */
	public String getDestinationAddress();

	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public Long getDriver();

	/**
	 * Sets the driver.
	 *
	 * @param driver the new driver
	 */
	public void setDriver(Long driver);

	/**
	 * Gets the passengers travels.
	 *
	 * @return the passengers travels
	 */
	public List<Long> getPassengersTravels();

	/**
	 * Sets the passengers travels.
	 *
	 * @param passengersTravels the new passengers travels
	 */
	public void setPassengersTravels(List<Long> passengersTravels);

	/**
	 * Gets the steps.
	 *
	 * @return the steps
	 */
	public List<String> getSteps();

	/**
	 * Sets the steps.
	 *
	 * @param steps the new steps
	 */
	public void setSteps(List<String> steps);

	/**
	 * Gets the waypoints.
	 *
	 * @return the waypoints
	 */
	public List<String> getWaypoints();

	/**
	 * Sets the waypoints.
	 *
	 * @param waypoints the new waypoints
	 */
	public void setWaypoints(List<String> waypoints);

	/**
	 * Gets the steps details.
	 *
	 * @return the steps details
	 */
	public List<String> getStepsDetails();

	/**
	 * Sets the steps details.
	 *
	 * @param stepsDetails the new steps details
	 */
	public void setStepsDetails(List<String> stepsDetails);

	/**
	 * Gets the departure start.
	 *
	 * @return the departure start
	 */
	public Date getDepartureStart();

	/**
	 * Sets the departure start.
	 *
	 * @param departureStart the new departure start
	 */
	public void setDepartureStart(Date departureStart);

	/**
	 * Gets the departure end.
	 *
	 * @return the departure end
	 */
	public Date getDepartureEnd();

	/**
	 * Sets the departure end.
	 *
	 * @param departureEnd the new departure end
	 */
	public void setDepartureEnd(Date departureEnd);

	/**
	 * Gets the arrival.
	 *
	 * @return the arrival
	 */
	public Date getArrival();

	/**
	 * Sets the arrival.
	 *
	 * @param arrival the new arrival
	 */
	public void setArrival(Date arrival);

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId();

	/**
	 * Sets the distance.
	 *
	 * @param distance the new distance
	 */
	public void setDistance(double distance);

	/**
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public double getDistance();

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(double duration);

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public double getDuration();

	/**
	 * Sets the origin address.
	 *
	 * @param originAddress the new origin address
	 */
	public void setOriginAddress(String originAddress);

	/**
	 * Sets the destination address.
	 *
	 * @param destinationAddress the new destination address
	 */
	public void setDestinationAddress(String destinationAddress);

	/**
	 * Sets the places.
	 *
	 * @param places the new places
	 */
	public void setPlaces(int places);

	/**
	 * Gets the places.
	 *
	 * @return the places
	 */
	public int getPlaces();

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment);

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment();

	/**
	 * Sets the map image.
	 *
	 * @param mapImage the new map image
	 */
	public void setMapImage(byte[] mapImage);

	/**
	 * Gets the map image.
	 *
	 * @return the map image
	 */
	public byte[] getMapImage();

	/**
	 * Gets the map image type.
	 *
	 * @return the map image type
	 */
	public String getMapImageType();

	/**
	 * Sets the map image type.
	 *
	 * @param mapImageType the new map image type
	 */
	public void setMapImageType(String mapImageType);

}
