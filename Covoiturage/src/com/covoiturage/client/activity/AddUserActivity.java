/*
 * 
 */
package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.AddUserEvent;
import com.covoiturage.client.place.LicencePlace;
import com.covoiturage.client.view.AddUserView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

// TODO: Auto-generated Javadoc
/**
 * The Class AddUserActivity.
 */
public class AddUserActivity extends AbstractActivity implements
		AddUserView.Presenter {

	/** The event bus. */
	private final EventBus eventBus;
	
	/** The add user view. */
	private final AddUserView addUserView;
	
	/** The request factory. */
	private final CovoiturageRequestFactory requestFactory;
	
	/** The place controller. */
	private final PlaceController placeController;

	/**
	 * Instantiates a new adds the user activity.
	 *
	 * @param clientFactory the client factory
	 */
	public AddUserActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.addUserView = clientFactory.getAddUserView();
		this.placeController = clientFactory.getPlaceController();
	}

	/**
	 * Bind.
	 */
	private void bind() {

		addUserView.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addUser();
			}
		});

	}

	/**
	 * Adds the user.
	 */
	protected void addUser() {

		UserInfoRequest request = requestFactory.userInfoRequest();
		UserInfoProxy newUser = request.create(UserInfoProxy.class);
		newUser.setLogin(addUserView.getLogin().getValue());
		newUser.setPassword(addUserView.getPassword().getValue());
		newUser.setEmailAddress(addUserView.getEmailAddress().getValue());

		Request<Long> createReq = request.persist(newUser);
		createReq.fire(new Receiver<Long>() {
			@Override
			public void onSuccess(Long response) {
				savePassengerDriver(response);
			}
		});

	}

	/**
	 * Save passenger driver.
	 *
	 * @param newUser the new user
	 */
	protected void savePassengerDriver(Long newUser) {

		UserInfoDetailsRequest requestDriver = requestFactory
				.userInfoDetailsRequest();
		UserInfoDetailsProxy newDriver = requestDriver
				.create(UserInfoDetailsProxy.class);
		newDriver.setUser(newUser);
		newDriver.setFirstName(addUserView.getFirstName().getValue());
		newDriver.setLastName(addUserView.getLastName().getValue());
		Request<Long> createReqDriver = requestDriver.persist(newDriver);

		createReqDriver.fire(new Receiver<Long>() {
			@Override
			public void onSuccess(Long response) {
				eventBus.fireEvent(new AddUserEvent());
				goTo(new LicencePlace(null));
			}

		});

	}

	/* (non-Javadoc)
	 * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		addUserView.setPresenter(this);
		panel.setWidget(addUserView.asWidget());
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.AddUserView.Presenter#goTo(com.google.gwt.place.shared.Place)
	 */
	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}
}
