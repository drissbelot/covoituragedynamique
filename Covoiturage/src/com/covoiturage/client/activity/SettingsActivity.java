package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.view.SettingsView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SettingsActivity extends AbstractActivity implements SettingsView.Presenter{
	
	private final EventBus eventBus;
	SettingsView settingsView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;

	public SettingsActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.settingsView = clientFactory.getSettingsView();
		this.placeController = clientFactory.getPlaceController();
	}
	
	private void bind() {
		
		
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		settingsView.setPresenter(this);
        panel.setWidget(settingsView.asWidget());
	}



	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
