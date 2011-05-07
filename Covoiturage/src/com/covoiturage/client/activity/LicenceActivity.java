/*
 * 
 */
package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.view.LicenceView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

// TODO: Auto-generated Javadoc
/**
 * The Class LicenceActivity.
 */
public class LicenceActivity extends AbstractActivity implements LicenceView.Presenter{
	
	/** The licence view. */
	LicenceView licenceView;
	
	/** The place controller. */
	private final PlaceController placeController;

	/**
	 * Instantiates a new licence activity.
	 *
	 * @param clientFactory the client factory
	 */
	public LicenceActivity(ClientFactory clientFactory) {
		this.licenceView = clientFactory.getLicenceView();
		this.placeController = clientFactory.getPlaceController();
	}
	
	/**
	 * Bind.
	 */
	private void bind() {
		licenceView.getNext().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				goTo(new LoginPlace(null));
			}
		});

	}
	
	/* (non-Javadoc)
	 * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		licenceView.setPresenter(this);
		panel.setWidget(licenceView.asWidget());
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LicenceView.Presenter#goTo(com.google.gwt.place.shared.Place)
	 */
	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
