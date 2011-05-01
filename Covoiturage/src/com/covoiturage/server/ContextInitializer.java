package com.covoiturage.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.covoiturage.server.domain.Journey;
import com.covoiturage.server.domain.Messages;
import com.covoiturage.server.domain.SimpleTravel;
import com.covoiturage.server.domain.UserInfo;
import com.covoiturage.server.domain.UserInfoDetails;
import com.covoiturage.server.domain.Vehicles;
import com.googlecode.objectify.ObjectifyService;

public class ContextInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg) {
		ObjectifyService.register(Journey.class);
		ObjectifyService.register(Messages.class);
		ObjectifyService.register(SimpleTravel.class);
		ObjectifyService.register(UserInfo.class);
		ObjectifyService.register(UserInfoDetails.class);
		ObjectifyService.register(Vehicles.class);
	}
}
