/*
 * 
 */
package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Interface TravelDetailsView.
 */
public interface TravelDetailsView extends IsWidget {

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public abstract Widget asWidget();

	/**
	 * Sets the presenter.
	 *
	 * @param presenter the new presenter
	 */
	void setPresenter(Presenter presenter);

	/**
	 * The Interface Presenter.
	 */
	public interface Presenter {
		
		/**
		 * Go to.
		 *
		 * @param place the place
		 */
		void goTo(Place place);
	}

	/**
	 * Gets the personal picture.
	 *
	 * @return the personal picture
	 */
	public Image getPersonalPicture();

	/**
	 * Gets the map image.
	 *
	 * @return the map image
	 */
	public Image getMapImage();

	/**
	 * Gets the departure field.
	 *
	 * @return the departure field
	 */
	public TextField<String> getDepartureField();

	/**
	 * Gets the arrival field.
	 *
	 * @return the arrival field
	 */
	public TextField<String> getArrivalField();

	/**
	 * Gets the distance field.
	 *
	 * @return the distance field
	 */
	public TextField<String> getDistanceField();

	/**
	 * Gets the duration field.
	 *
	 * @return the duration field
	 */
	public TextField<String> getDurationField();

	/**
	 * Gets the places field.
	 *
	 * @return the places field
	 */
	public TextField<String> getPlacesField();

	/**
	 * Gets the mark field.
	 *
	 * @return the mark field
	 */
	public Label getMarkField();

	/**
	 * Gets the model field.
	 *
	 * @return the model field
	 */
	public Label getModelField();

	/**
	 * Gets the color field.
	 *
	 * @return the color field
	 */
	public Label getColorField();

	/**
	 * Gets the comfort field.
	 *
	 * @return the comfort field
	 */
	public Label getComfortField();

	/**
	 * Gets the vehicule tab.
	 *
	 * @return the vehicule tab
	 */
	public TabItem getVehiculeTab();

	/**
	 * Sets the personal picture.
	 *
	 * @param personalPicture the new personal picture
	 */
	public void setPersonalPicture(Image personalPicture);

	/**
	 * Sets the map image.
	 *
	 * @param image the new map image
	 */
	public void setMapImage(Image image);
}
