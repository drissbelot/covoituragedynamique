package com.covoiturage.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;



import com.covoiturage.client.MapService;
import com.covoiturage.shared.Journey;
import com.covoiturage.shared.SimpleTravel;
import com.covoiturage.shared.UserInfo;






import com.google.appengine.api.datastore.KeyFactory;
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

	public List<UserInfo> getPassengers(List<String> steps, float distance) {
		List<String> passengersInBuffer = MapUtils.bufferRoute(steps, distance);
		List<UserInfo> passengers = new ArrayList<UserInfo>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try
		{
			for (String passenger : passengersInBuffer) {
				Query query= pm.newQuery("select from com.covoiturage.shared.UserInfo where id == idParam");
				query.declareParameters("String idParam");
				try
				{
					if(passenger!=null){
					@SuppressWarnings("unchecked")
					List<UserInfo> results = (List<UserInfo>) query.execute(KeyFactory.stringToKey(passenger));
					if(results !=null)
						passengers.add(results.get(0));
					}

				}
				finally{
				
				}

			}



		}
		finally{
			pm.close();

		}
		return passengers;

	}


}



