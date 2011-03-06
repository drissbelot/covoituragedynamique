package com.covoiturage.client.view;
import com.covoiturage.client.presenter.LoginPresenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginView extends Composite implements LoginPresenter.Display {
	final Button sendButton = new Button("Login");
	final TextBox nameField = new TextBox();
	private TextBox passField = new PasswordTextBox();
	final Button addUserButton = new Button("S'enregistrer");
	private Anchor signInLink = new Anchor("Sign In");
	public LoginView(){
		
		  DecoratorPanel LoginDecorator = new DecoratorPanel();
		    initWidget(LoginDecorator); 

		    
		    
		    VerticalPanel loginPanel = new VerticalPanel();



		nameField.setText("Login");
		
		passField.setText("Password");

		final Label errorLabel = new Label();
		
		sendButton.addStyleName("sendButton");

		loginPanel.add(nameField);

		loginPanel.add(errorLabel);
		loginPanel.add(passField);
		loginPanel.add(sendButton);
		loginPanel.add(addUserButton);
		loginPanel.add(signInLink);
		LoginDecorator.setWidget(loginPanel);
		nameField.setFocus(true);
		nameField.selectAll();


		
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
	@Override
	public String getLogin() {
		
		return nameField.getText();
	}

	public Anchor getSignInLink() {
		return signInLink;
	}
	
}