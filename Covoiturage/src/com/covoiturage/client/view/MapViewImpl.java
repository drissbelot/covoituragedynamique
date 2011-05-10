/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.resource.CovoiturageResources;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentPlugin;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.form.AdapterField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
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
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;

// TODO: Auto-generated Javadoc
/**
 * The Class MapViewImpl.
 */
public class MapViewImpl extends Composite implements MapView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<FlowPanel, MapViewImpl> {
	}

	/** The covoiturage resources. */
	private final CovoiturageResources covoiturageResources = GWT
			.create(CovoiturageResources.class);

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	/** The flowpanel. */
	@UiField
	FlowPanel flowpanel;

	/** The map widget. */
	@UiField(provided = true)
	MapWidget mapWidget;

	/** The save journey. */
	@UiField
	Button sendAddress, saveJourney;

	/** The destination adress. */
	@UiField
	SuggestBox originAdress, destinationAdress;

	/** The directions panel. */
	@UiField
	ContentPanel directionsPanel;

	/** The data. */
	@UiField
	FormPanel data;

	/** The date of journey. */
	@UiField
	DateField dateOfJourney;

	/** The distance max field. */
	@UiField
	TextField<String> departureStartTimeItem, departureEndTimeItem,
			arrivalTimeItem, distanceMaxField;

	/** The passenger radio button. */
	@UiField
	RadioButton driverRadioButton, passengerRadioButton;

	/** The comment field. */
	@UiField
	TextArea commentField;
	@UiField
	AdapterField originField, destinationField;
	/** The duration delta. */
	@UiField
	Label distance, duration, distanceDelta, durationDelta;

	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/**
	 * Instantiates a new map view impl.
	 */
	public MapViewImpl() {
		MapOptions options = new MapOptions();
		options.setCenter(new LatLng(50.6687, 4.57967));
		options.setZoom(12);
		options.setMapTypeId(new MapTypeId().getRoadmap());
		options.setNavigationControl(true);
		options.setDraggable(true);
		options.setMapTypeControl(true);
		options.setScrollwheel(true);
		mapWidget = new MapWidget(options);

		initWidget(binder.createAndBindUi(this));

		dateOfJourney.setData("text", "Field required");
		dateOfJourney.addPlugin(plugin);
	}

	/** The plugin. */
	ComponentPlugin plugin = new ComponentPlugin() {
		@Override
		public void init(Component component) {
			component.addListener(Events.Render,
					new Listener<ComponentEvent>() {
						@Override
						public void handleEvent(ComponentEvent be) {
							El elem = be.getComponent().el()
									.findParent(".x-form-element", 3);

							elem.appendChild(XDOM
									.create("<div style='color: #615f5f;padding: 1 0 2 0px;'>"
											+ be.getComponent().getData("text")
											+ "</div>"));
						}
					});
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getPassengerRadioButton()
	 */
	@Override
	public RadioButton getPassengerRadioButton() {
		return passengerRadioButton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDriverRadioButton()
	 */
	@Override
	public RadioButton getDriverRadioButton() {
		return driverRadioButton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDateOfJourney()
	 */
	@Override
	public DateField getDateOfJourney() {
		return dateOfJourney;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getSendAddressButton()
	 */
	@Override
	public HasClickHandlers getSendAddressButton() {
		return sendAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getOriginAddress()
	 */
	@Override
	public SuggestBox getOriginAddress() {
		return originAdress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDestinationAddress()
	 */
	@Override
	public SuggestBox getDestinationAddress() {
		return destinationAdress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getMap()
	 */
	@Override
	public MapWidget getMap() {
		return mapWidget;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDirectionsPanel()
	 */
	@Override
	public ContentPanel getDirectionsPanel() {
		return directionsPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getSaveJourneyButton()
	 */
	@Override
	public Button getSaveJourneyButton() {
		return saveJourney;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDistanceMax()
	 */
	@Override
	public float getDistanceMax() {
		return Float.valueOf(distanceMaxField.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getMapDecorator()
	 */
	@Override
	public FlowPanel getMapDecorator() {
		return flowpanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.MapView#setPresenter(com.covoiturage.client
	 * .view.MapView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.MapView#setOriginAddress(com.google.gwt.user
	 * .client.ui.SuggestBox)
	 */
	@Override
	public void setOriginAddress(SuggestBox originAddress) {
		this.originAdress = originAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.MapView#setDestinationAddress(java.lang.String
	 * )
	 */
	@Override
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAdress.setText(destinationAddress);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDepartureStartTime()
	 */
	@Override
	public TextField<String> getDepartureStartTime() {
		return departureStartTimeItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getArrivalTime()
	 */
	@Override
	public TextField<String> getArrivalTime() {
		return arrivalTimeItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDepartureEndTime()
	 */
	@Override
	public TextField<String> getDepartureEndTime() {
		return departureEndTimeItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getCommentField()
	 */
	@Override
	public TextArea getCommentField() {
		return commentField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDistance()
	 */
	@Override
	public Label getDistance() {
		return distance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDuration()
	 */
	@Override
	public Label getDuration() {
		return duration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getCovoiturageResources()
	 */
	@Override
	public CovoiturageResources getCovoiturageResources() {
		return covoiturageResources;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getData()
	 */
	@Override
	public FormPanel getData() {
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDistanceDelta()
	 */
	@Override
	public Label getDistanceDelta() {
		return distanceDelta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.MapView#getDurationDelta()
	 */
	@Override
	public Label getDurationDelta() {
		return durationDelta;
	}

	@Override
	public AdapterField getOriginField() {
		return originField;
	}

	@Override
	public AdapterField getDestinationField() {
		return destinationField;
	}

}