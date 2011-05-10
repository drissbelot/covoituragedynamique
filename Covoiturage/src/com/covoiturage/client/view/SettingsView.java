/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.i18n.SettingsViewConstants;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Interface SettingsView.
 */
public interface SettingsView extends IsWidget {

	/**
	 * Gets the submit button.
	 * 
	 * @return the submit button
	 */
	public abstract HasClickHandlers getSubmitButton();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public abstract Widget asWidget();

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
	 * Gets the new password.
	 * 
	 * @return the new password
	 */
	public TextField<String> getNewPassword();

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
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public abstract ComboBox<BaseModelData> getLanguage();

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public TextField<String> getPassword();

	/**
	 * Gets the constants.
	 * 
	 * @return the constants
	 */
	public SettingsViewConstants getConstants();

	/**
	 * Gets the vehicle make.
	 * 
	 * @return the vehicle make
	 */
	public ComboBox<BaseModelData> getVehicleMake();

	/**
	 * Gets the vehicle model.
	 * 
	 * @return the vehicle model
	 */
	public ComboBox<BaseModelData> getVehicleModel();

	/**
	 * Gets the seats number field.
	 * 
	 * @return the seats number field
	 */
	public TextField<Integer> getSeatsNumberField();

	/**
	 * Gets the emissions c o2 field.
	 * 
	 * @return the emissions c o2 field
	 */
	public TextField<Float> getEmissionsCO2Field();

	/**
	 * Gets the fuel mixed drive field.
	 * 
	 * @return the fuel mixed drive field
	 */
	public TextField<Float> getFuelMixedDriveField();

	/**
	 * Gets the comfort field.
	 * 
	 * @return the comfort field
	 */
	public ComboBox<BaseModelData> getComfortField();

	/**
	 * Gets the car color field.
	 * 
	 * @return the car color field
	 */
	public ComboBox<BaseModelData> getCarColorField();

	public FileUploadField getPersonalImageField();

	public FormPanel getImageForm();
}
