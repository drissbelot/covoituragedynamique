package com.covoiturage.shared;


import java.util.Date;
import java.util.List;

import com.covoiturage.server.domain.Journey;
import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.ProxyFor;


@ProxyFor(Journey.class)
public interface JourneyProxy extends EntityProxy{
	
	public Date getDate();

	public void setDate(Date date);

	
	public String getDriver();

	public void setDriver(String driver);

	public List<String> getPassengers() ;

	public void setPassengers(List<String> passengers);

	public List<String> getSteps();

	public void setSteps(List<String> steps);

	EntityProxyId<JourneyProxy> stableId();
}

