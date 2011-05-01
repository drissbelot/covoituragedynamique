package com.covoiturage.server.domain;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Journey extends DatastoreObject {
	private Date arrival;

	private Date date;

	private Date departureEnd;

	private Date departureStart;

	private String destinationAddress;

	private Long driver;

	private String originAddress;

	private List<Long> passengersTravels;

	private List<String> steps;

	private List<String> stepsDetails;

	private List<String> waypoints;

	private Float distance;

	private Float duration;

	public Journey() {
	}

	public Date getArrival() {
		return arrival;
	}

	public Date getDate() {
		return date;
	}

	public Date getDepartureEnd() {
		return departureEnd;
	}

	public Date getDepartureStart() {
		return departureStart;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public Long getDriver() {
		return driver;
	}

	public String getOriginAddress() {
		return originAddress;
	}

	public List<Long> getPassengersTravels() {
		return passengersTravels;
	}

	public List<String> getSteps() {
		return steps;
	}

	public List<String> getStepsDetails() {
		return stepsDetails;
	}

	public List<String> getWaypoints() {
		return waypoints;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDepartureEnd(Date departureEnd) {
		this.departureEnd = departureEnd;
	}

	public void setDepartureStart(Date departureStart) {
		this.departureStart = departureStart;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public void setDriver(Long driver) {
		this.driver = driver;
	}

	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}

	public void setPassengersTravels(List<Long> passengersTravels) {
		this.passengersTravels = passengersTravels;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

	public void setStepsDetails(List<String> stepsDetails) {
		this.stepsDetails = stepsDetails;
	}

	public void setWaypoints(List<String> waypoints) {
		this.waypoints = waypoints;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Float getDuration() {
		return duration;
	}

}
