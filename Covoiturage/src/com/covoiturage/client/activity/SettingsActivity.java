package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.images.CarRessources;
import com.covoiturage.client.images.LanguageFlagsRessources;
import com.covoiturage.client.images.RatingRessources;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.view.SettingsView;
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
import com.google.gwt.requestfactory.shared.ServerFailure;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SettingsActivity extends AbstractActivity implements
		SettingsView.Presenter {

	private final SettingsView settingsView;

	private final PlaceController placeController;
	private final CovoiturageRequestFactory requestFactory;

	private UserInfoProxy currentUser;

	private final UserServiceAsync userService = GWT.create(UserService.class);
	LanguageFlagsRessources languageFlags = GWT
			.create(LanguageFlagsRessources.class);
	RatingRessources ratingRessources = GWT.create(RatingRessources.class);
	CarRessources carRessources = GWT.create(CarRessources.class);

	public SettingsActivity(ClientFactory clientFactory) {

		this.settingsView = clientFactory.getSettingsView();
		this.placeController = clientFactory.getPlaceController();
		this.requestFactory = clientFactory.getRequestFactory();

	}

	private void bind() {
		languageComboBox();
		comfortComboBox();
		carColorComboBox();
		userService.getUser(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {

				UserInfoRequest userReq = requestFactory.userInfoRequest();
				Request<UserInfoProxy> createReq = userReq.findUserInfo(Long
						.valueOf(result));
				createReq.fire(new Receiver<UserInfoProxy>() {

					@Override
					public void onSuccess(UserInfoProxy response) {

						currentUser = response;

					}

					@Override
					public void onFailure(ServerFailure error) {
						if (error.getMessage().contains("not logged in"))
							goTo(new LoginPlace(null));

					}
				});

			}

			@Override
			public void onFailure(Throwable caught) {

			}

		});
		settingsView.getVehicleMake().addListener(Events.KeyPress,
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
										settingsView.getVehicleMake()
												.getStore().removeAll();
										Set<VehiclesProxy> setVehicles = new HashSet<VehiclesProxy>(
												response);
										for (VehiclesProxy vehiclesProxy : setVehicles) {
											BaseModelData rec = new BaseModelData();
											rec.set("name",
													vehiclesProxy.getMake());
											rec.set("make",
													vehiclesProxy.getMake());
											settingsView.getVehicleMake()
													.getStore().add(rec);

										}
									}

								});

					}
				});
		settingsView.getVehicleModel().addListener(Events.KeyPress,
				new Listener<KeyEvent>() {

					@Override
					public void handleEvent(KeyEvent be) {
						VehiclesRequest vehiclesRequest = requestFactory
								.vehiclesRequest();
						Request<List<VehiclesProxy>> createReqVehicles = vehiclesRequest
								.getModelsFromMake(settingsView
										.getVehicleMake().getSelection().get(0)
										.get("make").toString());
						createReqVehicles
								.fire(new Receiver<List<VehiclesProxy>>() {
									@Override
									public void onSuccess(
											List<VehiclesProxy> response) {
										settingsView.getVehicleModel()
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
											settingsView.getVehicleModel()
													.getStore().add(rec);

										}
									}

								});

					}
				});
		settingsView.getVehicleModel().addListener(Events.Select,
				new Listener<SelectionEvent<BaseModelData>>() {

					@Override
					public void handleEvent(SelectionEvent<BaseModelData> be) {
						settingsView.getSeatsNumberField().setValue(
								(Integer) be.getModel().get("seatsNumber"));
						settingsView.getEmissionsCO2Field().setValue(
								(Float) be.getModel().get("emissionsCO2"));
						settingsView.getFuelMixedDriveField().setValue(
								(Float) be.getModel().get("fuelMixedDrive"));
					}
				});
		settingsView.getSubmitButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				modifyUserSettings();

			}
		});

	}

	private void carColorComboBox() {

		settingsView.getCarColorField().getStore().removeAll();
		List<BaseModelData> listRecordsColor = new ArrayList<BaseModelData>();
		BaseModelData rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_blue());
		rec.set("img", AbstractImagePrototype.create(carRessources.car_blue())
				.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_darkred());
		rec.set("img",
				AbstractImagePrototype.create(carRessources.car_darkred())
						.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_gold());
		rec.set("img", AbstractImagePrototype.create(carRessources.car_gold())
				.getHTML());
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_green());
		rec.set("img", AbstractImagePrototype.create(carRessources.car_green())
				.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_grey());
		rec.set("img", AbstractImagePrototype.create(carRessources.car_grey())
				.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_indigo());
		rec.set("img", AbstractImagePrototype
				.create(carRessources.car_indigo()).getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_orange());
		rec.set("img", AbstractImagePrototype
				.create(carRessources.car_orange()).getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_orangered());
		rec.set("img",
				AbstractImagePrototype.create(carRessources.car_orangered())
						.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_pink());
		rec.set("img", AbstractImagePrototype.create(carRessources.car_pink())
				.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_red());
		rec.set("img", AbstractImagePrototype.create(carRessources.car_red())
				.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_slategray());
		rec.set("img",
				AbstractImagePrototype.create(carRessources.car_slategray())
						.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_springgreen());
		rec.set("img",
				AbstractImagePrototype.create(carRessources.car_springgreen())
						.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_violetred());
		rec.set("img",
				AbstractImagePrototype.create(carRessources.car_violetred())
						.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_white());
		rec.set("img", AbstractImagePrototype.create(carRessources.car_white())
				.getHTML());
		listRecordsColor.add(rec);
		rec = new BaseModelData();
		rec.set("name", settingsView.getConstants().car_yellow());
		rec.set("img", AbstractImagePrototype
				.create(carRessources.car_yellow()).getHTML());
		listRecordsColor.add(rec);
		rec.set("name", settingsView.getConstants().car_yellowgreen());
		rec = new BaseModelData();
		rec.set("img",
				AbstractImagePrototype.create(carRessources.car_yellowgreen())
						.getHTML());
		listRecordsColor.add(rec);

		settingsView.getCarColorField().getStore().add(listRecordsColor);

	}

	private void comfortComboBox() {
		settingsView.getComfortField().getStore().removeAll();
		List<BaseModelData> listRecordsComfort = new ArrayList<BaseModelData>();
		BaseModelData rec1 = new BaseModelData();
		rec1.set("name", settingsView.getConstants().basic());
		rec1.set("img", AbstractImagePrototype.create(ratingRessources.star())
				.getHTML());
		BaseModelData rec2 = new BaseModelData();
		rec2.set("name", settingsView.getConstants().normal());
		rec2.set("img",
				AbstractImagePrototype.create(ratingRessources.twoStar())
						.getHTML());
		BaseModelData rec3 = new BaseModelData();
		rec3.set("name", settingsView.getConstants().comfortable());
		rec3.set("img",
				AbstractImagePrototype.create(ratingRessources.threeStar())
						.getHTML());
		BaseModelData rec4 = new BaseModelData();
		rec4.set("name", settingsView.getConstants().luxury());
		rec4.set("img",
				AbstractImagePrototype.create(ratingRessources.fourStar())
						.getHTML());

		listRecordsComfort.add(rec1);
		listRecordsComfort.add(rec2);
		listRecordsComfort.add(rec3);
		listRecordsComfort.add(rec4);
		settingsView.getComfortField().getStore().add(listRecordsComfort);

	}

	private void languageComboBox() {
		settingsView.getLanguage().getStore().removeAll();
		List<BaseModelData> listRecords = new ArrayList<BaseModelData>();
		BaseModelData recEn = new BaseModelData();
		recEn.set("name", settingsView.getConstants().en());
		recEn.set("img",
				AbstractImagePrototype.create(languageFlags.flag_en_list())
						.getHTML());
		BaseModelData recFr = new BaseModelData();
		recFr.set("name", settingsView.getConstants().fr());
		recFr.set("img",
				AbstractImagePrototype.create(languageFlags.flag_fr_list())
						.getHTML());
		BaseModelData recNl = new BaseModelData();
		recNl.set("name", settingsView.getConstants().nl());
		recNl.set("img",
				AbstractImagePrototype.create(languageFlags.flag_nl_list())
						.getHTML());
		BaseModelData recIt = new BaseModelData();
		recIt.set("name", settingsView.getConstants().it());
		recIt.set("img",
				AbstractImagePrototype.create(languageFlags.flag_it_list())
						.getHTML());
		BaseModelData recCh = new BaseModelData();
		recCh.set("name", settingsView.getConstants().ch());
		recCh.set("img",
				AbstractImagePrototype.create(languageFlags.flag_ch_list())
						.getHTML());
		listRecords.add(recEn);
		listRecords.add(recFr);
		listRecords.add(recIt);
		listRecords.add(recNl);
		listRecords.add(recCh);
		settingsView.getLanguage().getStore().add(listRecords);
	}

	protected void modifyUserSettings() {

		UserInfoDetailsRequest requestDetails = requestFactory
				.userInfoDetailsRequest();
		Request<UserInfoDetailsProxy> createRequestDetails = requestDetails
				.modifyUserInfoDetails(currentUser.getId(), settingsView
						.getFirstName().getTitle(), settingsView.getLastName()
						.getTitle(), settingsView.getLanguage()
						.getSelectedText());
		createRequestDetails.fire(new Receiver<UserInfoDetailsProxy>() {

			@Override
			public void onSuccess(UserInfoDetailsProxy response) {

			}

			@Override
			public void onFailure(ServerFailure error) {
				if (error.getMessage().contains("not logged in"))
					goTo(new LoginPlace(null));

			}
		});
		UserInfoRequest request = requestFactory.userInfoRequest();
		Request<UserInfoProxy> createRequest = request.modifyUserInfo(
				currentUser.getId(), settingsView.getNewPassword().getTitle(),
				settingsView.getEmailAddress().getTitle());
		createRequest.fire(new Receiver<UserInfoProxy>() {

			@Override
			public void onSuccess(UserInfoProxy response) {

			}

			@Override
			public void onFailure(ServerFailure error) {
				if (error.getMessage().contains("not logged in"))
					goTo(new LoginPlace(null));

			}
		});

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		settingsView.setPresenter(this);
		panel.setWidget(settingsView.asWidget());
	}

	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
