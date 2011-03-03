package com.covoiturage.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
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
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class MapPresenter implements Presenter {  



	public interface Display {



		Widget asWidget();

		HasClickHandlers getSendAddressButton();

		String getDestinationAddress();

		MapWidget getMap();

		String getOriginAddress();

		DirectionsPanel getDirectionsPanel();
	}

	// private final MapServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final Display display;
	private Geocoder geocoder;
	private String addressOrigin;
	private String addressDestination;


	public MapPresenter(/*ContactsServiceAsync rpcService, */HandlerManager eventBus, Display view) {
		//  this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = view;
	}

	public void bind() {
		display.getSendAddressButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				clearGeolocate();
				doGeolocate();
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



	}


	public void go(final HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());

	}
	private void clearGeolocate(){
		
		display.getMap().clearOverlays();
		
	}
	
	
	private void doGeolocate() {
		geocoder= new Geocoder();
		addressOrigin =display.getOriginAddress();
		addressDestination = display.getDestinationAddress();

	
		DirectionQueryOptions opts = new DirectionQueryOptions(display.getMap(),display.getDirectionsPanel());

		geocoder.getLatLng(addressOrigin, new LatLngCallback() {
			public void onFailure() {
				Window.alert(addressOrigin + " not found");
			}

			public void onSuccess(LatLng point) {



			}
		});
		geocoder.getLatLng(addressDestination, new LatLngCallback() {
			public void onFailure() {
				Window.alert(addressDestination + " not found");
			}

			public void onSuccess(LatLng point) {



			}
		});

		Directions.load("from: "+addressOrigin +" to: "+ addressDestination, opts,  new DirectionsCallback() {
			public void onFailure(int statusCode) {
				Window.alert("Failed to load directions: Status "
						+ StatusCodes.getName(statusCode) + " " + statusCode);
			}

			public void onSuccess(DirectionResults result) {

			}
		});




		
	}



}