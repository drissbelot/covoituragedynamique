package com.covoiturage.server.domain;

import java.util.Date;
import java.util.List;


import com.googlecode.objectify.annotation.Entity;

@Entity 
public class Journey  extends DatastoreObject{
	private Long driver;

	private List<Long> passengersTravels;

	private List<String> steps;

	private Date date;
	private List<String> stepsDetails;

	public Date getDepartureStart() {
		return departureStart;
	}

	public void setDepartureStart(Date departureStart) {
		this.departureStart = departureStart;
	}

	public Date getDepartureEnd() {
		return departureEnd;
	}

	public void setDepartureEnd(Date departureEnd) {
		this.departureEnd = departureEnd;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date departureStart;
	public Date departureEnd;
	public Date arrival;

	public List<String> getStepsDetails() {
		return stepsDetails;
	}

	public void setStepsDetails(List<String> stepsDetails) {
		this.stepsDetails = stepsDetails;
	}

	public List<String> waypoints;

	public String getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	private String originAddress;
	private String destinationAddress;

	public List<String> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(List<String> waypoints) {
		this.waypoints = waypoints;
	}



	public Journey() {
	}

	public Journey( Long driver, List<Long> passengersTravels,
			List<String> steps, String originAddress,
			String destinationAddress, List<String> stepsDetails) {
		super();
		this.driver = driver;
		this.passengersTravels = passengersTravels;
		this.steps = steps;
		this.originAddress = originAddress;
		this.destinationAddress = destinationAddress;
		this.stepsDetails = stepsDetails;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getDriver() {
		return driver;
	}

	public void setDriver(Long driver) {
		this.driver = driver;
	}

	public List<Long> getPassengersTravels() {
		return passengersTravels;
	}

	public void setPassengersTravels(List<Long> passengersTravels) {
		this.passengersTravels = passengersTravels;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

}
