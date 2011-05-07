/*
 * 
 */
package com.covoiturage.client.view;

import com.covoiturage.client.images.CovoiturageResources;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginViewImpl.
 */
public class LoginViewImpl extends Composite implements LoginView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<AbsolutePanel, LoginViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	/** The covoiturage resources. */
	private final CovoiturageResources covoiturageResources = GWT
			.create(CovoiturageResources.class);
	
	/** The password field. */
	@UiField
	TextField<String> loginField, passwordField;
	
	/** The title. */
	@UiField
	Label title;
	
	/** The send button. */
	@UiField
	Button addUserButton, sendButton;
	
	/** The image. */
	@UiField
	Image image;
	
	/** The flowpanel. */
	@UiField
	AbsolutePanel flowpanel;
	
	/** The header. */
	@UiField
	FormPanel header;

	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/**
	 * Instantiates a new login view impl.
	 */
	public LoginViewImpl() {

		initWidget(binder.createAndBindUi(this));
		passwordField.setPassword(true);
		image.setResource(covoiturageResources.taxi());
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LoginView#getSendLoginButton()
	 */
	@Override
	public HasClickHandlers getSendLoginButton() {
		return sendButton;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LoginView#getAddUserButton()
	 */
	@Override
	public HasClickHandlers getAddUserButton() {
		return addUserButton;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LoginView#getPassword()
	 */
	@Override
	public TextField<String> getPassword() {
		return passwordField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LoginView#getLogin()
	 */
	@Override
	public TextField<String> getLogin() {
		return loginField;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.LoginView#setPresenter(com.covoiturage.client.view.LoginView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/**
	 * On add user button click.
	 *
	 * @param event the event
	 */
	@UiHandler("addUserButton")
	void onAddUserButtonClick(ClickEvent event) {
	}
}