package com.covoiturage.client.activity;

import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.view.HistoryView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.JourneyRequest;
import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.SimpleTravelRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.ServerFailure;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HistoryActivity extends AbstractActivity implements
		HistoryView.Presenter {
	private final EventBus eventBus;
	private final HistoryView historyView;
	private final CovoiturageRequestFactory requestFactory;
	private final PlaceController placeController;

	private UserInfoDetailsProxy userDetails;

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
		eventBus.addHandler(SendLoginEvent.TYPE, new SendLoginEventHandler() {
			@Override
			public void onSendLogin(SendLoginEvent event) {

				userDetails = event.getUserDetails();
				searchJourneys();
			}
		});

	}

	private void searchJourneys() {
		SimpleTravelRequest requestTravels = requestFactory
				.simpleTravelRequest();
		Request<List<SimpleTravelProxy>> createReqTravels = requestTravels
				.getSimpleTravelsFromUser(userDetails.getId());
		createReqTravels.fire(new Receiver<List<SimpleTravelProxy>>() {

			@Override
			public void onSuccess(List<SimpleTravelProxy> response) {

				for (SimpleTravelProxy simpleTravel : response) {
					BaseModelData rec = new BaseModelData();

					rec.set("from", simpleTravel.getOriginAddress());
					rec.set("to", simpleTravel.getDestinationAddress());
					rec.set("date", simpleTravel.getDate());
					historyView.getListGrid().getStore().add(rec);
				}
			}

			@Override
			public void onFailure(ServerFailure error) {
				if (error.getMessage().contains("not logged in"))
					goTo(new LoginPlace(null));

			}
		});
		JourneyRequest requestJourneys = requestFactory.journeyRequest();
		Request<List<JourneyProxy>> createReq = requestJourneys
				.getJourneysFromUser(userDetails.getId());
		createReq.fire(new Receiver<List<JourneyProxy>>() {

			@Override
			public void onSuccess(List<JourneyProxy> response) {
				historyView.getListGrid().getStore().removeAll();
				for (JourneyProxy journey : response) {

					BaseModelData rec = new BaseModelData();

					rec.set("from", journey.getOriginAddress());
					rec.set("to", journey.getDestinationAddress());
					rec.set("date", journey.getDate());
					historyView.getListGrid().getStore().add(rec);
				}
				// TODO détails avec un expander
			}

			@Override
			public void onFailure(ServerFailure error) {
				if (error.getMessage().contains("not logged in"))
					goTo(new LoginPlace(null));

			}

		});

	}

	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
