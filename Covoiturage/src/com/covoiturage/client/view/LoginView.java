package com.covoiturage.client.view;
import com.covoiturage.client.presenter.LoginPresenter;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

public class LoginView extends Composite implements LoginPresenter.Display {
	final Button sendButton = new Button("Login");
	final TextBox nameField = new TextBox();
	private TextBox passField = new PasswordTextBox();
	final Button addUserButton = new Button("S'enregistrer");
	  private Anchor signInLink = new Anchor("Sign In");
	public LoginView(){
		
		  DecoratorPanel LoginDecorator = new DecoratorPanel();
		    initWidget(LoginDecorator); 
		    LoginDecorator.setWidth("100%");
		    
		    
		    HorizontalPanel hPanel = new HorizontalPanel();
		    hPanel.setBorderWidth(0);
		    hPanel.setSpacing(0);
		    hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);

		nameField.setText("Login");
		
		passField.setText("Password");

		final Label errorLabel = new Label();

		
		sendButton.addStyleName("sendButton");

		hPanel.add(nameField);

		hPanel.add(errorLabel);
		hPanel.add(passField);
		hPanel.add(sendButton);
		hPanel.add(addUserButton);
		hPanel.add(signInLink);
		LoginDecorator.setWidget(hPanel);
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