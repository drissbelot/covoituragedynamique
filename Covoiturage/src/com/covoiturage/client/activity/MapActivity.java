package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.GetValidatePassengersEvent;
import com.covoiturage.client.event.SelectPassengersEvent;
import com.covoiturage.client.event.SelectPassengersEventHandler;
import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.place.ValidatePassengersPlace;
import com.covoiturage.client.view.MapView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.JourneyRequest;

import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.SimpleTravelRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.maps.client.base.ElementProvider;
import com.google.gwt.maps.client.base.HasElementProvider;
import com.google.gwt.maps.client.base.HasLatLng;
import com.google.gwt.maps.client.directions.DirectionsCallback;
import com.google.gwt.maps.client.directions.DirectionsRenderer;
import com.google.gwt.maps.client.directions.DirectionsRequest;
import com.google.gwt.maps.client.directions.DirectionsService;
import com.google.gwt.maps.client.directions.DirectionsTravelMode;
import com.google.gwt.maps.client.directions.DirectionsWaypoint;
import com.google.gwt.maps.client.directions.HasDirectionsRenderer;
import com.google.gwt.maps.client.directions.HasDirectionsRequest;
import com.google.gwt.maps.client.directions.HasDirectionsResult;
import com.google.gwt.maps.client.directions.HasDirectionsService;
import com.google.gwt.maps.client.directions.HasDirectionsTravelMode;
import com.google.gwt.maps.client.directions.HasDirectionsWaypoint;
import com.google.gwt.maps.client.directions.impl.DirectionsRendererImpl;
import com.google.gwt.maps.client.event.Event;
import com.google.gwt.maps.client.event.HasMouseEvent;
import com.google.gwt.maps.client.event.MouseEventCallback;
import com.google.gwt.maps.client.geocoder.Geocoder;
import com.google.gwt.maps.client.geocoder.GeocoderCallback;
import com.google.gwt.maps.client.geocoder.GeocoderRequest;
import com.google.gwt.maps.client.geocoder.HasGeocoder;
import com.google.gwt.maps.client.geocoder.HasGeocoderRequest;
import com.google.gwt.maps.client.geocoder.HasGeocoderResult;
import com.google.gwt.maps.client.overlay.HasMarker;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.impl.MarkerImpl;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;

public class MapActivity extends AbstractActivity implements MapView.Presenter {

	private final CovoiturageRequestFactory requestFactory;
	private final EventBus eventBus;
	private final MapView mapView;
	private HasGeocoder geocoder;
	private Date date = new Date();
	private boolean isDriver = true, isPassenger;
	private final HasDirectionsRenderer directionsRenderer = new DirectionsRenderer();;
	private int counter;

	private List<String> listAddress = null;
	private final PlaceController placeController;
	private final List<HasMarker> overlays = new ArrayList<HasMarker>();
	private UserInfoProxy currentUser;

	public MapActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();

