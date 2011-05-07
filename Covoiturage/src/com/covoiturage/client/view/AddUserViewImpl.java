/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class AddUserViewImpl.
 */
public class AddUserViewImpl extends Composite implements AddUserView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<FlowPanel, AddUserViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	/** The constants. */
	private final AddUserViewConstants constants = (AddUserViewConstants) GWT
			.create(AddUserViewConstants.class);
	
	/** The add button. */
	@UiField
	Button addButton;
	
	/** The login field. */
	@UiField
	TextField<String> firstNameField, lastNameField, emailAdressField,
			loginField;
	
	/** The password field. */
	@UiField
	TextField<String> passwordField;

	/**
	 * Instantiates a new adds the user view impl.
	 */
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

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#getFirstName()
	 */
	@Override
	public TextField<String> getFirstName() {
		return firstNameField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#getLastName()
	 */
	@Override
	public TextField<String> getLastName() {
		return lastNameField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#getEmailAddress()
	 */
	@Override
	public TextField<String> getEmailAddress() {
		return emailAdressField;
	}

	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#getAddUserButton()
	 */
	@Override
	public HasClickHandlers getAddUserButton() {
		return addButton;
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return this;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#getAddButton()
	 */
	@Override
	public HasClickHandlers getAddButton() {
		return addButton;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#getPassword()
	 */
	@Override
	public TextField<String> getPassword() {
		return passwordField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#getLogin()
	 */
	@Override
	public TextField<String> getLogin() {
		return loginField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#setPresenter(com.covoiturage.client.view.AddUserView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView#getConstants()
	 */
	@Override
	public AddUserViewConstants getConstants() {
		return constants;
	}

}
