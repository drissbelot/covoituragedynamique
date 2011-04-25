package com.covoiturage.client.view;

import com.covoiturage.client.i18n.AddUserViewConstants;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class AddUserViewImpl extends Composite implements AddUserView {

	interface MyUiBinder extends UiBinder<FlowPanel, AddUserViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private final AddUserViewConstants constants = (AddUserViewConstants) GWT
			.create(AddUserViewConstants.class);

	@UiField
	FlowPanel flowpanel;
	@UiField
	Button addButton;
	@UiField
	TextField<String> firstNameField, lastNameField, emailAdressField,
			loginField;
	@UiField
	TextField<String> passwordField;
	@UiField
	ComboBox<BaseModelData> vehicleMakeField, vehicleModelField;
	@UiField
	ComboBox<BaseModelData> language;

	@UiField
	FormPanel header;
	@UiField
	TextField<Integer> seatsNumberField;
	@UiField
	TextField<Float> emissionsCO2Field;
	@UiField
	TextField<Float> fuelMixedDriveField;

	public AddUserViewImpl() {

		initWidget(binder.createAndBindUi(this));
		header.setHeading(constants.header());
		loginField.setFieldLabel(constants.username());
		lastNameField.setFieldLabel(constants.lastname());
		firstNameField.setFieldLabel(constants.firstname());
		emailAdressField.setFieldLabel(constants.email());
		passwordField.setFieldLabel(constants.password());
		passwordField.setPassword(true);

		language.setTemplate(getFlagTemplate());
		addButton.setText(constants.add());
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
	public TextField<String> getEmailAddress() {
		return emailAdressField;
	}

	private Presenter presenter;

	@Override
	public HasClickHandlers getAddUserButton() {
		return addButton;
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public HasClickHandlers getAddButton() {
		return addButton;
	}

	@Override
	public TextField<String> getPassword() {
		return passwordField;
	}

	@Override
	public TextField<String> getLogin() {
		return loginField;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public ComboBox<BaseModelData> getVehicleMake() {
		return vehicleMakeField;
	}

	@Override
	public ComboBox<BaseModelData> getVehicleModel() {

		return vehicleModelField;
	}

	@Override
	public ComboBox<BaseModelData> getLanguage() {

		return language;
	}

	@Override
	public AddUserViewConstants getConstants() {
		return constants;
	}

	private native String getFlagTemplate() /*-{
		return [
				'<tpl for=".">',
				'<div class="x-combo-list-item">{[values.img]} {[values.name]}</div>',
				'</tpl>' ].join("");
	}-*/;

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
}