		this.eventBus = clientFactory.getEventBus();
		this.mapView = clientFactory.getMapView();
		this.placeController = clientFactory.getPlaceController();
	}

	public void bind() {
		mapView.getSendAddressButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				clearGeolocate();
				getDirections();

			}
		});

		MouseEventCallback mapClickCallback = new MouseEventCallback() {

			@Override
			public void callback(HasMouseEvent event) {

				HasLatLng point = event.getLatLng();
				HasMarker marker;
				switch (counter) {
				case 0:
					marker = new Marker();
					marker.setPosition(point);
					marker.setMap(mapView.getMap().getMap());
					doGeolocate(point);
					overlays.add(marker);
					counter++;
					break;
				case 1:
					marker = new Marker();
					marker.setPosition(point);
					marker.setMap(mapView.getMap().getMap());
					doGeolocate(point);
					overlays.add(marker);
					counter++;
					break;
				case 2:
					clearGeolocate();
					counter = 0;
					break;

				}

			}
		};

		Event.addListener(mapView.getMap().getMap(), "click", mapClickCallback);

		mapView.getSaveJourneyButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				saveJourney();

			}
		});
		mapView.getDateOfJourney().addValueChangeHandler(
				new ValueChangeHandler<Date>() {

					@Override
					public void onValueChange(ValueChangeEvent<Date> event) {
						date = event.getValue();

					}
				});
		mapView.getHours().addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				date.setHours(Integer.parseInt(mapView.getHours().getItemText(
						mapView.getHours().getSelectedIndex())));

			}
		});
		mapView.getMinutes().addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				date.setMinutes(Integer.parseInt(mapView.getMinutes()
						.getItemText(mapView.getMinutes().getSelectedIndex())));

			}
		});
		mapView.getDriverRadioButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				isDriver = mapView.getDriverRadioButton().getValue();
				isPassenger = mapView.getPassengerRadioButton().getValue();
			}
		});
		mapView.getPassengerRadioButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				isDriver = mapView.getDriverRadioButton().getValue();
				isPassenger = mapView.getPassengerRadioButton().getValue();
			}
		});
		eventBus.addHandler(SendLoginEvent.TYPE, new SendLoginEventHandler() {
			@Override
			public void onSendLogin(SendLoginEvent event) {
				currentUser = event.getCurrentUser();

			}
		});
		eventBus.addHandler(SelectPassengersEvent.TYPE,
				new SelectPassengersEventHandler() {

					@Override
					public void onSelectPassengers(
							SelectPassengersEvent selectPassengersEvent) {
						for (HasMarker overlay : overlays) {
							GWT.log(Integer.toString(overlays.size()));
							overlay.setMap(null);
							overlays.remove(overlay);
						}
						List<HasDirectionsWaypoint> waypoints = new ArrayList<HasDirectionsWaypoint>();
						HasDirectionsWaypoint point = new DirectionsWaypoint();

						for (SimpleTravelProxy simpletravel : selectPassengersEvent
								.getPassengers()) {

							String origin = simpletravel.getSteps().get(0);
							String destination = simpletravel.getSteps().get(1);
							point.setLocation(origin);
							waypoints.add(point);
							point.setLocation(destination);
							waypoints.add(point);

						}
						DirectionsRendererImpl.impl.setMap(
								directionsRenderer.getJso(), null);
						directionsRenderer.setMap(mapView.getMap().getMap());
						HasDirectionsRequest request = new DirectionsRequest();
						request.setWaypoints(waypoints);
						request.setOriginString(mapView.getOriginAddress()
								.getText());
						request.setDestinationString(mapView
								.getDestinationAddress().getText());
						HasDirectionsTravelMode travelMode = new DirectionsTravelMode();
						request.setTravelMode(travelMode.Driving());
						HasDirectionsService service = new DirectionsService();
						service.route(request, new DirectionsCallback() {

							@Override
							public void callback(HasDirectionsResult response,
									String status) {
								directionsRenderer.setDirections(response);

							}
						});
					}
				});

		mapView.getOriginAddress().getTextBox()
				.addKeyUpHandler(new KeyUpHandler() {
					@Override
					public void onKeyUp(KeyUpEvent event) {

						geocoder = new Geocoder();
						HasGeocoderRequest request = new GeocoderRequest();
						request.setAddress(mapView.getOriginAddress()
								.getTextBox().getText());
						geocoder.geocode(request, new GeocoderCallback() {

							@Override
							public void callback(
									List<HasGeocoderResult> responses,
									String status) {
								MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) mapView
										.getOriginAddress().getSuggestOracle();
								for (HasGeocoderResult result : responses) {
									oracle.add(result.getFormattedAddress());
								}

							}
						});

					}
				});
		mapView.getDestinationAddress().getTextBox()
				.addKeyUpHandler(new KeyUpHandler() {
					@Override
					public void onKeyUp(KeyUpEvent event) {

						geocoder = new Geocoder();
						HasGeocoderRequest request = new GeocoderRequest();
						request.setAddress(mapView.getDestinationAddress()
								.getTextBox().getText());
						geocoder.geocode(request, new GeocoderCallback() {

							@Override
							public void callback(
									List<HasGeocoderResult> responses,
									String status) {
								MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) mapView
										.getDestinationAddress()
										.getSuggestOracle();
								for (HasGeocoderResult result : responses) {
									oracle.add(result.getFormattedAddress());
								}

							}

						});

					}
				});
	}

	protected void doGeolocate(HasLatLng point) {
		geocoder = new Geocoder();
		HasGeocoderRequest request = new GeocoderRequest();
		request.setLatLng(point);
		geocoder.geocode(request, new GeocoderCallback() {

			@Override
			public void callback(List<HasGeocoderResult> responses,
					String status) {
				if (counter == 1) {
					mapView.getOriginAddress().setText(
							responses.get(0).getFormattedAddress());
				} else if (counter == 2) {
					mapView.setDestinationAddress(responses.get(0)
							.getFormattedAddress());

				}

			}

		});
	}

	protected void saveJourney() {
		geocoder = new Geocoder();
		HasGeocoderRequest request = new GeocoderRequest();
		request.setAddress(mapView.getOriginAddress().getTextBox().getText());
		GWT.log(mapView.getOriginAddress().getTextBox().getText());
		listAddress = new ArrayList<String>();
		geocoder.geocode(request, new GeocoderCallback() {
			@Override
			public void callback(List<HasGeocoderResult> responses,
					String status) {
				listAddress.add(responses.get(0).getGeometry().getLocation()
						.toString());
				geocoder = new Geocoder();
				HasGeocoderRequest request = new GeocoderRequest();
				request.setAddress(mapView.getDestinationAddress().getTextBox()
						.getText());
				geocoder.geocode(request, new GeocoderCallback() {
					@Override
					public void callback(List<HasGeocoderResult> responses,
							String status) {
						listAddress.add(responses.get(0).getGeometry()
								.getLocation().toString());

						if (isDriver) {
							JourneyRequest request = requestFactory
									.journeyRequest();
							Request<JourneyProxy> createReq = request
									.saveJourneyDriver(listAddress, date,
											currentUser.getId());
							createReq.fire(new Receiver<JourneyProxy>() {

								@Override
								public void onSuccess(JourneyProxy response) {

									Window.alert("savec");

								}
							});

						} else if (isPassenger) {
							UserInfoDetailsRequest requestPassenger = requestFactory
									.userInfoDetailsRequest();
							Request<UserInfoDetailsProxy> createReqPassenger = requestPassenger
									.findPassengerFromUser(currentUser.getId());

							createReqPassenger
									.fire(new Receiver<UserInfoDetailsProxy>() {

										@Override
										public void onSuccess(
												UserInfoDetailsProxy response) {

											SimpleTravelRequest request = requestFactory
													.simpleTravelRequest();
											Request<SimpleTravelProxy> createReq = request
													.saveJourneyPassenger(
															listAddress, date,
															response.getId().toString());
											createReq
													.fire(new Receiver<SimpleTravelProxy>() {

														@Override
														public void onSuccess(
																SimpleTravelProxy response) {

															Window.alert("saved");

														}
													});

										}
									});

						}

					}
				});
			}

		});

	}

	private void clearGeolocate() {

		for (int i = 0; i < overlays.size(); i++) {
			if (overlays.get(i).getClass() == Marker.class)
				MarkerImpl.impl.setMap(overlays.get(i).getJso(), null);
		}
		// overlays = new ArrayList<HasMarker>();

	}

	private void getDirections() {

		HasDirectionsService directionsService = new DirectionsService();
		DirectionsRendererImpl.impl.setMap(directionsRenderer.getJso(), null);
		directionsRenderer.setMap(mapView.getMap().getMap());
		HasElementProvider element = new ElementProvider(mapView
				.getDirectionsPanel().getElement());
		directionsRenderer.setPanel(element);
		HasDirectionsRequest directionsRequest = new DirectionsRequest();
		HasDirectionsTravelMode travelMode = new DirectionsTravelMode();
		directionsRequest.setTravelMode(travelMode.Driving());
		directionsRequest.setOriginString(mapView.getOriginAddress().getText());
		directionsRequest.setDestinationString(mapView.getDestinationAddress()
				.getText());
		directionsService.route(directionsRequest, new DirectionsCallback() {
			@Override
			public void callback(HasDirectionsResult response, String status) {
				directionsRenderer.setDirections(response);

				List<String> steps = new ArrayList<String>();
				for (int i = 0; i < response.getRoutes().get(0).getLegs()
						.get(0).getSteps().size(); i++) {
					steps.add(response.getRoutes().get(0).getLegs().get(0)
							.getSteps().get(i).getStartPoint().toString());

				}

				SimpleTravelRequest request = requestFactory
						.simpleTravelRequest();
				Request<List<SimpleTravelProxy>> createReq = request
						.getSimpleTravels(steps, mapView.getDistanceMax());

				createReq.fire(new Receiver<List<SimpleTravelProxy>>() {

					@Override
					public void onSuccess(
							final List<SimpleTravelProxy> resultSimpleTravel) {

						if (resultSimpleTravel != null
								&& resultSimpleTravel.size() != 0) {
							List<String> resultPassengers = new ArrayList<String>();
							for (SimpleTravelProxy simpletravel : resultSimpleTravel) {
								resultPassengers.add(simpletravel.getPassenger());
							}
										
									goTo(new ValidatePassengersPlace(null));
									eventBus.fireEvent(new GetValidatePassengersEvent(
											resultPassengers,
											resultSimpleTravel));

								}
							
						}
					});
				}
			

		});

	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		bind();
		mapView.setPresenter(this);
		containerWidget.setWidget(mapView.asWidget());

	}

	@Override
	public void goTo(Place place) {

		placeController.goTo(place);

	}

}