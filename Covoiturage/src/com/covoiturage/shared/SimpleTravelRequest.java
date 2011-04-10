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

	Request<SimpleTravelProxy> findSimpleTravel(String id);
	
	Request<SimpleTravelProxy> saveJourneyPassenger(List<String> steps, String originAddress, String destinationAddress, Date date, Date departureStart, Date departureEnd, Date arrival, String id, String mapUrl);

	InstanceRequest<SimpleTravelProxy, Void> persist();

	InstanceRequest<SimpleTravelProxy, Void> remove();


	Request<List<SimpleTravelProxy>> getSimpleTravels(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival, float distanceMax);
	Request<List<SimpleTravelProxy>> getSimpleTravelsFromUser(String userId);


	Request<Void> updateSimpleTravel(String simpleTravel,
			String statusDriver, String statusPassenger);

}
