package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapOptions;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.base.LatLng;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;

import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

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
	@UiField ListBox hours;
	@UiField ListBox minutes;
	@UiField RadioButton driverRadioButton;
	@UiField RadioButton passengerRadioButton;
	@UiField TextBox distanceMax;
	@UiField Anchor EditProfil;
	@UiField Anchor logout;

	@SuppressWarnings("unused")
	private Presenter presenter;

	public MapViewImpl() {
		final MapOptions options = new MapOptions();
		options.setCenter(new LatLng(48, 11));
		options.setZoom(8);
	    options.setNavigationControl(true);
	    options.setDraggable(true);
	    options.setMapTypeControl(true);
	    mapWidget= new MapWidget(options);
	    mapWidget.setSize("800px", "600px");

	    initWidget(binder.createAndBindUi(this));

		driverRadioButton.setText("Driver");
		passengerRadioButton.setText("Passenger");
		for (int i = 0; i < 24; i++) {
			hours.addItem(String.valueOf(i));
		}
		for (int i = 0; i < 60; i+=5) {
			minutes.addItem(String.valueOf(i));
		}


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
	
	public HasClickHandlers getEditProfilButton() {

		return EditProfil;
	}
	public HasClickHandlers getLogout() {

		return logout;
	}
	public ListBox getHours() {
		return hours;
	}


	public ListBox getMinutes() {
		return minutes;
	}



}