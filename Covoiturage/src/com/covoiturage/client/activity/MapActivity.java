package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.covoiturage.client.ClientFactory;

import com.covoiturage.client.event.getValidatePassengersEvent;
import com.covoiturage.client.view.MapView;
import com.covoiturage.server.domain.Journey;
import com.covoiturage.server.domain.SimpleTravel;
import com.covoiturage.server.domain.UserInfo;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.JourneyProxy;
import com.covoiturage.shared.JourneyRequest;
import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.SimpleTravelRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.event.MapClickHandler;
import com.google.gwt.maps.client.geocode.DirectionQueryOptions;
import com.google.gwt.maps.client.geocode.DirectionResults;
import com.google.gwt.maps.client.geocode.Directions;
import com.google.gwt.maps.client.geocode.DirectionsCallback;
import com.google.gwt.maps.client.geocode.DirectionsPanel;
import com.google.gwt.maps.client.geocode.Geocoder;
import com.google.gwt.maps.client.geocode.LatLngCallback;
import com.google.gwt.maps.client.geocode.StatusCodes;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.Overlay;
import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.server.RequestFactoryServlet;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class MapActivity extends AbstractActivity implements MapView.Presenter {  



	private final CovoiturageRequestFactory requestFactory;
	private final EventBus eventBus;
	private final MapView mapView;
	private Geocoder geocoder;
	private Date date;
	private boolean isDriver, isPassenger;

	private List<String> listAddress=null;


	public MapActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();

		this.eventBus = clientFactory.getEventBus();
		this.mapView = clientFactory.getMapView();
	}

	public void bind() {
		mapView.getSendAddressButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				clearGeolocate();
				getDirections();
			}
		});
		mapView.getMap().addMapClickHandler(new MapClickHandler() {
			public void onClick(MapClickEvent e) {
				MapWidget sender = e.getSender();
				Overlay overlay = e.getOverlay();
				LatLng point = e.getLatLng();

				if (overlay != null && overlay instanceof Marker) {
					sender.removeOverlay(overlay);
				} else {
					sender.addOverlay(new Marker(point));
				}
			}
		});
		mapView.getSaveJourneyButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				saveJourney();

			}
		});
		mapView.getDateOfJourney().addValueChangeHandler(new ValueChangeHandler<Date>(){


			public void onValueChange(ValueChangeEvent<Date> event) {
				date = event.getValue();

			}
		});
		mapView.getDriverRadioButton().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				isDriver = mapView.getDriverRadioButton().getValue();
				isPassenger = mapView.getPassengerRadioButton().getValue();
			}
		});
		mapView.getPassengerRadioButton().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				isDriver = mapView.getDriverRadioButton().getValue();
				isPassenger = mapView.getPassengerRadioButton().getValue();
			}
		});


	}


	protected void saveJourney() {


		geocoder= new Geocoder();
		listAddress = new ArrayList<String>();
		geocoder.getLatLng(mapView.getOriginAddress(), new LatLngCallback() {
			public void onFailure() {
				Window.alert(" not found");
			}

			public void onSuccess(LatLng point) {
				listAddress.add(point.toString());
				geocoder= new Geocoder();

				geocoder.getLatLng(mapView.getDestinationAddress(), new LatLngCallback() {
					public void onFailure() {
						Window.alert(" not found");
					}

					public void onSuccess(LatLng point) {
						listAddress.add(point.toString());
						
						UserInfoRequest request = requestFactory.userInfoRequest();
						RequestFactoryServlet.getThreadLocalRequest().getUserPrincipal().getName();

//						createReq.fire(new Receiver<UserInfoProxy>(){
//						userRpcService.getUserFromSession(new AsyncCallback<UserInfo>() {
//							public void onFailure(Throwable caught) {
//
//								GWT.log(caught.getMessage());
//								GWT.log("failure");
//
//							}
//							public void onSuccess(UserInfo result) {
//								GWT.log(result.getLogin());
//								if(isDriver) {
//									JourneyRequest request = requestFactory.journeyRequest();
//									Request<JourneyProxy> createReq = request.saveJourneyDriver(listAddress, date, result);
//									createReq.fire(new Receiver<JourneyProxy>(){
//
//										@Override
//										public void onSuccess(JourneyProxy response) {
//																	
//													Window.alert("savec");
//												
//
//										}
//										});
//								
//								
//			
//								}
//								else if(isPassenger){
//									SimpleTravelRequest request = requestFactory.simpleTravelRequest();
//									Request<SimpleTravelProxy> createReq = request.saveJourneyPassenger(listAddress, date, result);
//									createReq.fire(new Receiver<SimpleTravelProxy>(){
//
//										@Override
//										public void onSuccess(SimpleTravelProxy response) {
//																	
//													Window.alert("saved");
//												
//
//										}
//										});
//									
//									
//									
//									
//						
//									
//								}
//
//							}
//						});



					}
				});

			}



		});

	}









	private void clearGeolocate(){

		mapView.getMap().clearOverlays();

	}




	private void getDirections(){
		DirectionQueryOptions opts = new DirectionQueryOptions(mapView.getMap(),mapView.getDirectionsPanel());
		Directions.load("from: "+mapView.getOriginAddress() +" to: "+ mapView.getDestinationAddress(), opts,  new DirectionsCallback() {
			public void onFailure(int statusCode) {
				Window.alert("Failed to load directions: Status "
						+ StatusCodes.getName(statusCode) + " " + statusCode);
			}

			public void onSuccess(DirectionResults result) {
				List<String> steps=new ArrayList<String>();
				for(int i = 0; i < result.getPolyline().getVertexCount(); i++)
				{
					steps.add(result.getPolyline().getVertex(i).toString());


				} 
				UserInfoRequest request = requestFactory.userInfoRequest();
				Request<List<UserInfoProxy>> createReq = request.getPassengers(listAddress, mapView.getDistanceMax());
				createReq.fire(new Receiver<List<UserInfoProxy>>() {
					
					@Override
					public void onSuccess(List<UserInfoProxy> result) {
						Window.alert(result.get(0).getLogin() +" "+ result.size());
						eventBus.fireEvent(new getValidatePassengersEvent());
					}
				});

		

					
		

			}
		});





	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		
	}



}