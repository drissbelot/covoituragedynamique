package com.covoiturage.client.view;

import com.covoiturage.client.i18n.SettingsViewConstants;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class SettingsViewImpl extends Composite implements SettingsView {

	interface MyUiBinder extends UiBinder<FlowPanel, SettingsViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private final SettingsViewConstants constants = (SettingsViewConstants) GWT
			.create(SettingsViewConstants.class);

	@UiField
	Button submitButton;
	@UiField
	TextField<String> firstNameField, lastNameField, emailAdressField,
			passwordField, newpasswordField;
	@UiField
	ComboBox<BaseModelData> language;
	@UiField
	ComboBox<BaseModelData> vehicleMakeField, vehicleModelField;
	@UiField
	TextField<String> vehicleDateField;
	@UiField
	ComboBox<BaseModelData> comfortField;
	@UiField
	ComboBox<BaseModelData> carColorField;
	@UiField
	TextField<Integer> seatsNumberField;
	@UiField
	TextField<Float> emissionsCO2Field;
	@UiField
	TextField<Float> fuelMixedDriveField;
	@UiField
	TextField<String> mobilePhoneNumberField, homePhoneNumberField,
			workPhoneNumberField;

	private Presenter presenter;

	public SettingsViewImpl() {
		initWidget(binder.createAndBindUi(this));

		language.setTemplate(getTemplate());
		comfortField.setTemplate(getTemplate());
		carColorField.setTemplate(getCarTemplate());
		vehicleMakeField.setTypeAhead(true);
		vehicleModelField.setTypeAhead(true);

		emailAdressField
				.setRegex("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
		passwordField.setMinLength(4);
		homePhoneNumberField.setRegex("\\d+");
		mobilePhoneNumberField.setRegex("\\d+");
		workPhoneNumberField.setRegex("\\d+");

	}

	@Override
	public HasClickHandlers getSubmitButton() {
		return submitButton;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public TextField<String> getFirstName() {
		return firstNameField;
	}

	@Override
	public TextField<String> getLastName() {
		return lastNameField;
	}

	@Override
	public TextField<String> getNewPassword() {
		return newpasswordField;
	}

	@Override
	public ComboBox<BaseModelData> getLanguage() {
		return language;
	}

	@Override
	public TextField<String> getEmailAddress() {
		return emailAdressField;
	}

	@Override
	public TextField<String> getPassword() {
		return passwordField;
	}

	@Override
	public SettingsViewConstants getConstants() {
		return constants;
	}

	private native String getTemplate() /*-{
		return [
				'<tpl for=".">',
				'<div class="x-combo-list-item">{[values.img]} {[values.name]}</div>',
				'</tpl>' ].join("");
	}-*/;

	private native String getCarTemplate() /*-{
		return [ '<tpl for=".">',
				'<div class="x-combo-list-item">{[values.img]}</div>', '</tpl>' ]
				.join("");
	}-*/;

	@Override
	public ComboBox<BaseModelData> getVehicleMake() {
		return vehicleMakeField;
	}

	@Override
	public ComboBox<BaseModelData> getVehicleModel() {

		return vehicleModelField;
	}

	@Override
	public TextField<Integer> getSeatsNumberField() {
		return seatsNumberField;
	}

	@Override
	public TextField<Float> getEmissionsCO2Field() {
		return emissionsCO2Field;
	}

	@Override
	public TextField<Float> getFuelMixedDriveField() {
		return fuelMixedDriveField;
	}

	@Override
	public ComboBox<BaseModelData> getComfortField() {
		return comfortField;
	}

	@Override
	public ComboBox<BaseModelData> getCarColorField() {
		return carColorField;
	}
}
