package com.covoiturage.client.view;

import java.util.Date;

import com.covoiturage.client.i18n.MapViewConstants;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapTypeId;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;


public class MapViewImpl extends Composite implements MapView {

	interface MyUiBinder extends UiBinder<FlowPanel, MapViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField FlowPanel flowpanel;
	@UiField(provided=true) MapWidget mapWidget;
	@UiField Button sendAddress,saveJourney;
	@UiField SuggestBox originAddress,destinationAddress;
	@UiField HorizontalPanel directionsPanel;

	@UiField Label to,from,distmax; 
	@UiField FormPanel departureForm;
	@UiField DateField dateOfJourney;
	@UiField TextField<String> departureStartTimeItem;
	@UiField TextField<String> departureEndTimeItem;
	@UiField TextField<String> arrivalTimeItem;
	@UiField RadioButton driverRadioButton,passengerRadioButton;
	@UiField TextBox distanceMax;
	
	@SuppressWarnings("unused")
	private Presenter presenter;
	private MapViewConstants constants=(MapViewConstants)GWT.create(MapViewConstants.class);

	public MapViewImpl() {
		MapOptions options = new MapOptions();
		options.setCenter(new LatLng(50.6687,4.57967));
		options.setZoom(12);
		options.setMapTypeId(new MapTypeId().getRoadmap());
	    options.setNavigationControl(true);
	    options.setDraggable(true);
	    options.setMapTypeControl(true);
	    mapWidget= new MapWidget(options);
	    
	    initWidget(binder.createAndBindUi(this));
	    
	    // internationalization
	    to.setText(constants.to()+" :");
	    from.setText(constants.from()+" :");
	    distmax.setText(constants.distmax());
	    sendAddress.setText(constants.gettravelway());
	    saveJourney.setText(constants.savejourney());

		driverRadioButton.setText(constants.driver());
		passengerRadioButton.setText(constants.passenger());

		dateOfJourney.setFieldLabel("Date of Journey"); //TODO ajouter à l'i18n
		dateOfJourney.setAllowBlank(false);

		
		departureStartTimeItem.setFieldLabel(constants.departuretime());
		departureStartTimeItem.setAllowBlank(false);
		departureStartTimeItem.setRegex("^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$");

		departureEndTimeItem.setFieldLabel(constants.and());
		departureEndTimeItem.setAllowBlank(false);
		departureEndTimeItem.setRegex("^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$");
		arrivalTimeItem.setFieldLabel(constants.arrivaltime());
		arrivalTimeItem.setAllowBlank(false);
		arrivalTimeItem.setRegex("^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$");
		


		driverRadioButton.setValue(true);
		
	}



	public RadioButton getPassengerRadioButton() {
		return passengerRadioButton;
	}

	public RadioButton getDriverRadioButton() {
		return driverRadioButton;
	}

	public DateField getDateOfJourney() {
		return dateOfJourney;
	}

	public HasClickHandlers getSendAddressButton() {
		return sendAddress;
	}

	public SuggestBox getOriginAddress() {

		return originAddress;
	}

	public SuggestBox getDestinationAddress() {

		return destinationAddress;
	}

	public MapWidget getMap() {

		return mapWidget;
	}

	@Override
	public HorizontalPanel getDirectionsPanel() {

		return directionsPanel;
	}

	public HasClickHandlers getSaveJourneyButton() {

		return saveJourney;
	}

	public float getDistanceMax() {

		return Float.valueOf(distanceMax.getText());
	}

	public FlowPanel getMapDecorator() {
		return flowpanel;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	public void setOriginAddress(SuggestBox originAddress) {
		this.originAddress=originAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress.setText(destinationAddress);
	}
	

	public TextField<String> getDepartureStartTime() {
		return departureStartTimeItem;
	}


	public TextField<String> getArrivalTime() {
		return arrivalTimeItem;
	}
	public TextField<String> getDepartureEndTime() {
		return departureEndTimeItem;
	}


}