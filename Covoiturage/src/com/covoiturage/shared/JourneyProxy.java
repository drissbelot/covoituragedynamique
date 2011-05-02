package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.domain.Journey;
import com.covoiturage.server.locator.ObjectifyLocator;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(value = Journey.class, locator = ObjectifyLocator.class)
public interface JourneyProxy extends EntityProxy {

	public Date getDate();

	public void setDate(Date date);

	public String getOriginAddress();

	public String getDestinationAddress();

	public Long getDriver();

	public void setDriver(Long driver);

	public List<Long> getPassengersTravels();

	public void setPassengersTravels(List<Long> passengersTravels);

	public List<String> getSteps();

	public void setSteps(List<String> steps);

	public List<String> getWaypoints();

	public void setWaypoints(List<String> waypoints);

	public List<String> getStepsDetails();

	public void setStepsDetails(List<String> stepsDetails);

	public Date getDepartureStart();

	public void setDepartureStart(Date departureStart);

	public Date getDepartureEnd();

	public void setDepartureEnd(Date departureEnd);

	public Date getArrival();

	public void setArrival(Date arrival);

	public Long getId();

	public void setDistance(double distance);

	public double getDistance();

	public void setDuration(double duration);

	public double getDuration();

	public void setOriginAddress(String originAddress);

	public void setDestinationAddress(String destinationAddress);

	public void setPlaces(int places);

	public int getPlaces();

	public void setComment(String comment);

	public String getComment();

	public void setMapImage(byte[] mapImage);

	public byte[] getMapImage();

	public String getMapImageType();

	public void setMapImageType(String mapImageType);

}
