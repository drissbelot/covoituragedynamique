package com.covoiturage.client.presenter;


import com.covoiturage.client.UserAccountServiceAsync;
import com.covoiturage.client.event.NewUserEvent;
import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.shared.UserInfo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class LoginPresenter implements Presenter {
	
	  public interface Display {
		    HasClickHandlers getSendLoginButton();



		    Widget asWidget();



			HasClickHandlers getAddUserButton();



			String getLogin();



			String getPassword();



			Anchor getSignInLink();



		  }
	
	  private final HandlerManager eventBus;
	  private final Display display;
	  private UserInfo currentUser;
	  private UserAccountServiceAsync rpcService;



	  public LoginPresenter(UserAccountServiceAsync rpcService, HandlerManager eventBus, Display view) {
		  this.rpcService = rpcService;
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
		   	  login();

		      }
		    });
		display.getAddUserButton().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new NewUserEvent());
		      }
		    });
	} 
	
	private void login()
	{
		 	
		    rpcService.login(display.getLogin(), display.getPassword(), new AsyncCallback<UserInfo>() {
		      public void onFailure(Throwable error) {

		      }

		      public void onSuccess(UserInfo result) {
		    	  currentUser = result;
		    	  
		        if(currentUser.isLoggedIn()) {
			        eventBus.fireEvent(new SendLoginEvent());
		        } else {
		        	  loadLogin();

		        }
		      }
		    });
		  }

	  private void loadLogin() {
		    // Assemble login panel.
		    display.getSignInLink().setHref(currentUser.getLoginUrl());


		  }

	
	
	
}