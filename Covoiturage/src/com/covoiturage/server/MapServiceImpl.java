package com.covoiturage.server;

import java.util.List;

import javax.jdo.PersistenceManager;



import com.covoiturage.client.MapService;

import com.covoiturage.shared.SimpleTravel;





import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MapServiceImpl extends RemoteServiceServlet implements MapService{


	private static final long serialVersionUID = 1L;

	@Override
	public SimpleTravel saveJourney(List<String> steps){
		SimpleTravel simpleTravel = new SimpleTravel();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try
		{
				simpleTravel.setSteps(steps);
				pm.makePersistent(simpleTravel);
			

		}
		finally
		{

			pm.close();
		}

		return simpleTravel;
	}




}



