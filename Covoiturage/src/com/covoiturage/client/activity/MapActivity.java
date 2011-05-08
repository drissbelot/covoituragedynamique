/*
 * 
 */
package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.NotifyService;
import com.covoiturage.client.NotifyServiceAsync;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.event.GetValidateDriversEvent;
import com.covoiturage.client.event.GetValidatePassengersEvent;
import com.covoiturage.client.event.PossiblePassengersEvent;
import com.covoiturage.client.event.PossiblePassengersEventHandler;
import com.covoiturage.client.event.SelectPassengersEvent;
import com.covoiturage.client.event.SelectPassengersEventHandler;
import com.covoiturage.client.i18n.MapViewConstants;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.ValidatePassengersPlace;
import com.covoiturage.client.view.MapView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.JourneyRequest;
import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.SimpleTravelRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.WidgetComponent;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.maps.client.base.ElementProvider;
import com.google.gwt.maps.client.base.HasElementProvider;
import com.google.gwt.maps.client.base.HasLatLng;
import com.google.gwt.maps.client.directions.DirectionsCallback;
import com.google.gwt.maps.client.directions.DirectionsRenderer;
import com.google.gwt.maps.client.directions.DirectionsRequest;
import com.google.gwt.maps.client.directions.DirectionsResult;
import com.google.gwt.maps.client.directions.DirectionsService;
import com.google.gwt.maps.client.directions.DirectionsTravelMode;
import com.google.gwt.maps.client.directions.DirectionsWaypoint;
import com.google.gwt.maps.client.directions.HasDirectionsLeg;
import com.google.gwt.maps.client.directions.HasDirectionsRenderer;
import com.google.gwt.maps.client.directions.HasDirectionsRequest;
import com.google.gwt.maps.client.directions.HasDirectionsResult;
import com.google.gwt.maps.client.directions.HasDirectionsService;
import com.google.gwt.maps.client.directions.HasDirectionsStep;
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
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

// TODO: Auto-generated Javadoc
/**
 * The Class MapActivity.
 */
public class MapActivity extends AbstractActivity implements MapView.Presenter {

	/** The request factory. */
	private final CovoiturageRequestFactory requestFactory;

	/** The event bus. */
	private final EventBus eventBus;

	/** The map view. */
	private final MapView mapView;

	/** The geocoder. */
	private HasGeocoder geocoder;

	/** The date. */
	private Date date = new Date();

	/** The departure start. */
	private final Date departureStart = new Date();

	/** The departure end. */
	private final Date departureEnd = new Date();

	/** The arrival. */
	private final Date arrival = new Date();

	/** The is passenger. */
	private boolean isDriver = true, isPassenger;

	/** The directions renderer. */
	private final HasDirectionsRenderer directionsRenderer = new DirectionsRenderer();;

	/** The counter. */
	private int counter;

	/** The steps. */
	private List<String> steps;

	/** The list address. */
	private List<String> listAddress = null;

	/** The place controller. */
	private final PlaceController placeController;

	/** The overlays. */
	private final List<HasMarker> overlays = new ArrayList<HasMarker>();

	/** The user details. */
	private UserInfoDetailsProxy userDetails;

	/** The directions driver. */
	private HasDirectionsResult directionsDriver = new DirectionsResult(null);

	/** The waypoints. */
	private List<HasDirectionsWaypoint> waypoints;

	/** The waypoints coords. */
	private List<String> waypointsCoords;

	/** The passengers. */
	private List<Long> passengers = new ArrayList<Long>();

	/** The notify service. */
	private final NotifyServiceAsync notifyService = GWT
			.create(NotifyService.class);

	/** The passengers travels. */
	private List<Long> passengersTravels = new ArrayList<Long>();

	/** The map url. */
	private String mapUrl;

	/** The distance. */
	private double distance;

	/** The duration. */
	private double duration;

	/** The user service. */
	private final UserServiceAsync userService = GWT.create(UserService.class);

	/** The image el. */
	private Element imageElOrigin = null;
	private Element imageElDestination = null;
	private Element imageElDate = null;

	private Element imageElDepartureStart, imageElDepartureEnd, imageElArrival;

	/** The mapviewconstants. */
	private final MapViewConstants mapviewconstants = GWT
			.create(MapViewConstants.class);

