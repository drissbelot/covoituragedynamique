package com.covoiturage.client.view;

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
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AddUserViewImpl extends Composite implements  AddUserView {
	
	interface MyUiBinder extends UiBinder<FlowPanel, AddUserViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
    private AddUserViewConstants constants=(AddUserViewConstants)GWT.create(AddUserViewConstants.class);
    
	@UiField FlowPanel flowpanel;
	@UiField Button addButton;
	@UiField TextBox firstName,lastName,emailAdress,login;
	@UiField PasswordTextBox password;
	@UiField SuggestBox vehicleMake,vehicleModel;
	@UiField ListBox langue;
	@UiField Label header,username,lastname,firstname,email,passwordlab,languelab,Make,Model;

	public AddUserViewImpl() {
		
		initWidget(binder.createAndBindUi(this)); 
		
		header.setText(constants.header()+" :");
		login.setText(constants.username());
		username.setText(constants.username()+" :");
		lastname.setText(constants.lastname()+" :");
		lastName.setText(constants.lastname());
		firstname.setText(constants.firstname()+" :");
		firstName.setText(constants.firstname());
		email.setText(constants.email()+" :");
		emailAdress.setText(constants.email());
		passwordlab.setText(constants.passwordlab()+" :");
		password.setText(constants.passwordlab());
		languelab.setText(constants.languelab()+" :");
		Make.setText(constants.make());
		Model.setText(constants.model());
		langue.addItem(constants.fr());
		langue.addItem(constants.en());
		langue.addItem(constants.nl());
		langue.addItem(constants.it());
		langue.addItem(constants.ch());
		addButton.setText(constants.add());
	}
	
	
	public String getFirstName() {
		return firstName.getText();
	}

	public void setFirstName(String firstName) {
		this.firstName.setText(firstName);
	}

	public String getLastName() {
		return lastName.getText();
	}

	public void setLastName(String lastName) {
		this.lastName.setText(lastName);
	}

	public String getEmailAddress() {
		return emailAdress.getText();
	}

	public void setEmailAddress(String emailAdress) {
		this.emailAdress.setText(emailAdress);
	}

	@SuppressWarnings("unused")
	private Presenter presenter;

	public HasClickHandlers getAddUserButton() {return addButton;}
	public Widget asWidget() {return this;}
	public HasClickHandlers getAddButton() {return addButton;}
	public String getPassword() {return  password.getText();}
	public String getLogin() {return login.getText();}
	public void setPresenter(Presenter presenter) {this.presenter=presenter;}

	@Override
	public SuggestBox getMakeSuggestTextBox() {
		return vehicleMake;
	}

	@Override
	public SuggestBox getModelSuggestTextBox() {

		return vehicleModel;
	}

	@Override
	public ListBox getLanguage() {

		return langue;
	}
}
