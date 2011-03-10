package com.covoiturage.client.presenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.covoiturage.client.MapServiceAsync;
import com.covoiturage.client.UserAccountServiceAsync;
import com.covoiturage.shared.Journey;
import com.covoiturage.shared.SimpleTravel;
import com.covoiturage.shared.UserInfo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class MapPresenter implements Presenter {  



	public interface Display {



		Widget asWidget();

		HasClickHandlers getSendAddressButton();

		String getDestinationAddress();

		MapWidget getMap();

		String getOriginAddress();

		DirectionsPanel getDirectionsPanel();

		HasClickHandlers getSaveJourneyButton();

		DatePicker getDateOfJourney();

		RadioButton getDriverRadioButton();

		HasClickHandlers getPassengerRadioButton();

		float getDistanceMax();
	}

	private final MapServiceAsync mapRpcService;
	private final UserAccountServiceAsync userRpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private Geocoder geocoder;
	private Date date;
	private boolean isDriver, isPassenger;

	private List<String> listAddress=null;


	public MapPresenter(MapServiceAsync mapRpcService, UserAccountServiceAsync userRpcService,HandlerManager eventBus, Display view) {
		this.mapRpcService = mapRpcService;
		this.userRpcService = userRpcService;
		this.eventBus = eventBus;
		this.display = view;
	}

	public void bind() {
		display.getSendAddressButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				clearGeolocate();
				getDirections();
			}
		});
		display.getMap().addMapClickHandler(new MapClickHandler() {
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
		display.getSaveJourneyButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				saveJourney();

			}
		});
		display.getDateOfJourney().addValueChangeHandler(new ValueChangeHandler<Date>(){


			public void onValueChange(ValueChangeEvent<Date> event) {
				date = event.getValue();

			}
		});
		display.getDriverRadioButton().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				isDriver = display.getDriverRadioButton().getValue();
			}
		});
		display.getPassengerRadioButton().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				isPassenger = display.getDriverRadioButton().getValue();
			}
		});


	}


	protected void saveJourney() {


		geocoder= new Geocoder();
		listAddress = new ArrayList<String>();
		geocoder.getLatLng(display.getOriginAddress(), new LatLngCallback() {
			public void onFailure() {
				Window.alert(" not found");
			}

			public void onSuccess(LatLng point) {
				listAddress.add(point.toString());
				geocoder= new Geocoder();

				geocoder.getLatLng(display.getDestinationAddress(), new LatLngCallback() {
					public void onFailure() {
						Window.alert(" not found");
					}

					public void onSuccess(LatLng point) {
						listAddress.add(point.toString());
						userRpcService.getUserFromSession(new AsyncCallback<UserInfo>() {
							public void onFailure(Throwable caught) {

								GWT.log(caught.getMessage());
								GWT.log("failure");

							}
							public void onSuccess(UserInfo result) {
								GWT.log(result.getLogin());
								if (isDriver) {
									mapRpcService.saveJourneyDriver(listAddress,
											date, result,
											new AsyncCallback<Journey>() {
												public void onFailure(Throwable caught) {

													GWT.log(caught.getMessage());
													GWT.log("failure");

												}

												public void onSuccess(Journey result) {

													Window.alert("savec");
												}

											});
								}
								else if(isPassenger){
									mapRpcService.saveJourneyPassenger(listAddress, date, result,new AsyncCallback<SimpleTravel>() {
												public void onFailure(Throwable caught) {

													GWT.log(caught.getMessage());
													GWT.log("failure");

												}

												public void onSuccess(SimpleTravel result) {

													Window.alert("saved");
												}

											});
									
								}

							}
						});



					}
				});

			}



		});

	}









	public void go(final HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());

	}
	private void clearGeolocate(){

		display.getMap().clearOverlays();

	}




	private void getDirections(){
		DirectionQueryOptions opts = new DirectionQueryOptions(display.getMap(),display.getDirectionsPanel());
		Directions.load("from: "+display.getOriginAddress() +" to: "+ display.getDestinationAddress(), opts,  new DirectionsCallback() {
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

				mapRpcService.getPassengers(steps, display.getDistanceMax(), new AsyncCallback<List<UserInfo>>() {
					public void onFailure(Throwable caught) {


					}

					public void onSuccess(List<UserInfo> result) {


					}
				});

			}
		});





	}



}