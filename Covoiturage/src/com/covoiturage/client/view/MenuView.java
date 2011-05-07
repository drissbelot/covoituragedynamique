/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.i18n.MenuViewConstants;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;

// TODO: Auto-generated Javadoc
/**
 * The Interface MenuView.
 */
public interface MenuView extends IsWidget {
	
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
	 * Gets the settings label.
	 *
	 * @return the settings label
	 */
	public Label getSettingsLabel();

	/**
	 * Gets the map label.
	 *
	 * @return the map label
	 */
	public Label getMapLabel();

	/**
	 * Gets the history label.
	 *
	 * @return the history label
	 */
	public Label getHistoryLabel();

	/**
	 * Gets the messages label.
	 *
	 * @return the messages label
	 */
	public Label getMessagesLabel();

	/**
	 * Gets the constants.
	 *
	 * @return the constants
	 */
	public MenuViewConstants getConstants();
}
