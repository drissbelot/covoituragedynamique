package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;

import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.SettingsPlace;

import com.covoiturage.client.view.MenuView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MenuActivity extends AbstractActivity implements MenuView.Presenter{
	private final EventBus eventBus;
	private final MenuView menuView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;

	public MenuActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.menuView = clientFactory.getMenuView();
		this.placeController = clientFactory.getPlaceController();
	}
	
	private void bind() {
		menuView.getMapLabel().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				goTo(new MapPlace(null));
				
			}
		});
		menuView.getSettingsLabel().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				goTo(new SettingsPlace(null));
				
			}
		});
		
	}
	
	@Override
	public String mayStop() {

		return null;
	}

	@Override
	public void onCancel() {


	}

	@Override
	public void onStop() {


	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		menuView.setPresenter(this);
		panel.setWidget(menuView.asWidget());
	}



	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
