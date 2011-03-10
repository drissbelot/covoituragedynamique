package com.covoiturage.client.presenter;

import com.covoiturage.client.UserAccountServiceAsync;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ValidatePassengersPresenter implements Presenter{

	public interface Display {

		Widget asWidget();

	

	}
	  private final HandlerManager eventBus;
	  private final Display display;
	  private UserAccountServiceAsync rpcService;

	  public ValidatePassengersPresenter(UserAccountServiceAsync rpcService, HandlerManager eventBus, Display view) {
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
		}

	
}
