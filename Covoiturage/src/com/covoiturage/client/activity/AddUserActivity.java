package com.covoiturage.client.activity;

import java.util.ArrayList;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.AddUserEvent;
import com.covoiturage.client.images.LanguageFlagsRessources;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.view.AddUserView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AddUserActivity extends AbstractActivity implements
		AddUserView.Presenter {

	private final EventBus eventBus;
	AddUserView addUserView;
	private final CovoiturageRequestFactory requestFactory;
	private final PlaceController placeController;
	LanguageFlagsRessources languageFlags = GWT
			.create(LanguageFlagsRessources.class);

	public AddUserActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.addUserView = clientFactory.getAddUserView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {

		addUserView.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addUser();
			}
		});

	}

	protected void addUser() {

		UserInfoRequest request = requestFactory.userInfoRequest();
		UserInfoProxy newUser = request.create(UserInfoProxy.class);
		newUser.setLogin(addUserView.getLogin().getValue());
		newUser.setPassword(addUserView.getPassword().getValue());
		newUser.setEmailAddress(addUserView.getEmailAddress().getValue());

		Request<String> createReq = request.persist().using(newUser);
		createReq.fire(new Receiver<String>() {
			@Override
			public void onSuccess(String response) {

				savePassengerDriver(response);
			}

		});

	}

	protected void savePassengerDriver(String newUser) {

		UserInfoDetailsRequest requestDriver = requestFactory
				.userInfoDetailsRequest();
		UserInfoDetailsProxy newDriver = requestDriver
				.create(UserInfoDetailsProxy.class);
		newDriver.setUser(newUser);
		newDriver.setFirstName(addUserView.getFirstName().getValue());
		newDriver.setLastName(addUserView.getLastName().getValue());

		newDriver.setMessages(new ArrayList<String>());
		Request<Void> createReqDriver = requestDriver.persist()
				.using(newDriver);

		createReqDriver.fire(new Receiver<Void>() {
			@Override
			public void onSuccess(Void response) {
				eventBus.fireEvent(new AddUserEvent());
				goTo(new LoginPlace(null));
			}
		});

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		addUserView.setPresenter(this);
		panel.setWidget(addUserView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}
}
