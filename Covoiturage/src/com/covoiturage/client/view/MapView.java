package com.covoiturage.client.view;
import com.covoiturage.client.presenter.MapPresenter;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geocode.Geocoder;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;

public class MapView extends Composite implements MapPresenter.Display {

	private Geocoder geocoder;
	  private Label latLabel;
	  private Label lngLabel;

	public MapView() {
		 DecoratorPanel MapDecorator = new DecoratorPanel();
		 initWidget(MapDecorator);
		 MapWidget mapWiget = new MapWidget(LatLng.newInstance(48.136559, 11.576318), 13);
	        mapWiget.setSize("500px", "300px");
	        final FormPanel form = new FormPanel();
	        form.setAction("#");

	        Panel formElements = new FlowPanel();
	        final TextBox address = new TextBox();
	        address.setVisibleLength(60);
	        address.setText("1 Grand Place, Louvain-la-neuve");
	        formElements.add(address);
	        formElements.add(buildLatLngPanel());

	        MapDecorator.add(mapWiget);
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
	        
}