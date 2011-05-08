/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.images.CovoiturageResources;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.form.AdapterField;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SuggestBox;

// TODO: Auto-generated Javadoc
/**
 * The Interface MapView.
 */
public interface MapView extends IsWidget {

	/**
	 * Gets the passenger radio button.
	 * 
	 * @return the passenger radio button
	 */
	public RadioButton getPassengerRadioButton();

	/**
	 * Gets the driver radio button.
	 * 
	 * @return the driver radio button
	 */
	public RadioButton getDriverRadioButton();

	/**
	 * Gets the date of journey.
	 * 
	 * @return the date of journey
	 */
	public DateField getDateOfJourney();

	/**
	 * Gets the send address button.
	 * 
	 * @return the send address button
	 */
	public HasClickHandlers getSendAddressButton();

	/**
	 * Gets the origin address.
	 * 
	 * @return the origin address
	 */
	public SuggestBox getOriginAddress();

	/**
	 * Gets the destination address.
	 * 
	 * @return the destination address
	 */
	public SuggestBox getDestinationAddress();

	/**
	 * Gets the map.
	 * 
	 * @return the map
	 */
	public MapWidget getMap();

	/**
	 * Gets the directions panel.
	 * 
	 * @return the directions panel
	 */
	public ContentPanel getDirectionsPanel();

	/**
	 * Gets the save journey button.
	 * 
	 * @return the save journey button
	 */
	public Button getSaveJourneyButton();

	/**
	 * Gets the distance max.
	 * 
	 * @return the distance max
	 */
	public float getDistanceMax();

	/**
	 * Gets the map decorator.
	 * 
	 * @return the map decorator
	 */
	public FlowPanel getMapDecorator();

	/**
	 * Sets the presenter.
	 * 
	 * @param presenter
	 *            the new presenter
	 */
	void setPresenter(Presenter presenter);

	/**
	 * The Interface Presenter.
	 */
	public interface Presenter {

		/**
		 * Go to.
		 * 
		 * @param place
		 *            the place
		 */
		void goTo(Place place);
	}

	/**
	 * Sets the origin address.
	 * 
	 * @param suggestBox
	 *            the new origin address
	 */
	public void setOriginAddress(SuggestBox suggestBox);

	/**
	 * Sets the destination address.
	 * 
	 * @param destinationAddress
	 *            the new destination address
	 */
	public void setDestinationAddress(String destinationAddress);

	/**
	 * Gets the departure start time.
	 * 
	 * @return the departure start time
	 */
	public TextField<String> getDepartureStartTime();

	/**
	 * Gets the departure end time.
	 * 
	 * @return the departure end time
	 */
	public TextField<String> getDepartureEndTime();

	/**
	 * Gets the arrival time.
	 * 
	 * @return the arrival time
	 */
	public TextField<String> getArrivalTime();

	/**
	 * Gets the comment field.
	 * 
	 * @return the comment field
	 */
	public TextArea getCommentField();

	/**
	 * Gets the distance.
	 * 
	 * @return the distance
	 */
	public Label getDistance();

	/**
	 * Gets the duration.
	 * 
	 * @return the duration
	 */
	public Label getDuration();

	/**
	 * Gets the covoiturage resources.
	 * 
	 * @return the covoiturage resources
	 */
	public CovoiturageResources getCovoiturageResources();

	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public FormPanel getData();

	/**
	 * Gets the distance delta.
	 * 
	 * @return the distance delta
	 */
	public Label getDistanceDelta();

	/**
	 * Gets the duration delta.
	 * 
	 * @return the duration delta
	 */
	public Label getDurationDelta();

	public AdapterField getOriginField();

	public AdapterField getDestinationField();

}