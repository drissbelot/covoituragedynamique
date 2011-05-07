/*
 * 
 */
package com.covoiturage.server.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.google.appengine.api.datastore.Blob;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleTravel.
 */
@Entity
public class SimpleTravel extends DatastoreObject {

	/** The date. */
	private Date date;
	
	/** The passenger. */
	public Long passenger;
	
	/** The origin address. */
	private String originAddress;
	
	/** The destination address. */
	private String destinationAddress;
	
	/** The map image. */
	private Blob mapImage;
	
	/** The map image type. */
	private String mapImageType;
	
	/** The duration. */
	private double duration;
	
	/** The distance. */
	private double distance;
	
	/** The comment. */
	private String comment;

	/**
	 * Gets the map image type.
	 *
	 * @return the map image type
	 */
	public String getMapImageType() {
		return mapImageType;
	}

	/**
	 * Sets the map image type.
	 *
	 * @param mapImageType the new map image type
	 */
	public void setMapImageType(String mapImageType) {
		this.mapImageType = mapImageType;
	}

	/**
	 * Gets the status passenger.
	 *
	 * @return the status passenger
	 */
	public String getStatusPassenger() {
		return statusPassenger;
	}

	/**
	 * Sets the status passenger.
	 *
	 * @param statusPassenger the new status passenger
	 */
	public void setStatusPassenger(String statusPassenger) {
		this.statusPassenger = statusPassenger;
	}

	/**
	 * Gets the status driver.
	 *
	 * @return the status driver
	 */
	public String getStatusDriver() {
		return statusDriver;
	}

	/**
	 * Sets the status driver.
	 *
	 * @param statusDriver the new status driver
	 */
	public void setStatusDriver(String statusDriver) {
		this.statusDriver = statusDriver;
	}

	/** The status passenger. */
	private String statusPassenger;
	
	/** The status driver. */
	private String statusDriver;

	/** The steps. */
	private List<String> steps;

	/**
	 * Gets the departure start.
	 *
	 * @return the departure start
	 */
	public Date getDepartureStart() {
		return departureStart;
	}

	/**
	 * Sets the departure start.
	 *
	 * @param departureStart the new departure start
	 */
	public void setDepartureStart(Date departureStart) {
		this.departureStart = departureStart;
	}

	/**
	 * Gets the departure end.
	 *
	 * @return the departure end
	 */
	public Date getDepartureEnd() {
		return departureEnd;
	}

	/**
	 * Sets the departure end.
	 *
	 * @param departureEnd the new departure end
	 */
	public void setDepartureEnd(Date departureEnd) {
		this.departureEnd = departureEnd;
	}

	/**
	 * Gets the arrival.
	 *
	 * @return the arrival
	 */
	public Date getArrival() {
		return arrival;
	}

	/**
	 * Sets the arrival.
	 *
	 * @param arrival the new arrival
	 */
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	/** The departure start. */
	public Date departureStart;
	
	/** The departure end. */
	public Date departureEnd;
	
	/** The arrival. */
	public Date arrival;

	/**
	 * Gets the origin address.
	 *
	 * @return the origin address
	 */
	public String getOriginAddress() {
		return originAddress;
	}

	/**
	 * Sets the origin address.
	 *
	 * @param originAddress the new origin address
	 */
	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}

	/**
	 * Gets the destination address.
	 *
	 * @return the destination address
	 */
	public String getDestinationAddress() {
		return destinationAddress;
	}

	/**
	 * Sets the destination address.
	 *
	 * @param destinationAddress the new destination address
	 */
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	/**
	 * Instantiates a new simple travel.
	 */
	public SimpleTravel() {
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the passenger.
	 *
	 * @return the passenger
	 */
	public Long getPassenger() {
		return passenger;
	}

	/**
	 * Gets the steps.
	 *
	 * @return the steps
	 */
	public List<String> getSteps() {
		return steps;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Sets the passenger.
	 *
	 * @param passenger the new passenger
	 */
	public void setPassenger(Long passenger) {
		this.passenger = passenger;
	}

	/**
	 * Sets the steps.
	 *
	 * @param steps the new steps
	 */
	public void setSteps(List<String> steps) {
		this.steps = steps;

	}

	/**
	 * Sets the map image.
	 *
	 * @param mapImage the new map image
	 */
	public void setMapImage(byte[] mapImage) {
		this.mapImage = new Blob(mapImage);
	}

	/**
	 * Gets the map image.
	 *
	 * @return the map image
	 */
	public byte[] getMapImage() {
		return mapImage.getBytes();
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * Sets the distance.
	 *
	 * @param distance the new distance
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * Gets the distance.
	 *
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
}
