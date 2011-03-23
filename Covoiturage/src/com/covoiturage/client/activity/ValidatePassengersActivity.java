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
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;

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
	private final ListDataProvider<SimpleTravelProxy> dataProvider = new ListDataProvider<SimpleTravelProxy>();

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

									}
								});

						dataProvider.addDataDisplay(validatePassengersView
								.getTable());

						displayPassengers(passengersTravels);

					}

				});
		validatePassengersView.getSelectionModel().addSelectionChangeHandler(
				new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						eventBus.fireEvent(new SelectPassengersEvent(
								validatePassengersView.getSelectionModel()
										.getSelectedSet()));

					}
				});

	}

	private void displayPassengers(List<SimpleTravelProxy> travel) {

		List<SimpleTravelProxy> list = dataProvider.getList();
		for (SimpleTravelProxy simpleTravel : travel) {
			list.add(simpleTravel);
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
