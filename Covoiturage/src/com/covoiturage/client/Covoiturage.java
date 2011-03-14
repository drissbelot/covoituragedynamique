package com.covoiturage.client;

import com.covoiturage.client.place.LoginPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;

import com.google.gwt.event.shared.EventBus;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;


public class Covoiturage implements EntryPoint {
	private Place defaultPlace = new LoginPlace("Covoiturage");
	private SimplePanel appWidget = new SimplePanel();
	SimplePanel westWidget = new SimplePanel();
	SimplePanel eastWidget = new SimplePanel();

	public void onModuleLoad() { 
		ClientFactory clientFactory = new ClientFactoryImpl();
     	EventBus eventBus = clientFactory.getEventBus();
     	PlaceController placeController = clientFactory.getPlaceController();
     	
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);

        activityManager.setDisplay(appWidget);

        
        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        RootPanel.get().add(appWidget);

        historyHandler.handleCurrentHistory();

	
	}
}
