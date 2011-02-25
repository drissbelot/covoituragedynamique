package com.covoiturage.client.view;
import com.covoiturage.client.presenter.MapPresenter;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.MapTypeControl;
import com.google.gwt.maps.client.control.SmallMapControl;
import com.google.gwt.maps.client.event.MapClickHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.Overlay;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class MapView extends Composite implements MapPresenter.Display {

	
	public MapView() {
		 DecoratorPanel MapDecorator = new DecoratorPanel();
		 initWidget(MapDecorator);
		 MapWidget mapWiget = new MapWidget(LatLng.newInstance(48.136559, 11.576318), 13);
	        mapWiget.setSize("500px", "300px");
	        Window.alert("page");
	        mapWiget.addControl(new SmallMapControl());
	        mapWiget.addControl(new MapTypeControl());
	 
	        mapWiget.addMapClickHandler(new MapClickHandler() {
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
	 
	        MapDecorator.add(mapWiget);
	}
	        
}