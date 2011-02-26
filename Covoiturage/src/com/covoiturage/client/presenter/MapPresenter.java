package com.covoiturage.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geocode.Geocoder;
import com.google.gwt.maps.client.geocode.LatLngCallback;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class MapPresenter implements Presenter {  



  public interface Display {
   


    Widget asWidget();

	HasClickHandlers getSendAddressButton();

	String getSendAddress();

	MapWidget getMap();
  }
  
 // private final MapServiceAsync rpcService;
  private final HandlerManager eventBus;
  private final Display display;
  private Geocoder geocoder;
  private String address;
  
  public MapPresenter(/*ContactsServiceAsync rpcService, */HandlerManager eventBus, Display view) {
  //  this.rpcService = rpcService;
    this.eventBus = eventBus;
    this.display = view;
  }
  
  public void bind() {
		display.getSendAddressButton().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        doGeolocate();
		      }
		    });
	  
	  
  }
  
  
  public void go(final HasWidgets container) {
	    bind();
	    container.clear();
	    container.add(display.asWidget());

	  }
  private void doGeolocate() {
	  geocoder= new Geocoder();
	  address =display.getSendAddress();

	  geocoder.getLatLng(address, new LatLngCallback() {
	      public void onFailure() {
	          Window.alert(address + " not found");
	        }

	        public void onSuccess(LatLng point) {
	          display.getMap().setCenter(point, 13);
	          Marker marker = new Marker(point);
	          display.getMap().addOverlay(marker);
	          
	          //displayLatLng(point);
	        }
	      });

	
	}
	
	  
  
}