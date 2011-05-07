/*
 * 
 */
package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;

import com.google.gwt.user.client.ui.IsWidget;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoginView.
 */
public interface LoginView extends IsWidget {

	/**
	 * Gets the send login button.
	 *
	 * @return the send login button
	 */
	public abstract HasClickHandlers getSendLoginButton();

	/**
	 * Gets the adds the user button.
	 *
	 * @return the adds the user button
	 */
	public abstract HasClickHandlers getAddUserButton();

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

}