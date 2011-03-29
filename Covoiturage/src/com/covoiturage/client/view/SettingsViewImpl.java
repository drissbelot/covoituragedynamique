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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SettingsViewImpl extends Composite implements  SettingsView{
	
	interface MyUiBinder extends UiBinder<VerticalPanel, SettingsViewImpl> { }
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	@UiField Button submitButton;
	@UiField VerticalPanel flowpanel;
	@UiField TextBox login;
	@UiField TextBox firstName;
	@UiField TextBox lastName;
	@UiField TextBox emailAdress;
	@UiField PasswordTextBox prevpassword;
	@UiField PasswordTextBox newpassword;
	@UiField ListBox langue;
	
	@SuppressWarnings("unused")
	private Presenter presenter; 
	
	public SettingsViewImpl(){
		initWidget(binder.createAndBindUi(this));
		login.setText("login=fix");
		
		langue.addItem("Francais");
		langue.addItem("Anglais");
		langue.addItem("Néerlandais");
		langue.addItem("Italien");
		langue.addItem("Chinois");
	}
	
	public HasClickHandlers getSubmit() {

		return submitButton;
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}

}
