package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;
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
	SuggestBox originAddress;
	@UiField
	SuggestBox destinationAddress;
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
	@UiField
	Anchor EditProfil;
	@UiField
	Anchor logout;

	private Presenter presenter;

	public MapViewImpl() {
		initWidget(binder.createAndBindUi(this));
		mapWidget.addControl(new LargeMapControl());
		mapWidget.setCenter(LatLng.newInstance(48, 11), 13);
		driverRadioButton.setText("Driver");
		passengerRadioButton.setText("Passenger");

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
	

}