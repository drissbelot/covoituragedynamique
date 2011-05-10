/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.i18n.SettingsViewConstants;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FileUploadField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class SettingsViewImpl.
 */
public class SettingsViewImpl extends Composite implements SettingsView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<FlowPanel, SettingsViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	/** The constants. */
	private final SettingsViewConstants constants = (SettingsViewConstants) GWT
			.create(SettingsViewConstants.class);

	/** The submit button. */
	@UiField
	Button submitButton;

	/** The newpassword field. */
	@UiField
	TextField<String> firstNameField, lastNameField, emailAdressField,
			passwordField, newpasswordField;

	/** The language. */
	@UiField
	ComboBox<BaseModelData> language;

	/** The vehicle model field. */
	@UiField
	ComboBox<BaseModelData> vehicleMakeField, vehicleModelField;

	/** The vehicle date field. */
	@UiField
	TextField<String> vehicleDateField;

	/** The comfort field. */
	@UiField
	ComboBox<BaseModelData> comfortField;

	/** The car color field. */
	@UiField
	ComboBox<BaseModelData> carColorField;

	/** The seats number field. */
	@UiField
	TextField<Integer> seatsNumberField;

	/** The emissions c o2 field. */
	@UiField
	TextField<Float> emissionsCO2Field;

	/** The fuel mixed drive field. */
	@UiField
	TextField<Float> fuelMixedDriveField;

	/** The work phone number field. */
	@UiField
	TextField<String> mobilePhoneNumberField, homePhoneNumberField,
			workPhoneNumberField;
	@UiField
	FileUploadField personalImageField;
	@UiField
	FormPanel imageForm;
	/** The presenter. */
	private Presenter presenter;

	/**
	 * Instantiates a new settings view impl.
	 */
	public SettingsViewImpl() {
		initWidget(binder.createAndBindUi(this));

		language.setTemplate(getTemplate());
		comfortField.setTemplate(getTemplate());
		carColorField.setTemplate(getTemplate());
		vehicleMakeField.setTypeAhead(true);
		vehicleModelField.setTypeAhead(true);

		emailAdressField
				.setRegex("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
		passwordField.setMinLength(4);
		homePhoneNumberField.setRegex("\\d+");
		mobilePhoneNumberField.setRegex("\\d+");
		workPhoneNumberField.setRegex("\\d+");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getSubmitButton()
	 */
	@Override
	public HasClickHandlers getSubmitButton() {
		return submitButton;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.SettingsView#setPresenter(com.covoiturage
	 * .client.view.SettingsView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getFirstName()
	 */
	@Override
	public TextField<String> getFirstName() {
		return firstNameField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getLastName()
	 */
	@Override
	public TextField<String> getLastName() {
		return lastNameField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getNewPassword()
	 */
	@Override
	public TextField<String> getNewPassword() {
		return newpasswordField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getLanguage()
	 */
	@Override
	public ComboBox<BaseModelData> getLanguage() {
		return language;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getEmailAddress()
	 */
	@Override
	public TextField<String> getEmailAddress() {
		return emailAdressField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getPassword()
	 */
	@Override
	public TextField<String> getPassword() {
		return passwordField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getConstants()
	 */
	@Override
	public SettingsViewConstants getConstants() {
		return constants;
	}

	/**
	 * Gets the template.
	 * 
	 * @return the template
	 */
	private native String getTemplate() /*-{
		return [
				'<tpl for=".">',
				'<div class="x-combo-list-item">{[values.img]} {[values.name]}</div>',
				'</tpl>' ].join("");
	}-*/;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getVehicleMake()
	 */
	@Override
	public ComboBox<BaseModelData> getVehicleMake() {
		return vehicleMakeField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getVehicleModel()
	 */
	@Override
	public ComboBox<BaseModelData> getVehicleModel() {

		return vehicleModelField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getSeatsNumberField()
	 */
	@Override
	public TextField<Integer> getSeatsNumberField() {
		return seatsNumberField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getEmissionsCO2Field()
	 */
	@Override
	public TextField<Float> getEmissionsCO2Field() {
		return emissionsCO2Field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getFuelMixedDriveField()
	 */
	@Override
	public TextField<Float> getFuelMixedDriveField() {
		return fuelMixedDriveField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getComfortField()
	 */
	@Override
	public ComboBox<BaseModelData> getComfortField() {
		return comfortField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.covoiturage.client.view.SettingsView#getCarColorField()
	 */
	@Override
	public ComboBox<BaseModelData> getCarColorField() {
		return carColorField;
	}

	@Override
	public FileUploadField getPersonalImageField() {
		return personalImageField;
	}

	@Override
	public FormPanel getImageForm() {
		return imageForm;
	}

}
