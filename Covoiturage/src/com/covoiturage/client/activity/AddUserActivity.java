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
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.KeyEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
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

		languageComboBox();

		addUserView.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				addUser();
			}
		});
		addUserView.getVehicleMake().addListener(Events.KeyPress,
				new Listener<KeyEvent>() {

					@Override
					public void handleEvent(KeyEvent be) {
						VehiclesRequest vehiclesRequest = requestFactory
								.vehiclesRequest();
						Request<List<VehiclesProxy>> createReqVehicles = vehiclesRequest
								.findAllVehicles();
						createReqVehicles
								.fire(new Receiver<List<VehiclesProxy>>() {
									@Override
									public void onSuccess(
											List<VehiclesProxy> response) {
										addUserView.getVehicleMake().getStore()
												.removeAll();
										Set<VehiclesProxy> setVehicles = new HashSet<VehiclesProxy>(
												response);
										for (VehiclesProxy vehiclesProxy : setVehicles) {
											BaseModelData rec = new BaseModelData();
											rec.set("name",
													vehiclesProxy.getMake());
											rec.set("make",
													vehiclesProxy.getMake());
											addUserView.getVehicleMake()
													.getStore().add(rec);

										}
									}

								});

					}
				});
		addUserView.getVehicleModel().addListener(Events.KeyPress,
				new Listener<KeyEvent>() {

					@Override
					public void handleEvent(KeyEvent be) {
						VehiclesRequest vehiclesRequest = requestFactory
								.vehiclesRequest();
						Request<List<VehiclesProxy>> createReqVehicles = vehiclesRequest
								.getModelsFromMake(addUserView.getVehicleMake()
										.getSelection().get(0).get("make")
										.toString());
						createReqVehicles
								.fire(new Receiver<List<VehiclesProxy>>() {
									@Override
									public void onSuccess(
											List<VehiclesProxy> response) {
										addUserView.getVehicleModel()
												.getStore().removeAll();

										for (VehiclesProxy model : response) {
											BaseModelData rec = new BaseModelData();
											rec.set("name", model.getModel());
											rec.set("vehicleId", model.getId());
											rec.set("seatsNumber",
													model.getSeats());
											rec.set("emissionsCO2",
													model.getEmissionsCO2());
											rec.set("fuelMixedDrive",
													model.getFuelMixedDrive());
											addUserView.getVehicleModel()
													.getStore().add(rec);

										}
									}

								});

					}
				});
		addUserView.getVehicleModel().addListener(Events.Select,
				new Listener<SelectionEvent<BaseModelData>>() {

					@Override
					public void handleEvent(SelectionEvent<BaseModelData> be) {
						addUserView.getSeatsNumberField().setValue(
								(Integer) be.getModel().get("seatsNumber"));
						addUserView.getEmissionsCO2Field().setValue(
								(Float) be.getModel().get("emissionsCO2"));
						addUserView.getFuelMixedDriveField().setValue(
								(Float) be.getModel().get("fuelMixedDrive"));
					}
				});
	}

	private void languageComboBox() {
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
		newDriver.setVehicle(addUserView.getVehicleModel().getValue()
				.get("vehicleId").toString());

		newDriver.setCountOfPlaces(addUserView.getSeatsNumberField()
				.getRawValue());
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
