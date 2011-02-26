package com.covoiturage.client.view;

import com.covoiturage.client.presenter.AddUserPresenter;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AddUser extends Composite implements AddUserPresenter.Display {
  private final Button addButton;
  private TextBox firstName;
  private TextBox lastName;
  private TextBox emailAdress;
  private TextBox password;
  
  public AddUser() {
    DecoratorPanel contentTableDecorator = new DecoratorPanel();
    initWidget(contentTableDecorator);
    contentTableDecorator.setWidth("100%");
    contentTableDecorator.setWidth("18em");
   
    
    VerticalPanel vPanel = new VerticalPanel();
    vPanel.setBorderWidth(0);
    vPanel.setSpacing(0);
    vPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
    addButton = new Button("Add");
    firstName = new TextBox();
    lastName = new TextBox();
    emailAdress = new TextBox();
    password = new PasswordTextBox();

    vPanel.add(firstName);
    vPanel.add(lastName);
    vPanel.add(emailAdress);
    vPanel.add(password);
    
    vPanel.add(addButton);



  }
  
  public HasClickHandlers getAddUserButton() {
    return addButton;
  }
  
 
    
  public Widget asWidget() {
    return this;
  }

@Override
public HasClickHandlers getAddButton() {

	return addButton;
}
}
