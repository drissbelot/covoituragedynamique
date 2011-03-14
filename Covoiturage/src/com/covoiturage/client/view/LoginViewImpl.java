package com.covoiturage.client.view;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginViewImpl extends Composite implements LoginView {
	final Button sendButton = new Button("Login");
	final TextBox nameField = new TextBox();
	private TextBox passField = new PasswordTextBox();
	final Button addUserButton = new Button("S'enregistrer");
	private Anchor signInLink = new Anchor("Sign In");
    private Presenter presenter;

	
	public LoginViewImpl(){

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

	@Override
	public HasClickHandlers getSendLoginButton() {
		return sendButton;
	}

	@Override
	public HasClickHandlers getAddUserButton(){
		return addUserButton;

	}

	@Override
	public  String getPassword() {

		return passField.getText();

	}

	@Override
	public String getLogin() {

		return nameField.getText();
	}

	@Override
	public Anchor getSignInLink() {
		return signInLink;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter=presenter;
		
	}

}