package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

public class MapViewImpl extends Composite implements MapView {

	interface MyUiBinder extends UiBinder<FlowPanel, MapViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	FlowPanel flowpanel;
	@UiField
	MapWidget mapWidget;
	@UiField
	Button sendAddress;
	@UiField
	TextBox originAddress;
	@UiField
	TextBox destinationAddress;
	@UiField
	HorizontalPanel directionsPanel;
	@UiField
	Button saveJourney;
	@UiField
	DatePicker dateOfJourney;
	@UiField
	RadioButton driverRadioButton;
	@UiField
	RadioButton passengerRadioButton;
	@UiField
	TextBox distanceMax;

	private Presenter presenter;

	public MapViewImpl() {

		initWidget(binder.createAndBindUi(this));
		mapWidget.addControl(new LargeMapControl());
		mapWidget.setCenter(LatLng.newInstance(48, 11), 13);
		driverRadioButton.setText("Driver");
		passengerRadioButton.setText("Passenger");
	}

	@Override
	public RadioButton getPassengerRadioButton() {
		return passengerRadioButton;
	}

	@Override
	public RadioButton getDriverRadioButton() {
		return driverRadioButton;
	}

	@Override
	public DatePicker getDateOfJourney() {
		return dateOfJourney;
	}

	@Override
	public HasClickHandlers getSendAddressButton() {
		return sendAddress;
	}

	@Override
	public String getOriginAddress() {

		return originAddress.getText();
	}

	@Override
	public String getDestinationAddress() {

		return destinationAddress.getText();
	}

	@Override
	public MapWidget getMap() {

		return mapWidget;
	}

	@Override
	public HorizontalPanel getDirectionsPanel() {

		return directionsPanel;
	}

	@Override
	public HasClickHandlers getSaveJourneyButton() {

		return saveJourney;
	}

	@Override
	public float getDistanceMax() {

		return Float.valueOf(distanceMax.getText());
	}

	@Override
	public FlowPanel getMapDecorator() {
		return flowpanel;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public void setOriginAddress(String originAddress) {
		this.originAddress.setText(originAddress);
	}

	@Override
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress.setText(destinationAddress);
	}

}