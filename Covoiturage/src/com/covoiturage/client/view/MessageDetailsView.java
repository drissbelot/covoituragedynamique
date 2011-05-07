/*
 * 
 */
package com.covoiturage.client.view;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageDetailsView.
 */
public interface MessageDetailsView extends IsWidget {
	
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
	 * Gets the subject label.
	 *
	 * @return the subject label
	 */
	public Label getSubjectLabel();

	/**
	 * Gets the from label.
	 *
	 * @return the from label
	 */
	public Label getFromLabel();

	/**
	 * Gets the date label.
	 *
	 * @return the date label
	 */
	public Label getDateLabel();

	/**
	 * Gets the message text.
	 *
	 * @return the message text
	 */
	public TextArea getMessageText();

	/**
	 * Gets the answer button.
	 *
	 * @return the answer button
	 */
	public com.google.gwt.user.client.ui.Button getAnswerButton();
}
