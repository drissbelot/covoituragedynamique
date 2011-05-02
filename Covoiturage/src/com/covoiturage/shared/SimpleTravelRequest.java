package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.SimpleTravelDao;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(value = SimpleTravelDao.class, locator = DaoServiceLocator.class)
public interface SimpleTravelRequest extends RequestContext {

	Request<Long> countSimpleTravels();

	Request<List<SimpleTravelProxy>> findAllSimpleTravels();

	Request<SimpleTravelProxy> findSimpleTravel(Long id);

	Request<SimpleTravelProxy> saveJourneyPassenger(List<String> steps,
			String originAddress, String destinationAddress, Date date,
			Date departureStart, Date departureEnd, Date arrival, Long id,
			String comment, double distance, double duration, String mapUrl);

	Request<Long> persist(SimpleTravelProxy simpleTravel);

	Request<Void> remove(SimpleTravelProxy simpleTravel);

	Request<List<SimpleTravelProxy>> getSimpleTravels(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival,
			float distanceMax, double totalDistance);

	Request<List<SimpleTravelProxy>> getSimpleTravelsFromUser(Long userId);

	Request<Void> updateSimpleTravel(Long simpleTravel, String statusDriver,
			String statusPassenger);

}
