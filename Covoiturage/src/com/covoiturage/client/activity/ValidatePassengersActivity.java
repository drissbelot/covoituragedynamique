/*
 * 
 */
package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.GetValidateDriversEvent;
import com.covoiturage.client.event.GetValidateDriversEventHandler;
import com.covoiturage.client.event.GetValidatePassengersEvent;
import com.covoiturage.client.event.GetValidatePassengersEventHandler;
import com.covoiturage.client.event.SelectPassengersEvent;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.TravelDetailsPlace;
import com.covoiturage.client.view.ValidatePassengersExpanderViewImpl;
import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.grid.WidgetRowRenderer;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidatePassengersActivity.
 */
public class ValidatePassengersActivity extends AbstractActivity implements
		ValidatePassengersView.Presenter {

	/**
	 * The Interface Display.
	 */
	public interface Display {

		/**
		 * As widget.
		 *
		 * @return the widget
		 */
		Widget asWidget();

	}

	/** The event bus. */
	private final EventBus eventBus;
	
	/** The validate passengers view. */
	private final ValidatePassengersView validatePassengersView;
	
	/** The request factory. */
	private final CovoiturageRequestFactory requestFactory;
	
	/** The passengers travels. */
	private List<SimpleTravelProxy> passengersTravels;
	
	/** The journeys. */
	private List<JourneyProxy> journeys;
	
	/** The passengers info. */
	private List<UserInfoDetailsProxy> passengersInfo = new ArrayList<UserInfoDetailsProxy>();
	
	/** The drivers info. */
	private List<UserInfoDetailsProxy> driversInfo = new ArrayList<UserInfoDetailsProxy>();

	/** The place controller. */
	private final PlaceController placeController;
	
	/** The passengers. */
	private List<Long> passengers;
	
	/** The drivers. */
	private List<Long> drivers;
	
	/** The expander widget. */
	private ValidatePassengersExpanderViewImpl expanderWidget;

	/**
	 * Instantiates a new validate passengers activity.
	 *
	 * @param clientFactory the client factory
	 */
	public ValidatePassengersActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.validatePassengersView = clientFactory.getValidatePassengersView();
		this.placeController = clientFactory.getPlaceController();
	}

	/**
	 * Bind.
	 */
	private void bind() {

		eventBus.addHandler(GetValidatePassengersEvent.TYPE,
				new GetValidatePassengersEventHandler() {
					@Override
					public void onGetValidatePassengers(
							GetValidatePassengersEvent event) {
						validatePassengersView.getListGrid().getStore()
								.removeAll();
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

										for (int i = 0; i < passengersTravels
												.size(); i++) {

											BaseModelData rec = new BaseModelData();
											rec.set("login", passengersTravels
													.get(i).getPassenger());
											rec.set("date", passengersTravels
													.get(i).getDate());
											rec.set("origin", passengersTravels
													.get(i).getOriginAddress());
											rec.set("destination",
													passengersTravels
															.get(i)
															.getDestinationAddress());
											rec.set("firstName", passengersInfo
													.get(i).getFirstName());
											rec.set("lastName", passengersInfo
													.get(i).getLastName());
											rec.set("originCoords",
													passengersTravels.get(i)
															.getSteps().get(0));
											rec.set("destinationCoords",
													passengersTravels.get(i)
															.getSteps().get(1));
											rec.set("id", passengersTravels
													.get(i).getId());
											rec.set("type", "SimpleTravel");

											listRecords.add(rec);

										}

										validatePassengersView.getListGrid()
												.getStore().add(listRecords);

									}

									@Override
									public void onFailure(ServerFailure error) {
										if (error.getMessage().contains(
												"not logged in"))
											goTo(new LoginPlace(null));

									}
								});

					}

				});

		eventBus.addHandler(GetValidateDriversEvent.TYPE,
				new GetValidateDriversEventHandler() {
					@Override
					public void onGetValidateDrivers(
							GetValidateDriversEvent event) {
						validatePassengersView.getListGrid().getStore()
								.removeAll();
						journeys = event.getJourneys();
						drivers = event.getDrivers();

						UserInfoDetailsRequest request = requestFactory
								.userInfoDetailsRequest();

						Request<List<UserInfoDetailsProxy>> createReq = request
								.getPassengerList(drivers);

						createReq
								.fire(new Receiver<List<UserInfoDetailsProxy>>() {

									@Override
									public void onSuccess(
											List<UserInfoDetailsProxy> resultPassengers) {
										driversInfo = resultPassengers;
										List<BaseModelData> listRecords = new ArrayList<BaseModelData>();

										for (int i = 0; i < journeys.size(); i++) {

											BaseModelData rec = new BaseModelData();
											rec.set("login", journeys.get(i)
													.getDriver());
											rec.set("date", journeys.get(i)
													.getDate());
											rec.set("origin", journeys.get(i)
													.getOriginAddress());
											rec.set("destination", journeys
													.get(i)
													.getDestinationAddress());
											rec.set("firstName", driversInfo
													.get(i).getFirstName());
											rec.set("lastName", driversInfo
													.get(i).getLastName());
											rec.set("originCoords", journeys
													.get(i).getSteps().get(0));
											rec.set("destinationCoords",
													journeys.get(i).getSteps()
															.get(1));
											rec.set("id", journeys.get(i)
													.getId());
											rec.set("type", "Journey");
											listRecords.add(rec);

										}

										validatePassengersView.getListGrid()
												.getStore().add(listRecords);
									}

									@Override
									public void onFailure(ServerFailure error) {
										if (error.getMessage().contains(
												"not logged in"))
											goTo(new LoginPlace(null));

									}
								});

					}

				});

		validatePassengersView.getListGrid().getSelectionModel()
				.addListener(Events.SelectionChange, new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						eventBus.fireEvent(new SelectPassengersEvent(
								validatePassengersView.getListGrid()
										.getSelectionModel().getSelectedItems()));

					}
				});
		validatePassengersView.getExpander().setWidgetRowRenderer(
				new WidgetRowRenderer<BaseModelData>() {

					@Override
					public Widget render(final BaseModelData model, int rowIdx) {

						expanderWidget = new ValidatePassengersExpanderViewImpl(
								model);
						expanderWidget.getDetailsAnchor().addClickHandler(
								new ClickHandler() {

									@Override
									public void onClick(ClickEvent event) {
										goTo(new TravelDetailsPlace(model.get(
												"type").toString()
												+ model.get("id").toString()));

									}
								});
						expanderWidget.getMapImage().addClickHandler(
								new ClickHandler() {

									@Override
									public void onClick(ClickEvent event) {

										expanderWidget.getImageZoom().show();

									}
								});
						expanderWidget.getCloseButton().addSelectionListener(
								new SelectionListener<ButtonEvent>() {
									@Override
									public void componentSelected(ButtonEvent ce) {
										expanderWidget.getImageZoom().hide();
									}
								});

						return expanderWidget;
					}

				});

	}

	/* (non-Javadoc)
	 * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		bind();
		validatePassengersView.setPresenter(this);
		panel.setWidget(validatePassengersView.asWidget());
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ValidatePassengersView.Presenter#goTo(com.google.gwt.place.shared.Place)
	 */
	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