	/**
	 * Instantiates a new map activity.
	 * 
	 * @param clientFactory
	 *            the client factory
	 */
	public MapActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();

		this.eventBus = clientFactory.getEventBus();
		this.mapView = clientFactory.getMapView();
		this.placeController = clientFactory.getPlaceController();
	}

	/**
	 * Bind.
	 */
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

		((SuggestBox) (mapView.getOriginField().getWidget())).getTextBox()
				.addBlurHandler(new BlurHandler() {

					@Override
					public void onBlur(BlurEvent event) {

						WidgetComponent imageValid = new WidgetComponent(
								new Image(mapView.getCovoiturageResources()
										.valid()));
						WidgetComponent imageInvalid = new WidgetComponent(
								new Image(mapView.getCovoiturageResources()
										.invalid()));
						if (mapView.getOriginField().getValue() != null) {
							if (imageElOrigin != null)
								mapView.getOriginField().el().getParent().dom
										.removeChild(imageElOrigin);
							imageValid.render(mapView.getOriginField().el()
									.getParent().dom);
							imageElOrigin = mapView.getOriginField().el()
									.getParent().dom.appendChild(imageValid
									.getElement());

							imageValid.el().alignTo(
									mapView.getOriginField().getElement(),
									"tl-tr", new int[] { 2, 3 });

						} else {
							if (imageElOrigin != null)
								mapView.getOriginField().el().getParent().dom
										.removeChild(imageElOrigin);
							imageInvalid.render(mapView.getOriginField().el()
									.getParent().dom);
							imageElOrigin = mapView.getOriginField().el()
									.getParent().dom.appendChild(imageInvalid
									.getElement());

							imageInvalid.el().alignTo(
									mapView.getOriginField().getElement(),
									"tl-tr", new int[] { 2, 3 });

						}
					}
				});
		((SuggestBox) (mapView.getDestinationField().getWidget())).getTextBox()
				.addBlurHandler(new BlurHandler() {

					@Override
					public void onBlur(BlurEvent event) {

						WidgetComponent imageValid = new WidgetComponent(
								new Image(mapView.getCovoiturageResources()
										.valid()));
						WidgetComponent imageInvalid = new WidgetComponent(
								new Image(mapView.getCovoiturageResources()
										.invalid()));
						if (mapView.getDestinationField().getValue() != null) {
							if (imageElDestination != null)
								mapView.getDestinationField().el().getParent().dom
										.removeChild(imageElDestination);
							imageValid.render(mapView.getDestinationField()
									.el().getParent().dom);
							imageElDestination = mapView.getDestinationField()
									.el().getParent().dom
									.appendChild(imageValid.getElement());

							imageValid.el().alignTo(
									mapView.getDestinationField().getElement(),
									"tl-tr", new int[] { 2, 3 });

						} else {
							if (imageElDestination != null)
								mapView.getDestinationField().el().getParent().dom
										.removeChild(imageElDestination);
							imageInvalid.render(mapView.getDestinationField()
									.el().getParent().dom);
							imageElDestination = mapView.getDestinationField()
									.el().getParent().dom
									.appendChild(imageInvalid.getElement());

							imageInvalid.el().alignTo(
									mapView.getDestinationField().getElement(),
									"tl-tr", new int[] { 2, 3 });

						}
					}
				});

		mapView.getDateOfJourney().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								mapView.getCovoiturageResources().valid()));

						if (mapView.getDateOfJourney().getValue() != null) {

							image.render(mapView.getDateOfJourney().el()
									.getParent().dom);
							imageElDate = mapView.getDateOfJourney().el()
									.getParent().dom.appendChild(image
									.getElement());

							image.el().alignTo(
									mapView.getDateOfJourney().getElement(),
									"tl-tr", new int[] { 2, 3 });
							mapView.getDateOfJourney().el().getParent()
									.setHeight(37);

						} else {
							if (imageElDate != null)
								mapView.getDateOfJourney().el().getParent().dom
										.removeChild(imageElDate);

						}

					}
				});

		mapView.getDepartureStartTime().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								mapView.getCovoiturageResources().valid()));

						if (mapView.getDepartureStartTime().getValue() != null) {

							image.render(mapView.getDepartureStartTime().el()
									.getParent().dom);
							imageElDepartureStart = mapView
									.getDepartureStartTime().el().getParent().dom
									.appendChild(image.getElement());

							image.el().alignTo(
									mapView.getDepartureStartTime()
											.getElement(), "tl-tr",
									new int[] { 2, 3 });
							mapView.getDepartureStartTime().el().getParent()
									.setHeight(37);

						} else {
							if (imageElDepartureStart != null)
								mapView.getDepartureStartTime().el()
										.getParent().dom
										.removeChild(imageElDepartureStart);

						}

					}
				});

		mapView.getDepartureEndTime().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								mapView.getCovoiturageResources().valid()));

						if (mapView.getDepartureEndTime().getValue() != null) {

							image.render(mapView.getDepartureEndTime().el()
									.getParent().dom);
							imageElDepartureEnd = mapView.getDepartureEndTime()
									.el().getParent().dom.appendChild(image
									.getElement());

							image.el().alignTo(
									mapView.getDepartureEndTime().getElement(),
									"tl-tr", new int[] { 2, 3 });
							mapView.getDepartureEndTime().el().getParent()
									.setHeight(37);

						} else {
							if (imageElDepartureEnd != null)
								mapView.getDepartureEndTime().el().getParent().dom
										.removeChild(imageElDepartureEnd);

						}

					}
				});

		mapView.getArrivalTime().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {

						WidgetComponent image = new WidgetComponent(new Image(
								mapView.getCovoiturageResources().valid()));

						if (mapView.getArrivalTime().getValue() != null) {

							image.render(mapView.getArrivalTime().el()
									.getParent().dom);
							imageElArrival = mapView.getArrivalTime().el()
									.getParent().dom.appendChild(image
									.getElement());

							image.el().alignTo(
									mapView.getArrivalTime().getElement(),
									"tl-tr", new int[] { 2, 3 });
							mapView.getArrivalTime().el().getParent()
									.setHeight(37);

						} else {
							if (imageElArrival != null)
								mapView.getArrivalTime().el().getParent().dom
										.removeChild(imageElArrival);

						}

					}
				});

		mapView.getDepartureStartTime().addListener(Events.KeyPress,
				new Listener<BaseEvent>() {

					@Override
					public void handleEvent(BaseEvent be) {
						if (mapView.getDepartureStartTime().getRawValue()
								.length() == 2)
							mapView.getDepartureStartTime().setRawValue(
									mapView.getDepartureStartTime()
											.getRawValue() + ":");
					}
				});

		mapView.getDepartureEndTime().addListener(Events.KeyPress,
				new Listener<BaseEvent>() {
					@Override
					public void handleEvent(BaseEvent be) {
						if (mapView.getDepartureEndTime().getRawValue()
								.length() == 2)
							mapView.getDepartureEndTime().setRawValue(
									mapView.getDepartureEndTime().getRawValue()
											+ ":");

					}
				});
		mapView.getArrivalTime().addListener(Events.KeyPress,
				new Listener<BaseEvent>() {
					@Override
					public void handleEvent(BaseEvent be) {
						if (mapView.getArrivalTime().getRawValue().length() == 2)
							mapView.getArrivalTime().setRawValue(
									mapView.getArrivalTime().getRawValue()
											+ ":");
					}
				});

		mapView.getDepartureStartTime().addListener(Events.Blur,
				new Listener<BaseEvent>() {
					@SuppressWarnings("deprecation")
					@Override
					public void handleEvent(BaseEvent be) {

						if (mapView.getDepartureStartTime().validate()
								&& mapView.getDepartureStartTime().getValue()
										.length() == 5) {
							departureStart.setHours(Integer.valueOf(mapView
									.getDepartureStartTime().getValue()
									.substring(0, 2)));

							departureStart.setMinutes(Integer.valueOf(mapView
									.getDepartureStartTime().getValue()
									.substring(3, 5)));
						}
					}
				});
		mapView.getDepartureEndTime().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@SuppressWarnings("deprecation")
					@Override
					public void handleEvent(BaseEvent be) {
						if (mapView.getDepartureEndTime().validate()
								&& mapView.getDepartureEndTime().getValue()
										.length() == 5) {
							departureEnd.setHours(Integer.valueOf(mapView
									.getDepartureEndTime().getValue()
									.substring(0, 2)));
							departureEnd.setMinutes(Integer.valueOf(mapView
									.getDepartureEndTime().getValue()
									.substring(3, 5)));
						}
					}
				});
		mapView.getArrivalTime().addListener(Events.Blur,
				new Listener<BaseEvent>() {

					@SuppressWarnings("deprecation")
					@Override
					public void handleEvent(BaseEvent be) {
						if (mapView.getArrivalTime().validate()
								&& mapView.getArrivalTime().getValue().length() == 5) {
							arrival.setHours(Integer.valueOf(mapView
									.getArrivalTime().getValue()
									.substring(0, 2)));
							arrival.setMinutes(Integer.valueOf(mapView
									.getArrivalTime().getValue()
									.substring(3, 5)));
						}
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

		eventBus.addHandler(SelectPassengersEvent.TYPE,
				new SelectPassengersEventHandler() {

					@Override
					public void onSelectPassengers(
							SelectPassengersEvent selectPassengersEvent) {
						passengers = new ArrayList<Long>();
						passengersTravels = new ArrayList<Long>();
						for (BaseModelData passenger : selectPassengersEvent
								.getPassengers()) {
							passengers.add(Long.valueOf(passenger.get("login")
									.toString()));
							passengersTravels.add(Long.valueOf(passenger.get(
									"id").toString()));
						}

						for (HasMarker overlay : overlays) {

							overlay.setMap(null);
							overlays.remove(overlay);
						}
						waypoints = new ArrayList<HasDirectionsWaypoint>();
						waypointsCoords = new ArrayList<String>();
						HasDirectionsWaypoint point = new DirectionsWaypoint();
						HasDirectionsWaypoint point1 = new DirectionsWaypoint();
						for (BaseModelData simpletravel : selectPassengersEvent
								.getPassengers()) {

							String origin = simpletravel.get("origin");
							String destination = simpletravel
									.get("destination");
							point.setLocation(origin);
							waypoints.add(point);
							waypointsCoords.add(simpletravel
									.get("originCoords").toString());
							waypointsCoords.add(simpletravel.get(
									"destinationCoords").toString());
							point1.setLocation(destination);
							waypoints.add(point1);

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
								double distance = response.getRoutes().get(0)
										.getLegs().get(0).getDistance()
										.getValue()
										- directionsDriver.getRoutes().get(0)
												.getLegs().get(0).getDistance()
												.getValue();
								double duration = response.getRoutes().get(0)
										.getLegs().get(0).getDuration()
										.getValue()
										- directionsDriver.getRoutes().get(0)
												.getLegs().get(0).getDuration()
												.getValue();
								eventBus.fireEvent(new PossiblePassengersEvent(
										distance, duration));
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
						request.setRegion("be");
						request.setAddress(mapView.getOriginAddress()
								.getTextBox().getText());
						try {
							geocoder.geocode(request, new GeocoderCallback() {
								@SuppressWarnings("deprecation")
								@Override
								public void callback(
										List<HasGeocoderResult> responses,
										String status) {
									MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) mapView
											.getOriginAddress()
											.getSuggestOracle();

									for (HasGeocoderResult result : responses) {
										oracle.add(result.getFormattedAddress());
									}
									mapView.getOriginAddress()
											.showSuggestionList();
								}
							});
						} catch (NullPointerException e) {

						}
					}
				});
		mapView.getDestinationAddress().getTextBox()
				.addKeyUpHandler(new KeyUpHandler() {
					@Override
					public void onKeyUp(KeyUpEvent event) {

						geocoder = new Geocoder();
						HasGeocoderRequest request = new GeocoderRequest();
						request.setRegion("be");
						request.setAddress(mapView.getDestinationAddress()
								.getTextBox().getText());
						try {
							geocoder.geocode(request, new GeocoderCallback() {

								@SuppressWarnings("deprecation")
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
									mapView.getDestinationAddress()
											.showSuggestionList();
								}

							});
						} catch (NullPointerException e) {

						}
					}

				});
		eventBus.addHandler(PossiblePassengersEvent.TYPE,
				new PossiblePassengersEventHandler() {

					@Override
					public void onPossiblePassengers(
							PossiblePassengersEvent event) {
						double distanceDelta = event.getDistance() - distance;
						double durationDelta = event.getDuration() - duration;

						mapView.getDistanceDelta().setText(
								Double.toString(distanceDelta));
						mapView.getDurationDelta().setText(
								DateTimeFormat.getFormat("HH:mm:ss").format(
										new Date((long) durationDelta * 1000),
										TimeZone.createTimeZone(0)));
						if (distanceDelta > 0)
							mapView.getDistanceDelta().el().dom.getStyle()
									.setColor("#FF0000");
						else
							mapView.getDistanceDelta().el().dom.getStyle()
									.setColor("#00FF00");
						if (durationDelta > 0)
							mapView.getDurationDelta().el().dom.getStyle()
									.setColor("#FF0000");
						else
							mapView.getDurationDelta().el().dom.getStyle()
									.setColor("#00FF00");

					}
				});
	}

	/**
	 * Do geolocate.
	 * 
	 * @param point
	 *            the point
	 */
	protected void doGeolocate(HasLatLng point) {
		geocoder = new Geocoder();
		HasGeocoderRequest request = new GeocoderRequest();
		request.setLatLng(point);
		geocoder.geocode(request, new GeocoderCallback() {

			@SuppressWarnings("deprecation")
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

	/**
	 * Save journey.
	 */
	protected void saveJourney() {
		date = mapView.getDateOfJourney().getValue();
		mapView.getSaveJourneyButton().setVisible(false);
		geocoder = new Geocoder();
		HasGeocoderRequest request = new GeocoderRequest();
		request.setAddress(mapView.getOriginAddress().getTextBox().getText());

		listAddress = new ArrayList<String>();
		geocoder.geocode(request, new GeocoderCallback() {
			@Override
			public void callback(List<HasGeocoderResult> responses,
					String status) {
				listAddress.add(responses.get(0).getGeometry().getLocation()
						.toUrlValue());
				geocoder = new Geocoder();
				HasGeocoderRequest request = new GeocoderRequest();
				request.setAddress(mapView.getDestinationAddress().getTextBox()
						.getText());

				geocoder.geocode(request, new GeocoderCallback() {
					@Override
					public void callback(List<HasGeocoderResult> responses,
							String status) {
						listAddress.add(responses.get(0).getGeometry()
								.getLocation().toUrlValue());

						if (isDriver) {

							JourneyRequest request = requestFactory
									.journeyRequest();
							Request<JourneyProxy> createReq = request.saveJourneyDriver(
									listAddress,
									date,
									departureStart,
									departureEnd,
									arrival,
									userDetails.getId(),
									mapView.getOriginAddress().getText(),
									mapView.getDestinationAddress().getText(),
									waypointsCoords,
									steps,
									passengersTravels,
									mapView.getCommentField().getValue(),
									duration,
									distance,
									userDetails.getCountOfPlaces()
											- passengers.size(), mapUrl);
							createReq.fire(new Receiver<JourneyProxy>() {

								@Override
								public void onSuccess(
										JourneyProxy responseJourney) {

									if (passengers != null) {
										int i = 0;
										for (final Long passenger : passengers) {

											notifyService
													.sendMessage(
															passenger,
															"Passenger found",
															responseJourney

																	+ "/"
																	+ passengersTravels
																			.get(i),
															userDetails
																	.getFirstName()
																	+ " "
																	+ userDetails
																			.getLastName(),
															new Date(
																	System.currentTimeMillis()),
															new AsyncCallback<Long>() {

																@Override
																public void onSuccess(
																		Long result) {

																	UserInfoDetailsRequest requestMessageUser = requestFactory
																			.userInfoDetailsRequest();
																	Request<UserInfoDetailsProxy> createReqMessageUser = requestMessageUser
																			.addMessageToUser(
																					passenger,
																					result);
																	createReqMessageUser
																			.fire(new Receiver<UserInfoDetailsProxy>() {

																				@Override
																				public void onSuccess(
																						UserInfoDetailsProxy response) {

																				}

																			});

																}

																@Override
																public void onFailure(
																		Throwable caught) {

																}
															});
											i++;
										}
										for (Long simpleTravel : passengersTravels) {
											SimpleTravelRequest requestTravel = requestFactory
													.simpleTravelRequest();
											Request<Void> createRequestTravel = requestTravel
													.updateSimpleTravel(
															simpleTravel,
															"accepted",
															"pending");
											createRequestTravel
													.fire(new Receiver<Void>() {
														@Override
														public void onSuccess(
																Void response) {

														}

													});
										}

									}

								}

								@Override
								public void onFailure(ServerFailure error) {
									if (error.getMessage().contains(
											"not logged in"))
										goTo(new LoginPlace(null));

								}
							});

						} else if (isPassenger) {

							SimpleTravelRequest request = requestFactory
									.simpleTravelRequest();

							Request<SimpleTravelProxy> createReq = request
									.saveJourneyPassenger(listAddress, mapView
											.getOriginAddress().getText(),
											mapView.getDestinationAddress()
													.getText(), date,
											departureStart, departureEnd,
											arrival, userDetails.getId(),
											mapView.getCommentField()
													.getValue(), distance,
											duration, mapUrl);

							createReq.fire(new Receiver<SimpleTravelProxy>() {

								@Override
								public void onSuccess(
										final SimpleTravelProxy responseTravel) {

									if (passengersTravels != null
											&& passengersTravels.size() != 0) {
										JourneyRequest requestJourney = requestFactory
												.journeyRequest();
										Request<JourneyProxy> createRequestJourney = requestJourney
												.updateJourney(
														passengersTravels
																.get(0),
														responseTravel.getId(),
														steps);
										createRequestJourney
												.fire(new Receiver<JourneyProxy>() {

													@Override
													public void onSuccess(
															final JourneyProxy response) {

														notifyService.sendMessage(
																response.getDriver(),
																"Driver found",
																response.getId()
																		+ "/"
																		+ responseTravel
																				.getId(),
																userDetails
																		.getFirstName()
																		+ " "
																		+ userDetails
																				.getLastName(),
																new Date(
																		System.currentTimeMillis()),
																new AsyncCallback<Long>() {

																	@Override
																	public void onSuccess(
																			Long result) {
																		UserInfoDetailsRequest requestMessageUser = requestFactory
																				.userInfoDetailsRequest();
																		Request<UserInfoDetailsProxy> createReqMessageUser = requestMessageUser
																				.addMessageToUser(
																						response.getDriver(),
																						result);
																		createReqMessageUser
																				.fire(new Receiver<UserInfoDetailsProxy>() {

																					@Override
																					public void onSuccess(
																							UserInfoDetailsProxy response) {

																					}

																				});

																	}

																	@Override
																	public void onFailure(
																			Throwable caught) {

																	}
																});

													}

												});
										SimpleTravelRequest requestTravel = requestFactory
												.simpleTravelRequest();
										Request<Void> createRequestTravel = requestTravel
												.updateSimpleTravel(
														responseTravel.getId(),
														"pending", "accepted");
										createRequestTravel
												.fire(new Receiver<Void>() {
													@Override
													public void onSuccess(
															Void response) {

													}

												});

									}

								}

								@Override
								public void onFailure(ServerFailure error) {
									if (error.getMessage().contains(
											"not logged in"))
										goTo(new LoginPlace(null));

								}
							});

						}

					}
				});
			}

		});

	}

	/**
	 * Clear geolocate.
	 */
	private void clearGeolocate() {

		for (int i = 0; i < overlays.size(); i++) {
			if (overlays.get(i).getClass() == Marker.class)
				MarkerImpl.impl.setMap(overlays.get(i).getJso(), null);
		}

	}

	/**
	 * Gets the directions.
	 * 
	 * @return the directions
	 */
	private void getDirections() {

		if (mapView.getDepartureStartTime().validate()

		&& mapView.getDepartureEndTime().validate()
				&& mapView.getArrivalTime().validate()) {
			mapUrl = "";
			duration = 0f;
			distance = 0f;
			HasDirectionsService directionsService = new DirectionsService();
			DirectionsRendererImpl.impl.setMap(directionsRenderer.getJso(),
					null);
			directionsRenderer.setMap(mapView.getMap().getMap());
			HasElementProvider element = new ElementProvider(mapView
					.getDirectionsPanel().getElement());
			directionsRenderer.setPanel(element);
			HasDirectionsRequest directionsRequest = new DirectionsRequest();
			HasDirectionsTravelMode travelMode = new DirectionsTravelMode();
			directionsRequest.setTravelMode(travelMode.Driving());
			directionsRequest.setOriginString(mapView.getOriginAddress()
					.getText());
			directionsRequest.setDestinationString(mapView
					.getDestinationAddress().getText());
			directionsService.route(directionsRequest,
					new DirectionsCallback() {
						@Override
						public void callback(HasDirectionsResult response,
								String status) {
							directionsRenderer.setDirections(response);
							directionsDriver = response;
							steps = new ArrayList<String>();
							for (HasDirectionsLeg leg : response.getRoutes()
									.get(0).getLegs()) {
								duration += leg.getDuration().getValue();
								distance += leg.getDistance().getValue();
								for (HasDirectionsStep step : leg.getSteps()) {
									for (int j = 0; j < step.getPath().size(); j = j + 4) {

										steps.add(step.getPath().get(j)
												.toUrlValue());
									}

								}
							}
							mapView.getDistance().setText(
									mapviewconstants.distance() + ": "
											+ distance + " m. ");

							mapView.getDuration()
									.setText(
											mapviewconstants.duration()
													+ ": "
													+ DateTimeFormat
															.getFormat(
																	"HH:mm:ss")
															.format(new Date(
																	(long) duration * 1000),
																	TimeZone.createTimeZone(0)));
							mapUrl = "http://maps.google.com/maps/api/staticmap?size=400x400&path=color:0x0000ff";
							for (String step : steps) {
								mapUrl += "%7C" + step;
							}
							mapUrl += "&sensor=false";

							if (isDriver) {
								SimpleTravelRequest request = requestFactory
										.simpleTravelRequest();
								Request<List<SimpleTravelProxy>> createReq = request
										.getSimpleTravels(steps,
												departureStart, departureEnd,
												arrival,
												mapView.getDistanceMax(),
												distance);

								createReq
										.fire(new Receiver<List<SimpleTravelProxy>>() {

											@Override
											public void onSuccess(
													final List<SimpleTravelProxy> resultSimpleTravel) {

												if (resultSimpleTravel != null
														&& resultSimpleTravel
																.size() != 0) {
													List<Long> resultPassengers = new ArrayList<Long>();
													for (SimpleTravelProxy simpletravel : resultSimpleTravel) {
														resultPassengers
																.add(simpletravel
																		.getPassenger());
													}

													goTo(new ValidatePassengersPlace(
															null));
													eventBus.fireEvent(new GetValidatePassengersEvent(
															resultPassengers,
															resultSimpleTravel));

												}

											}

											@Override
											public void onFailure(
													ServerFailure error) {
												if (error
														.getMessage()
														.contains(
																"not logged in"))
													goTo(new LoginPlace(null));

											}
										});

							} else if (isPassenger) {
								JourneyRequest request = requestFactory
										.journeyRequest();
								Request<List<JourneyProxy>> createReq = request
										.getJourneys(steps, departureStart,
												departureEnd, arrival,
												mapView.getDistanceMax());

								createReq
										.fire(new Receiver<List<JourneyProxy>>() {

											@Override
											public void onSuccess(
													final List<JourneyProxy> resultJourney) {

												if (resultJourney != null
														&& resultJourney.size() != 0) {
													List<Long> resultDriver = new ArrayList<Long>();
													for (JourneyProxy journey : resultJourney) {
														resultDriver.add(journey
																.getDriver());
													}

													goTo(new ValidatePassengersPlace(
															null));
													eventBus.fireEvent(new GetValidateDriversEvent(
															resultDriver,
															resultJourney));

												}

											}

											@Override
											public void onFailure(
													ServerFailure error) {
												if (error
														.getMessage()
														.contains(
																"not logged in"))
													goTo(new LoginPlace(null));

											}

										});

							}

						}

					});

		}
		mapView.getSaveJourneyButton().setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client
	 * .ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		bind();
		mapView.setPresenter(this);
		containerWidget.setWidget(mapView.asWidget());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.MapView.Presenter#goTo(com.google.gwt.place
	 * .shared.Place)
	 */
	@Override
	public void goTo(Place place) {

		placeController.goTo(place);

	}

}