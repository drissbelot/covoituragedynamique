/*
 * 
 */
package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class TravelDetailsViewImpl.
 */
public class TravelDetailsViewImpl extends Composite implements
		TravelDetailsView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<VerticalPanel, TravelDetailsViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	/** The map image. */
	@UiField
	Image personalPicture, mapImage;
	
	/** The comment. */
	@UiField
	TextArea comment;
	
	/** The places field. */
	@UiField
	TextField<String> departureField, arrivalField, distanceField,
			durationField, placesField;
	
	/** The comfort field. */
	@UiField
	Label markField, modelField, colorField, comfortField;
	
	/** The vehicule tab. */
	@UiField
	TabItem vehiculeTab;
	
	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/**
	 * Instantiates a new travel details view impl.
	 */
	public TravelDetailsViewImpl() {
		initWidget(binder.createAndBindUi(this));

	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#setPresenter(com.covoiturage.client.view.TravelDetailsView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getPersonalPicture()
	 */
	@Override
	public Image getPersonalPicture() {
		return personalPicture;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getMapImage()
	 */
	@Override
	public Image getMapImage() {
		return mapImage;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getDepartureField()
	 */
	@Override
	public TextField<String> getDepartureField() {
		return departureField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getArrivalField()
	 */
	@Override
	public TextField<String> getArrivalField() {
		return arrivalField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getDistanceField()
	 */
	@Override
	public TextField<String> getDistanceField() {
		return distanceField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getDurationField()
	 */
	@Override
	public TextField<String> getDurationField() {
		return durationField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getPlacesField()
	 */
	@Override
	public TextField<String> getPlacesField() {
		return placesField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getMarkField()
	 */
	@Override
	public Label getMarkField() {
		return markField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getModelField()
	 */
	@Override
	public Label getModelField() {
		return modelField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getColorField()
	 */
	@Override
	public Label getColorField() {
		return colorField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getComfortField()
	 */
	@Override
	public Label getComfortField() {
		return comfortField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#getVehiculeTab()
	 */
	@Override
	public TabItem getVehiculeTab() {
		return vehiculeTab;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#setPersonalPicture(com.google.gwt.user.client.ui.Image)
	 */
	@Override
	public void setPersonalPicture(Image personalPicture) {
		this.personalPicture = personalPicture;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.TravelDetailsView#setMapImage(com.google.gwt.user.client.ui.Image)
	 */
	@Override
	public void setMapImage(Image mapImage) {
		this.mapImage = mapImage;
	}

}
