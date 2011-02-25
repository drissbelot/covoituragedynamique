package com.covoiturage.client.presenter;


import com.covoiturage.client.event.SendLoginEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class LoginPresenter implements Presenter {
	
	  public interface Display {
		    HasClickHandlers getSendLoginButton();



		    Widget asWidget();
		  }
	
	  private final HandlerManager eventBus;
	  private final Display display;

	  public LoginPresenter(/*ContactsServiceAsync rpcService, */HandlerManager eventBus, Display view) {
		  //  this.rpcService = rpcService;
		    this.eventBus = eventBus;
		    this.display = view;
		  }
	
	@Override
	public void go(HasWidgets container) {
	    bind();
	    container.clear();
	    container.add(display.asWidget());
	}

	private void bind() {
		display.getSendLoginButton().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new SendLoginEvent());
		      }
		    });

	} 
	
}