package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.domain.Journey;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(Journey.class)
public interface JourneyProxy extends EntityProxy {

	public Date getDate();

	public void setDate(Date date);

	public String getOriginAddress();

	public String getDestinationAddress();

	public String getDriver();

	public void setDriver(String driver);

	public List<String> getPassengersTravels();

	public void setPassengersTravels(List<String> passengersTravels);

	public List<String> getSteps();

	public void setSteps(List<String> steps);

	EntityProxyId<JourneyProxy> stableId();

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

	public String getId();

}
