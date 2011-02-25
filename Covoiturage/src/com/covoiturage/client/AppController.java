package com.covoiturage.client;

import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.presenter.LoginPresenter;
import com.covoiturage.client.presenter.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.covoiturage.client.presenter.MapPresenter;
import com.covoiturage.client.view.LoginView;
import com.covoiturage.client.view.MapView;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {
  private final HandlerManager eventBus;

  private HasWidgets container;
  
  public AppController(HandlerManager eventBus) {
    this.eventBus = eventBus;
    bind();
  }
  
  private void bind() {
    History.addValueChangeHandler(this);
    
    eventBus.addHandler(SendLoginEvent.TYPE,
            new SendLoginEventHandler() {
              public void onSendLogin(SendLoginEvent event) {
                SendLogin();
              }
            });
   

  }
  
   
  private void SendLogin() {
	  History.newItem("sendLogin");
	// TODO Auto-generated method stub
	
}

public void go(final HasWidgets container) {
    this.container = container;
    
    if ("".equals(History.getToken())) {
      History.newItem("Login");
    }
    else {
      History.fireCurrentHistoryState();
    }
  }

  public void onValueChange(ValueChangeEvent<String> event) {
    String token = event.getValue();
    
    if (token != null) {
      Presenter presenter = null;
      if(token.equals("Login")){
    	  presenter = new LoginPresenter(eventBus,new LoginView() );
    	  
      }
      else if (token.equals("sendLogin")) {
    	        presenter = new MapPresenter(/*rpcService,*/ eventBus, new MapView());
    	      }
    
      
      if (presenter != null) {
        presenter.go(container);
      }
    }
  } 
}
