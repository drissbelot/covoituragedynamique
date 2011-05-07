/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.i18n.HeaderViewConstants;
import com.extjs.gxt.ui.client.widget.Label;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

// TODO: Auto-generated Javadoc
/**
 * The Interface HeaderView.
 */
public interface HeaderView extends IsWidget {
	
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
	 * Gets the logout.
	 *
	 * @return the logout
	 */
	public HasClickHandlers getLogout();

	/**
	 * Gets the current user.
	 *
	 * @return the current user
	 */
	public Label getCurrentUser();

	/**
	 * Gets the messages.
	 *
	 * @return the messages
	 */
	public Label getMessages();

	/**
	 * Gets the constants.
	 *
	 * @return the constants
	 */
	public HeaderViewConstants getConstants();
}
