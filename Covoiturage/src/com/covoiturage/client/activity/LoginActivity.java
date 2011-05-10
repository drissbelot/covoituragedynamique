/*
 * 
 */
package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.event.MessageEvent;
import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.place.AddUserPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.view.LoginView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.appengine.channel.client.Channel;
import com.google.gwt.appengine.channel.client.ChannelFactory;
import com.google.gwt.appengine.channel.client.ChannelFactory.ChannelCreatedCallback;
import com.google.gwt.appengine.channel.client.SocketError;
import com.google.gwt.appengine.channel.client.SocketListener;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginActivity.
 */
public class LoginActivity extends AbstractActivity implements
		LoginView.Presenter {

	/** The event bus. */
	private final EventBus eventBus;

	/** The login view. */
	private final LoginView loginView;

	/** The current user. */
	private UserInfoProxy currentUser;

	/** The request factory. */
	private final CovoiturageRequestFactory requestFactory;

	/** The place controller. */
	private final PlaceController placeController;

	/** The user service. */
	private final UserServiceAsync userService = GWT.create(UserService.class);

	/**
	 * Instantiates a new login activity.
	 * 
	 * @param clientFactory
	 *            the client factory
	 */
	public LoginActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.loginView = clientFactory.getLoginView();
		this.placeController = clientFactory.getPlaceController();
	}

	/**
	 * Bind.
	 */
	private void bind() {
		loginView.getSendLoginButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				login();

			}
		});
		loginView.getAddUserButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				goTo(new AddUserPlace(null));
			}
		});
	}

	/**
	 * Login.
	 */
	private void login() {

		userService.login(loginView.getLogin().getValue(), loginView
				.getPassword().getValue(), new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {

				userService.getUser(new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {

					}

					@Override
					public void onSuccess(String result) {

						UserInfoRequest request = requestFactory
								.userInfoRequest();
						Request<UserInfoProxy> createReq = request
								.findUserInfo(Long.parseLong(result));
						createReq.fire(new Receiver<UserInfoProxy>() {

							@Override
							public void onSuccess(UserInfoProxy response) {
								currentUser = response;
								if (currentUser != null
										&& currentUser.getLoggedIn()) {
									UserInfoDetailsRequest requestDetails = requestFactory
											.userInfoDetailsRequest();
									Request<UserInfoDetailsProxy> createReqDatails = requestDetails
											.channel(currentUser.getId());
									createReqDatails
											.fire(new Receiver<UserInfoDetailsProxy>() {
												@Override
												public void onSuccess(
														UserInfoDetailsProxy response) {
													eventBus.fireEvent(new SendLoginEvent(
															currentUser,
															response));

													ChannelFactory.createChannel(
															response.getChannelId(),
															new ChannelCreatedCallback() {
																@Override
																public void onChannelCreated(
																		Channel channel) {
																	channel.open(new SocketListener() {
																		@Override
																		public void onOpen() {

																		}

																		@Override
																		public void onMessage(
																				String message) {
																			eventBus.fireEvent(new MessageEvent(
																					message));

																		}

																		@Override
																		public void onError(
																				SocketError error) {

																		}

																		@Override
																		public void onClose() {

																		}
																	});
																}
															});

												}
											});

									goTo(new MapPlace(null));

								} else {
									Window.alert("Veuillez vous identifiez");
								}

							}
						});

					}

				});

			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client
	 * .ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		bind();
		loginView.setPresenter(this);
		containerWidget.setWidget(loginView.asWidget());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.covoiturage.client.view.LoginView.Presenter#goTo(com.google.gwt.place
	 * .shared.Place)
	 */
	@Override
	public void goTo(Place place) {
		placeController.goTo(place);
	}

}