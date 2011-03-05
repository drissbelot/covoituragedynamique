package com.covoiturage.client.presenter;

import com.covoiturage.client.UserAccountServiceAsync;

import com.covoiturage.shared.UserInfo;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class AddUserPresenter implements Presenter{

	public interface Display {

		Widget asWidget();

		HasClickHandlers getAddButton();

		String getPassword();

		String getLogin();

	}
	  private final HandlerManager eventBus;
	  private final Display display;
	private UserAccountServiceAsync rpcService;

	  public AddUserPresenter(UserAccountServiceAsync rpcService, HandlerManager eventBus, Display view) {
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
		display.getAddButton().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		    	  addUser();
		        //eventBus.fireEvent(new AddUserEvent());
		      }
		    });
	}

	protected void addUser() {
		
		rpcService.addUser(display.getLogin(), display.getPassword(), new AsyncCallback<UserInfo>() {
		      public void onFailure(Throwable error) {
		    	  	GWT.log(error.getMessage());
		      }

		      public void onSuccess(UserInfo result) {
		    	
		      }
		    });
		  
	}

}
