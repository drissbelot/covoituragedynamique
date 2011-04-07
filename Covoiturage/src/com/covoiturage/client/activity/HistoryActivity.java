package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.view.HistoryView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HistoryActivity extends AbstractActivity implements HistoryView.Presenter {
	private final EventBus eventBus;
	private final HistoryView historyView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;


	public HistoryActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.historyView = clientFactory.getHistoryView();
		this.placeController = clientFactory.getPlaceController();
	}



	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		historyView.setPresenter(this);
		panel.setWidget(historyView.asWidget());

	}



	private void bind() {

		
	}



	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
