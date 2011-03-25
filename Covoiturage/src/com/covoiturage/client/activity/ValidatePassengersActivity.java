package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.GetValidatePassengersEvent;
import com.covoiturage.client.event.GetValidatePassengersEventHandler;
import com.covoiturage.client.event.SelectPassengersEvent;
import com.covoiturage.client.view.ValidatePassengersView;
import com.covoiturage.shared.CovoiturageRequestFactory;

import com.covoiturage.shared.SimpleTravelProxy;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

public class ValidatePassengersActivity extends AbstractActivity implements
		ValidatePassengersView.Presenter {

	public interface Display {

		Widget asWidget();

	}

	private final EventBus eventBus;
	private final ValidatePassengersView validatePassengersView;
	private final CovoiturageRequestFactory requestFactory;
	private List<SimpleTravelProxy> passengersTravels;
	private List<UserInfoDetailsProxy> passengersInfo = new ArrayList<UserInfoDetailsProxy>();
	private final PlaceController placeController;
	private List<String> passengers;


	public ValidatePassengersActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.validatePassengersView = clientFactory.getValidatePassengersView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {

		eventBus.addHandler(GetValidatePassengersEvent.TYPE,
				new GetValidatePassengersEventHandler() {
					@Override
					public void onGetValidatePassengers(
							GetValidatePassengersEvent event) {
								
						passengersTravels = event.getSimpleTravels();
						passengers = event.getPassengers();

						UserInfoDetailsRequest request = requestFactory
								.userInfoDetailsRequest();

						Request<List<UserInfoDetailsProxy>> createReq = request
								.getPassengerList(passengers);

						createReq
								.fire(new Receiver<List<UserInfoDetailsProxy>>() {

									@Override
									public void onSuccess(
											List<UserInfoDetailsProxy> resultPassengers) {
										passengersInfo = resultPassengers;
										List<ListGridRecord> listRecords = new ArrayList<ListGridRecord>();
										
										for (int i = 0; i<passengersTravels.size(); i++) {
									
											ListGridRecord rec = new ListGridRecord();
											rec.setAttribute("login", passengersTravels.get(i).getPassenger());
											rec.setAttribute("origin", passengersTravels.get(i).getSteps().get(0));
											rec.setAttribute("destination", passengersTravels.get(i).getSteps().get(1));
											rec.setAttribute("firstName",passengersInfo.get(i).getFirstName() );
											rec.setAttribute("lastName",passengersInfo.get(i).getLastName() );
											listRecords.add(rec );

										}
										ListGridRecord[] lr = new ListGridRecord[listRecords.size()];
										validatePassengersView.getListGrid().setData(listRecords.toArray(lr));
									}
								});

					}

				});
		validatePassengersView.getListGrid().addSelectionChangedHandler(
				new SelectionChangedHandler() {
					
					@Override
					public void onSelectionChanged(SelectionEvent event) {

						eventBus.fireEvent(new SelectPassengersEvent(
								validatePassengersView.getListGrid().getSelection()));
						
					}
				});

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
