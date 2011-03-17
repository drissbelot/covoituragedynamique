package com.covoiturage.client.view;

import com.covoiturage.client.view.MapView.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class EditProfilViewImpl extends Composite implements  EditProfilView{
	
	interface MyUiBinder extends UiBinder<FlowPanel, EditProfilViewImpl> { }
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	@UiField Button submitButton;
	@UiField FlowPanel flowpanel;
	@UiField TextBox login;
	@UiField TextBox firstName;
	@UiField TextBox lastName;
	@UiField TextBox emailAdress;
	@UiField PasswordTextBox prevpassword;
	@UiField PasswordTextBox newpassword;
	
	private Presenter presenter;  //a quoi il sert?
	
	public EditProfilViewImpl(){
		initWidget(binder.createAndBindUi(this));
		login.setText("login=fix");
	}
	
	public HasClickHandlers getSubmit() {

		return submitButton;
	}
	
	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
	}

}
