package com.covoiturage.client.view;

import com.covoiturage.client.i18n.SettingsViewConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SettingsViewImpl extends Composite implements  SettingsView{
	
	interface MyUiBinder extends UiBinder<FlowPanel, SettingsViewImpl> { }
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private SettingsViewConstants constants=(SettingsViewConstants)GWT.create(SettingsViewConstants.class);
	//TODO conventions de nommage !!!!!!!!!
	@UiField Button submitButton;
	@UiField VerticalPanel flowpanel;
	@UiField TextBox firstName,lastName,emailAddress;


	@UiField PasswordTextBox prevpassword,newPassword;
	@UiField ListBox language;
	@UiField Label header,usernamefix,username,lastname,firstname,email,prevpasswordlab,newpasswordlab,languelab;
	@SuppressWarnings("unused")
	private Presenter presenter; 
	
	public SettingsViewImpl(){
		initWidget(binder.createAndBindUi(this));
		usernamefix.setText("login=fix");
		
		//Internationalization
		header.setText(constants.header()+" :");
		username.setText(constants.username()+" :");
		lastname.setText(constants.lastname()+" :");
		lastName.setText(constants.lastname());
		firstname.setText(constants.firstname()+" :");
		firstName.setText(constants.firstname());
		email.setText(constants.email()+" :");
		emailAddress.setText(constants.email());
		prevpasswordlab.setText(constants.prevpasswordlab()+" :");
		prevpassword.setText(constants.password());
		newpasswordlab.setText(constants.newpasswordlab()+" :");
		newPassword.setText(constants.password());
		languelab.setText(constants.languelab()+" :");
		language.addItem(constants.fr());
		language.addItem(constants.en());
		language.addItem(constants.nl());
		language.addItem(constants.it());
		language.addItem(constants.ch());
		submitButton.setText(constants.submit());
		
	}
	
	public HasClickHandlers getSubmitButton() {

		return submitButton;
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	public TextBox getFirstName() {
		return firstName;
	}

	public TextBox getLastName() {
		return lastName;
	}

	public PasswordTextBox getNewPassword() {
		return newPassword;
	}

	public ListBox getLanguage() {
		return language;
	}

	public TextBox getEmailAddress() {
		return emailAddress;
	}

}
