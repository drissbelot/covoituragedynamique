/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class ContextInitializer.
 */
public class ContextInitializer implements ServletContextListener {

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
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
