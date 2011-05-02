package com.covoiturage.shared;

import java.util.Date;
import java.util.List;

import com.covoiturage.server.locator.DaoServiceLocator;
import com.covoiturage.server.service.JourneyDao;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.Service;

@Service(value = JourneyDao.class, locator = DaoServiceLocator.class)
public interface JourneyRequest extends RequestContext {

	Request<Long> countJourneys();

	Request<List<JourneyProxy>> findAllJourneys();

	Request<JourneyProxy> findJourney(Long id);

	Request<JourneyProxy> saveJourneyDriver(List<String> steps, Date date,
			Date departureStart, Date departureEnd, Date arrival, Long id,
			String originAddress, String destinationAddress,
			List<String> waypoints, List<String> stepsDetails,
			List<Long> passengers, String comment, double duration,
			double distance, int places, String mapImage);

	Request<Long> persist(JourneyProxy journey);

	Request<Void> remove(JourneyProxy journey);

	Request<List<JourneyProxy>> getJourneys(List<String> steps,
			Date departureStart, Date departureEnd, Date arrival,
			float distanceMax);

	Request<List<JourneyProxy>> getJourneysFromUser(Long id);

	Request<JourneyProxy> updateJourney(Long journeyId, Long simpleTravelId,
			List<String> steps);

}
