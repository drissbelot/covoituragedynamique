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

	
	public UserInfoProxy getDriver();

	public void setDriver(UserInfoProxy driver);

	public List<UserInfoProxy> getPassengers() ;

	public void setPassengers(List<UserInfoProxy> passengers);

	public List<String> getSteps();

	public void setSteps(List<String> steps);

	EntityProxyId<JourneyProxy> stableId();
}

