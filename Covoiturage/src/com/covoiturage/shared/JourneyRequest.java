package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.domain.Journey;
import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;


@Service(Journey.class)
public interface JourneyRequest extends RequestContext{

	Request<Long> countJourneys();


	Request<List<JourneyProxy>> findAllJourneys();

	Request<JourneyProxy> findJourney(Long id);
	
	Request<JourneyProxy> saveJourneyDriver(List<String> steps, Date date, Date departureStart, Date departureEnd, Date arrival, String id,String originAddress, String destinationAddress, List<String> waypoints, List<String> stepsDetails);
	

	InstanceRequest<JourneyProxy, Void> persist();

	InstanceRequest<JourneyProxy, Void> remove();


	Request<List<JourneyProxy>> getJourneys(List<String> steps,
			float distanceMax);


	
}
