package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.view.HistoryView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.JourneyRequest;
import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.SimpleTravelRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.google.gwt.activity.shared.AbstractActivity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HistoryActivity extends AbstractActivity implements HistoryView.Presenter {
	private final EventBus eventBus;
	private final HistoryView historyView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;
	private UserInfoProxy currentUser;
	private UserInfoDetailsProxy userDetails;
	private List<JourneyProxy> journeys=new ArrayList<JourneyProxy>();
	private List<SimpleTravelProxy> simpleTravels=new ArrayList<SimpleTravelProxy>();

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
				currentUser = event.getCurrentUser();
				searchJourneys();
			}
		});
		//TODO trier un peu tout ça et afficher
		
	}



	private void searchJourneys() {
		UserInfoDetailsRequest request = requestFactory.userInfoDetailsRequest();
		Request<UserInfoDetailsProxy> createreq = request.findPassengerFromUser(currentUser.getId());
		createreq.fire(new Receiver<UserInfoDetailsProxy>() {

			@Override
			public void onSuccess(UserInfoDetailsProxy response) {
				userDetails=response;
				SimpleTravelRequest requestTravels = requestFactory.simpleTravelRequest();
				Request<List<SimpleTravelProxy>> createReqTravels = requestTravels.getSimpleTravelsFromUser(userDetails.getId());
				createReqTravels.fire(new Receiver<List<SimpleTravelProxy>>() {

					@Override
					public void onSuccess(List<SimpleTravelProxy> response) {
						simpleTravels=response;
						
					}
				});
				JourneyRequest requestJourneys = requestFactory.journeyRequest();
				Request<List<JourneyProxy>> createReq = requestJourneys.getJourneysFromUser(userDetails.getId());
				createReq.fire(new Receiver<List<JourneyProxy>>() {

					@Override
					public void onSuccess(List<JourneyProxy> response) {
						journeys=response;
						
					}
				});
				
				
			}
			
			
		});
		
	}



	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
