package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextArea;

public class TravelDetailsViewImpl extends Composite implements
		TravelDetailsView {

	interface MyUiBinder extends UiBinder<FlowPanel, TravelDetailsViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	Image personalPicture, mapImage;
	@UiField
	TextArea comment;
	@UiField
	TextField<String> departureField, arrivalField, distanceField,
			durationField, placesField;
	@UiField
	Label markField, modelField, colorField, comfortField;
	@UiField
	TabItem vehiculeTab;
	@SuppressWarnings("unused")
	private Presenter presenter;

	public TravelDetailsViewImpl() {
		initWidget(binder.createAndBindUi(this));

	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Image getPersonalPicture() {
		return personalPicture;
	}

	@Override
	public Image getMapImage() {
		return mapImage;
	}

	@Override
	public TextField<String> getDepartureField() {
		return departureField;
	}

	@Override
	public TextField<String> getArrivalField() {
		return arrivalField;
	}

	@Override
	public TextField<String> getDistanceField() {
		return distanceField;
	}

	@Override
	public TextField<String> getDurationField() {
		return durationField;
	}

	@Override
	public TextField<String> getPlacesField() {
		return placesField;
	}

	@Override
	public Label getMarkField() {
		return markField;
	}

	@Override
	public Label getModelField() {
		return modelField;
	}

	@Override
	public Label getColorField() {
		return colorField;
	}

	@Override
	public Label getComfortField() {
		return comfortField;
	}

	@Override
	public TabItem getVehiculeTab() {
		return vehiculeTab;
	}

	@Override
	public void setPersonalPicture(Image personalPicture) {
		this.personalPicture = personalPicture;
	}

	@Override
	public void setMapImage(Image mapImage) {
		this.mapImage = mapImage;
	}

}
