package com.covoiturage.client.view;
import com.covoiturage.client.presenter.MapPresenter;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;

public class MapView extends Composite implements MapPresenter.Display {


	  private Label latLabel;
	  private Label lngLabel;
	  private FlowPanel mapDecorator;
	  private MapWidget mapWidget;
	  private Button sendAddress;
	  private  TextBox address;

	public MapView() {
		mapDecorator = new FlowPanel();
		 initWidget(mapDecorator);
		 mapWidget = new MapWidget(LatLng.newInstance(48.136559, 11.576318), 13);
	     mapWidget.setSize("500px", "500px");
	     mapWidget.addControl(new LargeMapControl());
	     
	        address= new TextBox();
	        address.setVisibleLength(60);
	        address.setText("1 Grand Place, Louvain-la-neuve");
	        sendAddress= new Button("Localiser");
	        
	        
	        
	        mapDecorator.add(address);
	        mapDecorator.add(sendAddress);
	        mapDecorator.add(buildLatLngPanel());
	        
	        mapDecorator.add(mapWidget);
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
	public String getSendAddress() {
		
		return address.getText();
	}

	@Override
	public MapWidget getMap() {

		return mapWidget;
	}
	        
}