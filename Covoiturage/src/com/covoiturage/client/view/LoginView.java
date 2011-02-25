package com.covoiturage.client.view;
import com.covoiturage.client.presenter.LoginPresenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginView extends Composite implements LoginPresenter.Display {
	final Button sendButton = new Button("Send");
	final TextBox nameField = new TextBox();
	final TextBox passField = new PasswordTextBox();
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
		LoginDecorator.setWidget(hPanel);
		nameField.setFocus(true);
		nameField.selectAll();

		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		
	}
	  public HasClickHandlers getSendLoginButton() {
		    return sendButton;
		  }
	
}