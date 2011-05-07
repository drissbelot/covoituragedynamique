/*
 * 
 */
package com.covoiturage.server.domain;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Blob;
import com.googlecode.objectify.annotation.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Journey.
 */
@Entity
public class Journey extends DatastoreObject {
	
	/** The arrival. */
	private Date arrival;

	/** The date. */
	private Date date;

	/** The departure end. */
	private Date departureEnd;

	/** The departure start. */
	private Date departureStart;

	/** The destination address. */
	private String destinationAddress;

	/** The driver. */
	private Long driver;

	/** The origin address. */
	private String originAddress;

	/** The passengers travels. */
	private List<Long> passengersTravels;

	/** The steps. */
	private List<String> steps;

	/** The steps details. */
	private List<String> stepsDetails;

	/** The waypoints. */
	private List<String> waypoints;

	/** The distance. */
	private double distance;

	/** The duration. */
	private double duration;

	/** The places. */
	private int places;

	/** The comment. */
	private String comment;
	
	/** The map image. */
	private Blob mapImage;
	
	/** The map image type. */
	private String mapImageType;

	/**
	 * Instantiates a new journey.
	 */
	public Journey() {
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
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
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
	 * Gets the departure start.
	 *
	 * @return the departure start
	 */
	public Date getDepartureStart() {
		return departureStart;
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
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public Long getDriver() {
		return driver;
	}

	/**
	 * Gets the origin address.
	 *
	 * @return the origin address
	 */
	public String getOriginAddress() {
		return originAddress;
	}

	/**
	 * Gets the passengers travels.
	 *
	 * @return the passengers travels
	 */
	public List<Long> getPassengersTravels() {
		return passengersTravels;
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
	 * Gets the steps details.
	 *
	 * @return the steps details
	 */
	public List<String> getStepsDetails() {
		return stepsDetails;
	}

	/**
	 * Gets the waypoints.
	 *
	 * @return the waypoints
	 */
	public List<String> getWaypoints() {
		return waypoints;
	}

	/**
	 * Sets the arrival.
	 *
	 * @param arrival the new arrival
	 */
	public void setArrival(Date arrival) {
		this.arrival = arrival;
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
	 * Sets the departure end.
	 *
	 * @param departureEnd the new departure end
	 */
	public void setDepartureEnd(Date departureEnd) {
		this.departureEnd = departureEnd;
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
	 * Sets the destination address.
	 *
	 * @param destinationAddress the new destination address
	 */
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	/**
	 * Sets the driver.
	 *
	 * @param driver the new driver
	 */
	public void setDriver(Long driver) {
		this.driver = driver;
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
	 * Sets the passengers travels.
	 *
	 * @param passengersTravels the new passengers travels
	 */
	public void setPassengersTravels(List<Long> passengersTravels) {
		this.passengersTravels = passengersTravels;
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
	 * Sets the steps details.
	 *
	 * @param stepsDetails the new steps details
	 */
	public void setStepsDetails(List<String> stepsDetails) {
		this.stepsDetails = stepsDetails;
	}

	/**
	 * Sets the waypoints.
	 *
	 * @param waypoints the new waypoints
	 */
	public void setWaypoints(List<String> waypoints) {
		this.waypoints = waypoints;
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
	 * Sets the places.
	 *
	 * @param places the new places
	 */
	public void setPlaces(int places) {
		this.places = places;
	}

	/**
	 * Gets the places.
	 *
	 * @return the places
	 */
	public int getPlaces() {
		return places;
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

}
