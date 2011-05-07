/*
 * 
 */
package com.covoiturage.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RadioButton;

// TODO: Auto-generated Javadoc
/**
 * The Interface LicenceView.
 */
public interface LicenceView {

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
	 * Gets the radio accepted.
	 *
	 * @return the radio accepted
	 */
	public RadioButton getRadioAccepted();
	
	/**
	 * Gets the radio denied.
	 *
	 * @return the radio denied
	 */
	public RadioButton getRadioDenied();
	
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public HasClickHandlers getNext();
	
	/**
	 * Sets the presenter.
	 *
	 * @param presenter the new presenter
	 */
	public void setPresenter(Presenter presenter);
	
	/**
	 * As widget.
	 *
	 * @return the checks if is widget
	 */
	public IsWidget asWidget();
	
}