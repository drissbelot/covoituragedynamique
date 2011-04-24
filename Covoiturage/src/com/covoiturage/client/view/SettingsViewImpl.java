package com.covoiturage.client.view;

import com.covoiturage.client.i18n.SettingsViewConstants;
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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SettingsViewImpl extends Composite implements SettingsView {

	interface MyUiBinder extends UiBinder<FlowPanel, SettingsViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private final SettingsViewConstants constants = (SettingsViewConstants) GWT
			.create(SettingsViewConstants.class);

	@UiField
	Button submitButton;
	@UiField
	VerticalPanel flowpanel;
	@UiField
	TextField<String> firstNameField, lastNameField, emailAdressField,
			loginField, passwordField, newpasswordField;
	@UiField
	ComboBox<BaseModelData> language;
	@UiField
	Label Make, Model;
	@UiField
	FormPanel header;

	private Presenter presenter;

	public SettingsViewImpl() {
		initWidget(binder.createAndBindUi(this));
		loginField.setTitle("login=fix");
		header.setHeading(constants.header());
		// Internationalization

		lastNameField.setFieldLabel(constants.lastname());
		firstNameField.setFieldLabel(constants.firstname());
		emailAdressField.setFieldLabel(constants.email());

		newpasswordField.setFieldLabel(constants.password());
		newpasswordField.setPassword(true);
		passwordField.setFieldLabel(constants.password());
		passwordField.setPassword(true);
		Make.setText(constants.make());
		Model.setText(constants.model());
		language.setTemplate(getFlagTemplate());
		submitButton.setText(constants.submit());

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
	public TextField<String> getLogin() {
		return loginField;
	}

	@Override
	public SettingsViewConstants getConstants() {
		return constants;
	}

	private native String getFlagTemplate() /*-{
		return [
				'<tpl for=".">',
				'<div class="x-combo-list-item">{[values.img]} {[values.name]}</div>',
				'</tpl>' ].join("");
	}-*/;
}
