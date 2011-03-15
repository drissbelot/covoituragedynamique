package com.covoiturage.client.activity;

import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.getValidatePassengersEvent;
import com.covoiturage.client.event.getValidatePassengersEventHandler;
import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class ValidatePassengersActivity extends AbstractActivity implements ValidatePassengersView.Presenter{

	public interface Display {

		Widget asWidget();

	

	}
	  private final EventBus eventBus;
	  private final ValidatePassengersView validatePassengersView;
	  private CovoiturageRequestFactory requestFactory;
	  private List<String> passengers;
	  private List<UserInfoProxy> passengersInfo;
	  private PlaceController placeController;

	  public ValidatePassengersActivity(ClientFactory clientFactory) {
		    this.requestFactory = clientFactory.getRequestFactory();
		    this.eventBus = clientFactory.getEventBus();
		    this.validatePassengersView = clientFactory.getValidatePassengersView();
		    this.placeController= clientFactory.getPlaceController();
		  }



	private void bind() {
		eventBus.addHandler(getValidatePassengersEvent.TYPE, new getValidatePassengersEventHandler() {
			
			@Override
			public void onGetValidatePassengers(getValidatePassengersEvent event) {
				passengers=event.getPassengers();
				
			}
		});
	    ListDataProvider<UserInfoProxy> dataProvider = new ListDataProvider<UserInfoProxy>();


	    dataProvider.addDataDisplay(validatePassengersView.getTable());

	
	    List<UserInfoProxy> list = dataProvider.getList();
	    for (String passenger : passengers) {
	    	UserInfoRequest request = requestFactory.userInfoRequest();


			Request<UserInfoProxy> createReq = request.findUserInfo(passenger);

			createReq.fire(new Receiver<UserInfoProxy>() {
				
				@Override
				public void onSuccess(UserInfoProxy response) {
					passengersInfo.add(response);
					
				}
			});
			
		}
	    
	    for (UserInfoProxy user : passengersInfo) {
	      list.add(user);
	    }

		
		}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		
	    bind();
        validatePassengersView.setPresenter(this);
        panel.setWidget(validatePassengersView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		
		placeController.goTo(place);
	}

	
}
