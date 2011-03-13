package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.domain.SimpleTravel;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(SimpleTravel.class)
public interface SimpleTravelRequest extends RequestContext{
	
	Request<Long> countSimpleTravels();


	Request<List<SimpleTravelProxy>> findAllSimpleTravels();

	Request<SimpleTravelProxy> findSimpleTravel(Long id);
	
	Request<SimpleTravelProxy> saveJourneyPassenger(List<String> steps, Date date, UserInfoProxy passenger);

	InstanceRequest<SimpleTravelProxy, Void> persist();

	InstanceRequest<SimpleTravelProxy, Void> remove();

}