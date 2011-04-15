package com.covoiturage.client.view;

import com.covoiturage.client.i18n.LoginViewConstants;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class LoginViewImpl extends Composite implements LoginView {
	
	interface MyUiBinder extends UiBinder<FlowPanel, LoginViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
    @UiField TextField<String> loginField,passwordField;
    @UiField Label title;
	@UiField Button addUserButton,sendButton;
	@UiField Image image,image2;

    @SuppressWarnings("unused")
	private Presenter presenter;
    private LoginViewConstants constants=(LoginViewConstants)GWT.create(LoginViewConstants.class);
	
	public LoginViewImpl(){
		
		initWidget(binder.createAndBindUi(this)); 
		loginField.setFieldLabel(constants.username());
		title.setText(constants.title());
		passwordField.setFieldLabel(constants.password());
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

	public  TextField<String> getPassword() {
		return passwordField;
	}
	public TextField<String> getLogin() {
		return loginField;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}
	
	@UiHandler("addUserButton")
	void onAddUserButtonClick(ClickEvent event) {
	}
}