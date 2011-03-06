package com.covoiturage.server;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;



import com.covoiturage.client.MapService;
import com.covoiturage.shared.Journey;
import com.covoiturage.shared.UserInfo;






import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MapServiceImpl extends RemoteServiceServlet implements MapService{


	private static final long serialVersionUID = 1L;

	@Override
	public Journey saveJourney(List<String> steps, Date date, UserInfo driver){
		Journey journey = new Journey();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try
		{
				journey.setSteps(steps);
				journey.setDate(date);
				journey.setDriver(driver);
				pm.makePersistent(journey);
			

		}
		finally
		{

			pm.close();
		}

		return journey;
	}




}



