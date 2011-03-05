package com.covoiturage.client.view;

import com.covoiturage.client.presenter.AddUserPresenter;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class AddUserView extends Composite implements AddUserPresenter.Display {
  private final Button addButton;
  private Label labelFirstName;
  private Label labelLastName;
  private Label labelEmail;
  private Label labelPassword;
  private Label labelLogin;
  private TextBox firstName;
  private TextBox lastName;
  private TextBox emailAdress;
  private TextBox login;
  private TextBox password;
  
  public AddUserView() {
    DecoratorPanel contentTableDecorator = new DecoratorPanel();
    initWidget(contentTableDecorator);
    contentTableDecorator.setWidth("100%");
    contentTableDecorator.setWidth("18em");
   
    
    FlowPanel flowPanel = new FlowPanel();

    addButton = new Button("Add");
    firstName = new TextBox();
    lastName = new TextBox();
    emailAdress = new TextBox();
    login = new TextBox();
    password = new PasswordTextBox();

    labelFirstName= new Label("First Name");
    labelLastName= new Label("Last Name");
    labelEmail= new Label("Email");
    labelLogin = new Label("Login");
    labelPassword= new Label("Password");

    
    
    flowPanel.add(labelFirstName);
    flowPanel.add(firstName);
    flowPanel.add(labelLastName);
    flowPanel.add(lastName);
    flowPanel.add(labelEmail);
    flowPanel.add(emailAdress);
    flowPanel.add(labelLogin);
    flowPanel.add(login);
    flowPanel.add(labelPassword);
    flowPanel.add(password);
    
    flowPanel.add(addButton);

    contentTableDecorator.add(flowPanel);

  }
  
  public HasClickHandlers getAddUserButton() {
    return addButton;
  }
  
 
    
  public Widget asWidget() {
    return this;
  }


public HasClickHandlers getAddButton() {

	return addButton;
}

public String getPassword() {
	
	return password.getText();
}


public String getLogin() {

	return login.getText();
}
}
