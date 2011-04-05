package com.covoiturage.client.view;

import com.covoiturage.client.i18n.LoginViewConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class LoginViewImpl extends Composite implements LoginView {
	
	interface MyUiBinder extends UiBinder<FlowPanel, LoginViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	@UiField TextBox nameField ;
	@UiField PasswordTextBox passField ;
	@UiField Button addUserButton,sendButton;
	@UiField Image image,image2;
	@UiField Label name,pass,log,titre;

    @SuppressWarnings("unused")
	private Presenter presenter;

    
    private LoginViewConstants constants=(LoginViewConstants)GWT.create(LoginViewConstants.class);
	
	public LoginViewImpl(){
		
		initWidget(binder.createAndBindUi(this)); 
		titre.setText(constants.titre());
		log.setText(constants.login());
		name.setText(constants.username()+" :");
		nameField.setText(constants.username());
		pass.setText(constants.password()+" :");
		passField.setText(constants.password());
		addUserButton.setText(constants.newuser());
		sendButton.setText(constants.submit());
		

		image.setUrl("http://www.cijoint.fr/cj201103/cijYu4R0h9.png");
		image2.setUrl("http://www.cijoint.fr/cj201103/cijYu4R0h9.png");
		
	}

	public HasClickHandlers getSendLoginButton() {
		return sendButton;
	}

	public HasClickHandlers getAddUserButton(){
		return addUserButton;
	}

	public  String getPassword() {
		return passField.getText();
	}
	public String getLogin() {
		return nameField.getText();
	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	@UiHandler("addUserButton")
	void onAddUserButtonClick(ClickEvent event) {
	}
}