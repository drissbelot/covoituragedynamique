package com.covoiturage.client.view;

import com.covoiturage.client.i18n.SettingsViewConstants;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SettingsViewImpl extends Composite implements  SettingsView{
	
	interface MyUiBinder extends UiBinder<FlowPanel, SettingsViewImpl> { }
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private SettingsViewConstants constants=(SettingsViewConstants)GWT.create(SettingsViewConstants.class);
	
	//TODO conventions de nommage !!!!!!!!!
	//TODO étendre adduserview... c'est un peu du copier-coller inutile là
	
	@UiField Button submitButton;
	@UiField VerticalPanel flowpanel;
	@UiField TextField<String> firstNameField,lastNameField,emailAdressField,loginField,passwordField,newpasswordField;
	@UiField ListBox language;
	@UiField Label header,Make,Model;
	
	@SuppressWarnings("unused")
	private Presenter presenter; 
	
	public SettingsViewImpl(){
		initWidget(binder.createAndBindUi(this));
		loginField.setTitle("login=fix");
		
		//Internationalization
		header.setText(constants.header()+" :");
		lastNameField.setTitle(constants.lastname());
		firstNameField.setTitle(constants.firstname());
		emailAdressField.setTitle(constants.email());
		
		newpasswordField.setTitle(constants.password());
		newpasswordField.setPassword(true);
		passwordField.setTitle(constants.password());
		passwordField.setPassword(true);
		Make.setText(constants.make());
		Model.setText(constants.model());
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
	public TextField<String> getFirstName() {
		return firstNameField;
	}

	public TextField<String> getLastName() {
		return lastNameField;
	}

	public TextField<String> getNewPassword() {
		return newpasswordField;
	}

	public ListBox getLanguage() {
		return language;
	}

	public TextField<String> getEmailAddress() {
		return emailAdressField;
	}

	@Override
	public HasClickHandlers getAddUserButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandlers getAddButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPresenter(
			com.covoiturage.client.view.AddUserView.Presenter presenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SuggestBox getMakeSuggestTextBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuggestBox getModelSuggestTextBox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextField<String> getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextField<String> getLogin() {
		// TODO Auto-generated method stub
		return null;
	}

}
