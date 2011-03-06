package com.covoiturage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.event.shared.HandlerManager;


import com.google.gwt.user.client.ui.RootPanel;


public class Covoiturage implements EntryPoint {

	public void onModuleLoad() { 

	    HandlerManager eventBus = new HandlerManager(null);
	    UserAccountServiceAsync userAccountRpcService = GWT.create(UserAccountService.class);
	    MapServiceAsync mapRpcService = GWT.create(MapService.class);
	    AppController appViewer = new AppController(userAccountRpcService,mapRpcService,eventBus);
	    appViewer.go(RootPanel.get());
	
	}
}
