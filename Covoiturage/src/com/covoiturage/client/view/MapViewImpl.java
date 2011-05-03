package com.covoiturage.client.view;

import com.covoiturage.client.images.CovoiturageResources;
import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ComponentPlugin;
import com.extjs.gxt.ui.client.widget.ContentPanel;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;

public class MapViewImpl extends Composite implements MapView {

	interface MyUiBinder extends UiBinder<FlowPanel, MapViewImpl> {
	}

	private final CovoiturageResources covoiturageResources = GWT
			.create(CovoiturageResources.class);
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	FlowPanel flowpanel;
	@UiField(provided = true)
	MapWidget mapWidget;
	@UiField
	Button sendAddress, saveJourney;
	@UiField
	SuggestBox originAdress, destinationAdress;
	@UiField
	ContentPanel directionsPanel;

	@UiField
	Label to, from;
	@UiField
	FormPanel data;
	@UiField
	DateField dateOfJourney;
	@UiField
	TextField<String> departureStartTimeItem, departureEndTimeItem,
			arrivalTimeItem, distanceMaxField;
	@UiField
	RadioButton driverRadioButton, passengerRadioButton;
	@UiField
	TextArea commentField;
	@UiField
	com.extjs.gxt.ui.client.widget.Label distance, duration;

	@SuppressWarnings("unused")
	private Presenter presenter;

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

		// TODO on doit pouvoir mettre  ca dans l'uibinder aussi ---> je ne sais pas comment on fait pr le dernier
		dateOfJourney.setData("text", "Field required");
		dateOfJourney.addPlugin(plugin);
	}

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

	@Override
	public RadioButton getPassengerRadioButton() {
		return passengerRadioButton;
	}

	@Override
	public RadioButton getDriverRadioButton() {
		return driverRadioButton;
	}

	@Override
	public DateField getDateOfJourney() {
		return dateOfJourney;
	}

	@Override
	public HasClickHandlers getSendAddressButton() {
		return sendAddress;
	}

	@Override
	public SuggestBox getOriginAddress() {
		return originAdress;
	}

	@Override
	public SuggestBox getDestinationAddress() {
		return destinationAdress;
	}

	@Override
	public MapWidget getMap() {
		return mapWidget;
	}

	@Override
	public ContentPanel getDirectionsPanel() {
		return directionsPanel;
	}

	@Override
	public Button getSaveJourneyButton() {
		return saveJourney;
	}

	@Override
	public float getDistanceMax() {
		return Float.valueOf(distanceMaxField.getValue());
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
	public void setOriginAddress(SuggestBox originAddress) {
		this.originAdress = originAddress;
	}

	@Override
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAdress.setText(destinationAddress);
	}

	@Override
	public TextField<String> getDepartureStartTime() {
		return departureStartTimeItem;
	}

	@Override
	public TextField<String> getArrivalTime() {
		return arrivalTimeItem;
	}

	@Override
	public TextField<String> getDepartureEndTime() {
		return departureEndTimeItem;
	}

	@Override
	public TextArea getCommentField() {
		return commentField;
	}

	@Override
	public com.extjs.gxt.ui.client.widget.Label getDistance() {
		return distance;
	}

	@Override
	public com.extjs.gxt.ui.client.widget.Label getDuration() {
		return duration;
	}

	@Override
	public CovoiturageResources getCovoiturageResources() {
		return covoiturageResources;
	}

	@Override
	public FormPanel getData() {
		return data;
	}

}