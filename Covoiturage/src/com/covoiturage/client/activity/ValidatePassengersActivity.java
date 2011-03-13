package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;

import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ValidatePassengersActivity extends AbstractActivity implements ValidatePassengersView.Presenter{

	public interface Display {

		Widget asWidget();

	

	}
	  private final EventBus eventBus;
	  private final ValidatePassengersView validatePassengersView;
	  private CovoiturageRequestFactory requestFactory;

	  public ValidatePassengersActivity(ClientFactory clientFactory) {
		    this.requestFactory = clientFactory.getRequestFactory();
		    this.eventBus = clientFactory.getEventBus();
		    this.validatePassengersView = clientFactory.getValidatePassengersView();
		  }



	private void bind() {
		}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
	    bind();
	}

	@Override
	public void goTo(Place place) {
		// TODO Auto-generated method stub
		
	}

	
}
