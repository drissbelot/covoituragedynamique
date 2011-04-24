package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.images.LanguageFlagsRessources;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.view.SettingsView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.extjs.gxt.ui.client.data.BaseModelData;
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

	public SettingsActivity(ClientFactory clientFactory) {

		this.settingsView = clientFactory.getSettingsView();
		this.placeController = clientFactory.getPlaceController();
		this.requestFactory = clientFactory.getRequestFactory();

	}

	private void bind() {
		List<BaseModelData> listRecords = new ArrayList<BaseModelData>();
		BaseModelData recEn = new BaseModelData();
		recEn.set("name", settingsView.getConstants().en());
		recEn.set("img", AbstractImagePrototype.create(languageFlags.flag_en())
				.getHTML());
		BaseModelData recFr = new BaseModelData();
		recFr.set("name", settingsView.getConstants().fr());
		recFr.set("img", AbstractImagePrototype.create(languageFlags.flag_fr())
				.getHTML());
		BaseModelData recNl = new BaseModelData();
		recNl.set("name", settingsView.getConstants().nl());
		recNl.set("img", AbstractImagePrototype.create(languageFlags.flag_nl())
				.getHTML());
		BaseModelData recIt = new BaseModelData();
		recIt.set("name", settingsView.getConstants().it());
		recIt.set("img", AbstractImagePrototype.create(languageFlags.flag_it())
				.getHTML());
		BaseModelData recCh = new BaseModelData();
		recCh.set("name", settingsView.getConstants().ch());
		recCh.set("img", AbstractImagePrototype.create(languageFlags.flag_ch())
				.getHTML());
		listRecords.add(recEn);
		listRecords.add(recFr);
		listRecords.add(recIt);
		listRecords.add(recNl);
		listRecords.add(recCh);
		settingsView.getLanguage().getStore().add(listRecords);
		userService.getUser(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {

				UserInfoRequest userReq = requestFactory.userInfoRequest();
				Request<UserInfoProxy> createReq = userReq.findUserInfo(result);
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

		settingsView.getSubmitButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				modifyUserSettings();

			}
		});

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
