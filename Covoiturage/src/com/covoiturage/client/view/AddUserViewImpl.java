package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AddUserViewImpl extends Composite implements  AddUserView {
	
	interface MyUiBinder extends UiBinder<FlowPanel, AddUserViewImpl> { }
    private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	
	@UiField Button addButton;
	@UiField TextBox firstName;
	@UiField TextBox lastName;
	@UiField TextBox emailAdress;
	@UiField TextBox login;
	@UiField PasswordTextBox password;
	@UiField FlowPanel flowpanel;
	private Presenter presenter;

	public AddUserViewImpl() {
		initWidget(binder.createAndBindUi(this)); 
	}

	public HasClickHandlers getAddUserButton() {return addButton;}
	public Widget asWidget() {return this;}
	public HasClickHandlers getAddButton() {return addButton;}
	public String getPassword() {return  password.getText();}
	public String getLogin() {return login.getText();}
	public void setPresenter(Presenter presenter) {this.presenter=presenter;}
}
