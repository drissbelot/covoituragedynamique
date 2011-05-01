package com.covoiturage.client.view;

import com.covoiturage.client.i18n.AddUserViewConstants;
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
	Button addButton;
	@UiField
	TextField<String> firstNameField, lastNameField, emailAdressField,
			loginField;
	@UiField
	TextField<String> passwordField;

	public AddUserViewImpl() {

		initWidget(binder.createAndBindUi(this));
		loginField.setAllowBlank(false);
		loginField.setMinLength(4);
		passwordField.setPassword(true);
		passwordField.setMinLength(4);
		firstNameField.setAllowBlank(false);
		lastNameField.setAllowBlank(false);
		emailAdressField.setAllowBlank(false);
		emailAdressField
				.setRegex("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");

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

	@SuppressWarnings("unused")
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
	public AddUserViewConstants getConstants() {
		return constants;
	}

}
