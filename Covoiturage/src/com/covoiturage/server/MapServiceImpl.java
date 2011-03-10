package com.covoiturage.server;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;



import com.covoiturage.client.MapService;
import com.covoiturage.shared.Journey;
import com.covoiturage.shared.SimpleTravel;
import com.covoiturage.shared.UserInfo;






import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MapServiceImpl extends RemoteServiceServlet implements MapService{


	private static final long serialVersionUID = 1L;

	@Override
	public Journey saveJourneyDriver(List<String> steps, Date date, UserInfo driver){
		Journey journey = new Journey();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try
		{
				journey.setSteps(steps);
				journey.setDate(date);
				journey.setDriver(driver.getId());
				pm.makePersistent(journey);
			

		}
		finally
		{

			pm.close();
		}

		return journey;
	}
	public SimpleTravel saveJourneyPassenger(List<String> steps, Date date, UserInfo passenger){
		SimpleTravel simpleTravel = new SimpleTravel();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try
		{
			simpleTravel.setSteps(steps);
			simpleTravel.setDate(date);
			simpleTravel.setPassenger(passenger.getId());
				pm.makePersistent(simpleTravel);
			

		}
		finally
		{

			pm.close();
		}

		return simpleTravel;
	}

	public List<UserInfo> getPassengers(List<String> steps) {
		MapUtils.bufferRoute(steps);
		
		return null;

	}




}



