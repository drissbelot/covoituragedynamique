package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.GetValidateDriversEvent;
import com.covoiturage.client.event.GetValidateDriversEventHandler;
import com.covoiturage.client.event.GetValidatePassengersEvent;
import com.covoiturage.client.event.GetValidatePassengersEventHandler;
import com.covoiturage.client.event.PossiblePassengersEvent;
import com.covoiturage.client.event.PossiblePassengersEventHandler;
import com.covoiturage.client.event.SelectPassengersEvent;
import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.activity.shared.AbstractActivity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;


public class ValidatePassengersActivity extends AbstractActivity implements
		ValidatePassengersView.Presenter {

	public interface Display {

		Widget asWidget();

	}

	private final EventBus eventBus;
	private final ValidatePassengersView validatePassengersView;
	private final CovoiturageRequestFactory requestFactory;
	private List<SimpleTravelProxy> passengersTravels;
	private List<JourneyProxy> journeys;
	private List<UserInfoDetailsProxy> passengersInfo = new ArrayList<UserInfoDetailsProxy>();
	private List<UserInfoDetailsProxy> driversInfo = new ArrayList<UserInfoDetailsProxy>();
	
	private final PlaceController placeController;
	private List<String> passengers;
	private List<String> drivers;



	public ValidatePassengersActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.validatePassengersView = clientFactory.getValidatePassengersView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {

		eventBus.addHandler(GetValidatePassengersEvent.TYPE,
				new GetValidatePassengersEventHandler() {
					@Override
					public void onGetValidatePassengers(
							GetValidatePassengersEvent event) {
								
						passengersTravels = event.getSimpleTravels();
						passengers = event.getPassengers();

						UserInfoDetailsRequest request = requestFactory
								.userInfoDetailsRequest();

						Request<List<UserInfoDetailsProxy>> createReq = request
								.getPassengerList(passengers);

						createReq
								.fire(new Receiver<List<UserInfoDetailsProxy>>() {

									@Override
									public void onSuccess(
											List<UserInfoDetailsProxy> resultPassengers) {
										passengersInfo = resultPassengers;


										
										
										List<BaseModelData> listRecords = new ArrayList<BaseModelData>();
										
										for (int i = 0; i<passengersTravels.size(); i++) {
									
											BaseModelData rec = new BaseModelData();
											rec.set("login", passengersTravels.get(i).getPassenger());
											rec.set("origin", passengersTravels.get(i).getOriginAddress());
											rec.set("destination", passengersTravels.get(i).getDestinationAddress());
											rec.set("firstName",passengersInfo.get(i).getFirstName() );
											rec.set("lastName",passengersInfo.get(i).getLastName() );
											rec.set("originCoords", passengersTravels.get(i).getSteps().get(0));
											rec.set("destinationCoords", passengersTravels.get(i).getSteps().get(1));
											rec.set("id", passengersTravels.get(i).getId());
											listRecords.add(rec );

										}
										
										validatePassengersView.getListGrid().getStore().add(listRecords); 
										
									}
								});

					}

				});
		
		
		eventBus.addHandler(GetValidateDriversEvent.TYPE,
				new GetValidateDriversEventHandler() {
					@Override
					public void onGetValidateDrivers(
							GetValidateDriversEvent event) {
								
						journeys = event.getJourneys();
						drivers= event.getDrivers();

						UserInfoDetailsRequest request = requestFactory
								.userInfoDetailsRequest();

						Request<List<UserInfoDetailsProxy>> createReq = request.getPassengerList(drivers);

						createReq
								.fire(new Receiver<List<UserInfoDetailsProxy>>() {

									@Override
									public void onSuccess(
											List<UserInfoDetailsProxy> resultPassengers) {
										driversInfo = resultPassengers;
										List<BaseModelData> listRecords = new ArrayList<BaseModelData>();
										
										for (int i = 0; i<journeys.size(); i++) {
									
											BaseModelData rec = new BaseModelData();
											rec.set("login", journeys.get(i).getDriver());
											rec.set("origin", journeys.get(i).getOriginAddress());
											rec.set("destination", journeys.get(i).getDestinationAddress());
											rec.set("firstName",driversInfo.get(i).getFirstName() );
											rec.set("lastName",driversInfo.get(i).getLastName() );
											rec.set("originCoords", journeys.get(i).getSteps().get(0));
											rec.set("destinationCoords", journeys.get(i).getSteps().get(1));
											listRecords.add(rec );

										}
										
										validatePassengersView.getListGrid().getStore().add(listRecords);
									}
								});

					}

				});
		
		
		validatePassengersView.getListGrid().getSelectionModel().addListener(Events.SelectionChange,new Listener<BaseEvent>(){
					
					@Override
					public void handleEvent(BaseEvent be){

						eventBus.fireEvent(new SelectPassengersEvent(
								validatePassengersView.getListGrid().getSelectionModel().getSelectedItems()));

					}
				});

		eventBus.addHandler(PossiblePassengersEvent.TYPE, new PossiblePassengersEventHandler() {
			
			@Override
			public void onPossiblePassengers(PossiblePassengersEvent event) {
				validatePassengersView.getDistanceLabel().setText((Double.toString(event.getDistance()))+" m");
				validatePassengersView.getDurationLabel().setText((Double.toString(event.getDuration()))+" s");
				
			}
		});

	}


	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		bind();
		validatePassengersView.setPresenter(this);
		panel.setWidget(validatePassengersView.asWidget());
	}

	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
