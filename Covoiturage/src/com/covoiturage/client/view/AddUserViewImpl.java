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
	@UiField TextField<String> firstNameField,lastNameField,emailAdressField,loginField;
	@UiField TextField<String> passwordField;
	@UiField SuggestBox vehicleMake,vehicleModel;
	@UiField ListBox language;
	@UiField Label header,Make,Model;

	public AddUserViewImpl() {

		initWidget(binder.createAndBindUi(this)); 


		loginField.setTitle(constants.username());
		lastNameField.setTitle(constants.lastname());
		firstNameField.setTitle(constants.firstname());
		emailAdressField.setTitle(constants.email());
		passwordField.setTitle(constants.passwordlab());
		passwordField.setPassword(true);
		Make.setText(constants.make());
		Model.setText(constants.model());
		language.addItem(constants.fr());
		language.addItem(constants.en());
		language.addItem(constants.nl());
		language.addItem(constants.it());
		language.addItem(constants.ch());
		addButton.setText(constants.add());
	}


	public TextField<String> getFirstName() {
		return firstNameField;
	}

	public TextField<String> getLastName() {
		return lastNameField;
	}


	public TextField<String> getEmailAddress() {
		return emailAdressField;
	}



	@SuppressWarnings("unused")
	private Presenter presenter;

	public HasClickHandlers getAddUserButton() {
		return addButton;
		}
	public Widget asWidget() {
		return this;
		}
	public HasClickHandlers getAddButton() {
		return addButton;
		}
	public TextField<String> getPassword() {
		return  passwordField;
		}
	public TextField<String> getLogin() {
		return loginField;
		}
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

		return language;
	}
}
