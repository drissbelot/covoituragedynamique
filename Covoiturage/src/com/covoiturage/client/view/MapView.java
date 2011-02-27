package com.covoiturage.client.view;
import com.covoiturage.client.presenter.MapPresenter;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geocode.DirectionsPanel;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MapView extends Composite implements MapPresenter.Display {


	  private Label latLabel;
	  private Label lngLabel;
	  private FlowPanel mapDecorator;
	  private MapWidget mapWidget;
	  private Button sendAddress;
	  private  TextBox originAddress;
	  private  TextBox destinationAddress;
	  private VerticalPanel addressPanel;
	  private DirectionsPanel directionsPanel;

	public MapView() {
		mapDecorator = new FlowPanel();
		 initWidget(mapDecorator);
		 mapWidget = new MapWidget(LatLng.newInstance(48.136559, 11.576318), 13);
	     mapWidget.setSize("500px", "500px");
	     mapWidget.addControl(new LargeMapControl());
	    addressPanel = new VerticalPanel();
	    
	        originAddress= new TextBox();
	        originAddress.setVisibleLength(60);
	        originAddress.setText("1 Grand Place, Louvain-la-neuve");
	        destinationAddress= new TextBox();
	        destinationAddress.setVisibleLength(60);
	        destinationAddress.setText("1 Grand Place, Louvain-la-neuve");
	        sendAddress= new Button("Localiser");
	        
	         directionsPanel = new DirectionsPanel();

	        
	        addressPanel.add(originAddress);
	        addressPanel.add(destinationAddress);
	        addressPanel.add(sendAddress);

	        mapDecorator.add(buildLatLngPanel());
	        
	        mapDecorator.add(mapWidget);
	        mapDecorator.add(addressPanel);
	        mapDecorator.add(directionsPanel);
	          }
	
	 public HasClickHandlers getSendAddressButton() {
		    return sendAddress;
		  }
	
	Panel buildLatLngPanel() {
        HorizontalPanel horiz = new HorizontalPanel();
        horiz.add(new Label("Lat:"));
        latLabel = new Label();
        horiz.add(latLabel);
        horiz.add(new Label("Long:"));
        lngLabel = new Label();
        horiz.add(lngLabel);
        horiz.setSpacing(10);
        return horiz;
	        
	        
	}

	@Override
	public String getOriginAddress() {
		
		return originAddress.getText();
	}
public String getDestinationAddress() {
		
		return destinationAddress.getText();
	}
	

	@Override
	public MapWidget getMap() {

		return mapWidget;
	}

	@Override
	public DirectionsPanel getDirectionsPanel() {
		
		return directionsPanel;
	}
	        
}