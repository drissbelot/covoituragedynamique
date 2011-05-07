/*
 * 
 */
package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.domain.SimpleTravel;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

// TODO: Auto-generated Javadoc
/**
 * The Interface SimpleTravelProxy.
 */
@ProxyFor(value = SimpleTravel.class, locator = ObjectifyLocator.class)
public interface SimpleTravelProxy extends EntityProxy {

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
	 * Gets the steps.
	 *
	 * @return the steps
	 */
	public List<String> getSteps();

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
	 * Gets the passenger.
	 *
	 * @return the passenger
	 */
	public Long getPassenger();

	/**
	 * Sets the passenger.
	 *
	 * @param passenger the new passenger
	 */
	public void setPassenger(Long passenger);

	/**
	 * Sets the steps.
	 *
	 * @param steps the new steps
	 */
	public void setSteps(List<String> steps);

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
	 * Gets the status passenger.
	 *
	 * @return the status passenger
	 */
	public String getStatusPassenger();

	/**
	 * Sets the status passenger.
	 *
	 * @param statusPassenger the new status passenger
	 */
	public void setStatusPassenger(String statusPassenger);

	/**
	 * Gets the status driver.
	 *
	 * @return the status driver
	 */
	public String getStatusDriver();

	/**
	 * Sets the status driver.
	 *
	 * @param statusDriver the new status driver
	 */
	public void setStatusDriver(String statusDriver);

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
}
