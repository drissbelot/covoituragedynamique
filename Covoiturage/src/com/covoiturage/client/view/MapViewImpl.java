package com.covoiturage.client.view;
import com.covoiturage.client.activity.MapActivity;
import com.covoiturage.client.view.MapView.Presenter;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geocode.DirectionsPanel;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

public class MapViewImpl extends Composite implements  MapView {

	private LayoutPanel mapDecorator;




	private MapWidget mapWidget;
	private Button sendAddress;
	private  TextBox originAddress;
	private  TextBox destinationAddress;
	private VerticalPanel addressPanel;
	private DirectionsPanel directionsPanel;
	private Button saveJourney;
	private DatePicker dateOfJourney;
	private RadioButton driverRadioButton;
	private RadioButton passengerRadioButton;
	private VerticalPanel typeOfUser;
	private TextBox distanceMax;
	private Label labelDistanceMax;




	private Presenter presenter;
	
	public MapViewImpl() {
		mapDecorator = new LayoutPanel();
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
		dateOfJourney= new DatePicker();
		driverRadioButton = new RadioButton("groupTypeOfUser", "Driver");
		passengerRadioButton = new RadioButton("groupTypeOfUser", "Passenger");
		typeOfUser = new VerticalPanel();
		typeOfUser.add(driverRadioButton);
		typeOfUser.add(passengerRadioButton);
		driverRadioButton.setValue(true);
		sendAddress= new Button("Locate");
		saveJourney = new Button("Save journey");
		distanceMax= new TextBox();
		distanceMax.setText("0");
		labelDistanceMax = new Label("Distance maximale");


		directionsPanel = new DirectionsPanel();


		addressPanel.add(originAddress);
		addressPanel.add(destinationAddress);
		addressPanel.add(sendAddress);



		mapDecorator.add(mapWidget);
		mapDecorator.add(addressPanel);
		mapDecorator.add(dateOfJourney);
		mapDecorator.add(typeOfUser);
		mapDecorator.add(labelDistanceMax);
		mapDecorator.add(distanceMax);
		
		mapDecorator.add(saveJourney);
		mapDecorator.add(directionsPanel);
	}


	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getPassengerRadioButton()
	 */
	@Override
	public RadioButton getPassengerRadioButton() {
		return passengerRadioButton;
	}


	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getDriverRadioButton()
	 */
	@Override
	public RadioButton getDriverRadioButton() {
		return driverRadioButton;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getDateOfJourney()
	 */
	@Override
	public DatePicker getDateOfJourney() {
		return dateOfJourney;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getSendAddressButton()
	 */
	@Override
	public HasClickHandlers getSendAddressButton() {
		return sendAddress;
	}




	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getOriginAddress()
	 */
	@Override
	public String getOriginAddress() {

		return originAddress.getText();
	}
	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getDestinationAddress()
	 */
	@Override
	public String getDestinationAddress() {

		return destinationAddress.getText();
	}



	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getMap()
	 */
	@Override
	public MapWidget getMap() {

		return mapWidget;
	}


	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getDirectionsPanel()
	 */
	@Override
	public DirectionsPanel getDirectionsPanel() {

		return directionsPanel;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getSaveJourneyButton()
	 */
	@Override
	public HasClickHandlers getSaveJourneyButton() {

		return saveJourney;
	}



	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getDistanceMax()
	 */
	@Override
	public float getDistanceMax() {

		return Float.valueOf(distanceMax.getText());
	}
	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MapView#getMapDecorator()
	 */
	@Override
	public LayoutPanel getMapDecorator() {
		return mapDecorator;
	}


	@Override
	public void setPresenter(Presenter presenter) {
			this.presenter=presenter;
		
	}

}