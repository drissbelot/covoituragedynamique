package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.view.FooterView;
import com.google.gwt.activity.shared.AbstractActivity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class FooterActivity extends AbstractActivity implements FooterView.Presenter{
	
	FooterView FooterView;
	private PlaceController placeController;

	public FooterActivity(ClientFactory clientFactory) {
		this.FooterView = clientFactory.getFooterView();
		this.placeController = clientFactory.getPlaceController();

	}
	
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		FooterView.setPresenter(this);
        panel.setWidget(FooterView.asWidget());
		
	}

	private void bind() {

		
	}

	public void goTo(Place place) {
		placeController.goTo(place);
	}
}
