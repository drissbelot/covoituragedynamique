package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.smartgwt.client.types.TimeFormatter;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TimeItem;

public class MapViewImpl extends Composite implements MapView {

	interface MyUiBinder extends UiBinder<FlowPanel, MapViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField FlowPanel flowpanel;
	@UiField(provided=true) MapWidget mapWidget;
	@UiField Button sendAddress;
	@UiField SuggestBox originAddress;
	@UiField SuggestBox destinationAddress;
	@UiField HorizontalPanel directionsPanel;
	@UiField Button saveJourney;
	@UiField DatePicker dateOfJourney;

	@UiField DynamicForm departureForm;
	TimeItem departureStartTimeItem;
	TimeItem departureEndTimeItem;
	TimeItem arrivalTimeItem;
	@UiField RadioButton driverRadioButton;
	@UiField RadioButton passengerRadioButton;
	@UiField TextBox distanceMax;


	@SuppressWarnings("unused")
	private Presenter presenter;

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

		driverRadioButton.setText("Driver");
		passengerRadioButton.setText("Passenger");

		departureStartTimeItem=new TimeItem();
		departureStartTimeItem.setTitle("Departure time between :");
		departureEndTimeItem=new TimeItem();
		departureEndTimeItem.setTitle("and :");
		arrivalTimeItem=new TimeItem();
		arrivalTimeItem.setTitle("Arrival time :");
		departureForm.setFields(departureStartTimeItem ,departureEndTimeItem,arrivalTimeItem);
		
	}



	public RadioButton getPassengerRadioButton() {
		return passengerRadioButton;
	}

	public RadioButton getDriverRadioButton() {
		return driverRadioButton;
	}

	public DatePicker getDateOfJourney() {
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
	

	public TimeItem getDepartureStartTime() {
		return departureStartTimeItem;
	}


	public TimeItem getArrivalTime() {
		return arrivalTimeItem;
	}
	public TimeItem getDepartureEndTime() {
		return departureEndTimeItem;
	}


}