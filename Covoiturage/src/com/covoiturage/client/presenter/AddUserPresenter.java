package com.covoiturage.client.presenter;

import com.covoiturage.client.event.AddUserEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class AddUserPresenter implements Presenter{

	public interface Display {

		Widget asWidget();

		HasClickHandlers getAddButton();

	}
	  private final HandlerManager eventBus;
	  private final Display display;

	  public AddUserPresenter(/*ContactsServiceAsync rpcService, */HandlerManager eventBus, Display view) {
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
		display.getAddButton().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new AddUserEvent());
		      }
		    });
	}

}
