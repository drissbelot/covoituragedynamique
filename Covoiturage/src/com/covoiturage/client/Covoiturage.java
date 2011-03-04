package com.covoiturage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

import com.google.gwt.event.shared.HandlerManager;


import com.google.gwt.user.client.ui.RootPanel;


public class Covoiturage implements EntryPoint {

	public void onModuleLoad() { 

	    HandlerManager eventBus = new HandlerManager(null);
	    UserAccountServiceAsync rpcService = GWT.create(UserAccountService.class);
	    AppController appViewer = new AppController(rpcService,eventBus);
	    appViewer.go(RootPanel.get());
	
	}
}
