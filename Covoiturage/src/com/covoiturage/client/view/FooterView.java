/*
 * 
 */
package com.covoiturage.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.IsWidget;

// TODO: Auto-generated Javadoc
/**
 * The Interface FooterView.
 */
public interface FooterView {

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
	 * Sets the presenter.
	 *
	 * @param presenter the new presenter
	 */
	void setPresenter(Presenter presenter);

	/**
	 * As widget.
	 *
	 * @return the checks if is widget
	 */
	IsWidget asWidget();

	/**
	 * Gets the anchorfr.
	 *
	 * @return the anchorfr
	 */
	public Anchor getAnchorfr();

	/**
	 * Gets the anchornl.
	 *
	 * @return the anchornl
	 */
	public Anchor getAnchornl();

	/**
	 * Gets the anchoren.
	 *
	 * @return the anchoren
	 */
	public Anchor getAnchoren();

	/**
	 * Gets the anchorit.
	 *
	 * @return the anchorit
	 */
	public Anchor getAnchorit();

	/**
	 * Gets the anchorch.
	 *
	 * @return the anchorch
	 */
	public Anchor getAnchorch();
}
