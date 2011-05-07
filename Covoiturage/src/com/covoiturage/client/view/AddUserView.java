/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.i18n.AddUserViewConstants;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Interface AddUserView.
 */
public interface AddUserView extends IsWidget {

	/**
	 * Gets the adds the user button.
	 *
	 * @return the adds the user button
	 */
	public abstract HasClickHandlers getAddUserButton();

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public abstract Widget asWidget();

	/**
	 * Gets the adds the button.
	 *
	 * @return the adds the button
	 */
	public abstract HasClickHandlers getAddButton();

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
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public TextField<String> getFirstName();

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public TextField<String> getLastName();

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public TextField<String> getEmailAddress();

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public TextField<String> getPassword();

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public TextField<String> getLogin();

	/**
	 * Gets the constants.
	 *
	 * @return the constants
	 */
	public AddUserViewConstants getConstants();

}