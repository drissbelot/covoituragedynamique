package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.place.HistoryPlace;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.MessagesListPlace;
import com.covoiturage.client.place.SettingsPlace;
import com.covoiturage.client.view.MenuView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.MessagesProxy;
import com.covoiturage.shared.MessagesRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
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
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MenuActivity extends AbstractActivity implements
		MenuView.Presenter {

	private final MenuView menuView;

	private final PlaceController placeController;
	private UserInfoDetailsProxy userDetails;
	private final UserServiceAsync userService = GWT.create(UserService.class);
	private final CovoiturageRequestFactory requestFactory;
	private int messagesUnread;

	public MenuActivity(ClientFactory clientFactory) {

		this.menuView = clientFactory.getMenuView();
		this.placeController = clientFactory.getPlaceController();
		this.requestFactory = clientFactory.getRequestFactory();

	}

	private void bind() {
		userService.getUser(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				UserInfoDetailsRequest userReq = requestFactory
						.userInfoDetailsRequest();
				Request<UserInfoDetailsProxy> createReq = userReq
						.findDetailsFromUser(Long.valueOf(result));
				createReq.fire(new Receiver<UserInfoDetailsProxy>() {

					@Override
					public void onSuccess(UserInfoDetailsProxy response) {

						userDetails = response;

						for (String message : userDetails.getMessages()) {
							MessagesRequest messageReq = requestFactory
									.messagesRequest();
							Request<MessagesProxy> createMessageReq = messageReq
									.findMessages(Long.valueOf(message));
							createMessageReq
									.fire(new Receiver<MessagesProxy>() {

										@Override
										public void onSuccess(
												MessagesProxy response) {
											if (!response.getRead())
												messagesUnread++;

										}
									});
						}
						menuView.getMessagesLabel().setText(
								menuView.getConstants().message() + " ("
										+ messagesUnread + ")");

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
		menuView.getMapLabel().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				goTo(new MapPlace(null));

			}
		});
		menuView.getSettingsLabel().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				goTo(new SettingsPlace(null));

			}
		});
		menuView.getHistoryLabel().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				goTo(new HistoryPlace(null));

			}
		});
		menuView.getMessagesLabel().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				goTo(new MessagesListPlace(null));

			}
		});
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		menuView.setPresenter(this);
		panel.setWidget(menuView.asWidget());
	}

	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
