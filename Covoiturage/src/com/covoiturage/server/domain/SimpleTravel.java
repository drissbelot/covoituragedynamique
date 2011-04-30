package com.covoiturage.server.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.google.appengine.api.datastore.Blob;

@Entity
public class SimpleTravel extends DatastoreObject {

	private Date date;
	public Long passenger;
	private String originAddress;
	private String destinationAddress;
	private Blob mapImage;
	private String mapImageType;

	public String getMapImageType() {
		return mapImageType;
	}

	public void setMapImageType(String mapImageType) {
		this.mapImageType = mapImageType;
	}

	public String getStatusPassenger() {
		return statusPassenger;
	}

	public void setStatusPassenger(String statusPassenger) {
		this.statusPassenger = statusPassenger;
	}

	public String getStatusDriver() {
		return statusDriver;
	}

	public void setStatusDriver(String statusDriver) {
		this.statusDriver = statusDriver;
	}

	private String statusPassenger;
	private String statusDriver;

	private List<String> steps;

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

	public SimpleTravel() {
	}

	public SimpleTravel(Long passenger, List<String> steps) {

		this.passenger = passenger;
		this.steps = steps;
	}

	public Date getDate() {
		return date;
	}

	public Long getPassenger() {
		return passenger;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPassenger(Long passenger) {
		this.passenger = passenger;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;

	}

	public void setMapImage(byte[] mapImage) {
		this.mapImage = new Blob(mapImage);
	}

	public byte[] getMapImage() {
		return mapImage.getBytes();
	}
}
