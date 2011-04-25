package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.covoiturage.shared.VehiclesProxy;
import com.covoiturage.shared.VehiclesRequest;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.SuggestOracle.Suggestion;

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

		List<BaseModelData> listRecords = new ArrayList<BaseModelData>();
		BaseModelData recEn = new BaseModelData();
		recEn.set("name", addUserView.getConstants().en());
		recEn.set("img", AbstractImagePrototype.create(languageFlags.flag_en())
				.getHTML());
		BaseModelData recFr = new BaseModelData();
		recFr.set("name", addUserView.getConstants().fr());
		recFr.set("img", AbstractImagePrototype.create(languageFlags.flag_fr())
				.getHTML());
		BaseModelData recNl = new BaseModelData();
		recNl.set("name", addUserView.getConstants().nl());
		recNl.set("img", AbstractImagePrototype.create(languageFlags.flag_nl())
				.getHTML());
		BaseModelData recIt = new BaseModelData();
		recIt.set("name", addUserView.getConstants().it());
		recIt.set("img", AbstractImagePrototype.create(languageFlags.flag_it())
				.getHTML());
		BaseModelData recCh = new BaseModelData();
		recCh.set("name", addUserView.getConstants().ch());
		recCh.set("img", AbstractImagePrototype.create(languageFlags.flag_ch())
				.getHTML());
		listRecords.add(recEn);
		listRecords.add(recFr);
		listRecords.add(recIt);
		listRecords.add(recNl);
		listRecords.add(recCh);
		addUserView.getLanguage().getStore().add(listRecords);

		addUserView.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addUser();
			}
		});
		addUserView.getMakeSuggestTextBox().getTextBox()
				.addKeyUpHandler(new KeyUpHandler() {
					@Override
					public void onKeyUp(KeyUpEvent event) {
						VehiclesRequest vehiclesRequest = requestFactory
								.vehiclesRequest();
						Request<List<VehiclesProxy>> createReqVehicles = vehiclesRequest
								.findAllVehicles();
						createReqVehicles
								.fire(new Receiver<List<VehiclesProxy>>() {
									@Override
									public void onSuccess(
											List<VehiclesProxy> response) {
										MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) addUserView
												.getMakeSuggestTextBox()
												.getSuggestOracle();
										Set<VehiclesProxy> setVehicles = new HashSet<VehiclesProxy>(
												response);
										for (VehiclesProxy vehiclesProxy : setVehicles) {
											oracle.add(vehiclesProxy.getMake());

										}

									}

								});

					}
				});
		addUserView.getModelSuggestTextBox().getTextBox()
				.addKeyUpHandler(new KeyUpHandler() {
					@Override
					public void onKeyUp(KeyUpEvent event) {
						VehiclesRequest vehiclesRequest = requestFactory
								.vehiclesRequest();
						Request<List<String>> createReqModels = vehiclesRequest
								.getModelsFromMake();
						createReqModels.fire(new Receiver<List<String>>() {
							@Override
							public void onSuccess(List<String> result) {

								MultiWordSuggestOracle oracle = (MultiWordSuggestOracle) addUserView
										.getModelSuggestTextBox()
										.getSuggestOracle();
								for (String string : result) {
									oracle.add(string);
								}
							}

						});
					}
				});

		addUserView.getModelSuggestTextBox().addSelectionHandler(
				new SelectionHandler<SuggestOracle.Suggestion>() {

					@Override
					public void onSelection(SelectionEvent<Suggestion> event) {
						VehiclesRequest vehiclesRequest = requestFactory
								.vehiclesRequest();
						Request<Integer> createReqSeats = vehiclesRequest
								.getSeatsFromModel(addUserView
										.getMakeSuggestTextBox().getTextBox()
										.getText(), addUserView
										.getModelSuggestTextBox().getTextBox()
										.getText());
						createReqSeats.fire(new Receiver<Integer>() {

							@Override
							public void onSuccess(Integer response) {
								addUserView.getSeatsField().setValue(response);

							}

						});

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
		newDriver.setVehicle(addUserView.getMakeSuggestTextBox().getText());
		// TODO c'est pas ça qu'il faut sauver
		newDriver.setCountOfPlaces(addUserView.getSeatsField().getRawValue());
		newDriver.setLanguage(addUserView.getLanguage().getSelectedText());
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
