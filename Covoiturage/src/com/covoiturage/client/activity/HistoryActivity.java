package com.covoiturage.client.activity;

import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.TravelDetailsPlace;
import com.covoiturage.client.view.HistoryView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.JourneyRequest;
import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.SimpleTravelRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.ServerFailure;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HistoryActivity extends AbstractActivity implements
		HistoryView.Presenter {

	private final HistoryView historyView;
	private final CovoiturageRequestFactory requestFactory;
	private final PlaceController placeController;
	private final UserServiceAsync userService = GWT.create(UserService.class);
	private UserInfoDetailsProxy userDetails;

	public HistoryActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();

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
		userService.getUser(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				if (result != null) {
					UserInfoDetailsRequest userReq = requestFactory
							.userInfoDetailsRequest();
					Request<UserInfoDetailsProxy> createReq = userReq
							.findDetailsFromUser(Long.parseLong(result));
					createReq.fire(new Receiver<UserInfoDetailsProxy>() {

						@Override
						public void onSuccess(UserInfoDetailsProxy response) {
							userDetails = response;
							searchJourneys();
						}

						@Override
						public void onFailure(ServerFailure error) {
							if (error.getMessage().contains("not logged in"))
								goTo(new LoginPlace(null));

						}
					});
				} else {
					goTo(new LoginPlace(null));
				}

			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});
		historyView.getListGrid().addListener(Events.RowClick,
				new Listener<GridEvent<BaseModelData>>() {

					@Override
					public void handleEvent(GridEvent<BaseModelData> be) {
						goTo(new TravelDetailsPlace(be.getModel().get("type")
								.toString()
								+ be.getModel().get("id").toString()));
					}
				});

	}

	private void searchJourneys() {
		SimpleTravelRequest requestTravels = requestFactory
				.simpleTravelRequest();
		Request<List<SimpleTravelProxy>> createReqTravels = requestTravels
				.getSimpleTravelsFromUser(userDetails.getId());
		historyView.getListGrid().getStore().removeAll();
		createReqTravels.fire(new Receiver<List<SimpleTravelProxy>>() {

			@Override
			public void onSuccess(List<SimpleTravelProxy> response) {

				for (SimpleTravelProxy simpleTravel : response) {
					BaseModelData rec = new BaseModelData();

					rec.set("from", simpleTravel.getOriginAddress());
					rec.set("to", simpleTravel.getDestinationAddress());
					rec.set("date", simpleTravel.getDate());
					rec.set("id", simpleTravel.getId());
					rec.set("type", "SimpleTravel");
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

				for (JourneyProxy journey : response) {

					BaseModelData rec = new BaseModelData();

					rec.set("from", journey.getOriginAddress());
					rec.set("to", journey.getDestinationAddress());
					rec.set("date", journey.getDate());
					rec.set("id", journey.getId());
					rec.set("type", "Journey");
					historyView.getListGrid().getStore().add(rec);
				}

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
