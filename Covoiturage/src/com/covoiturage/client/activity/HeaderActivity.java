package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.event.MessageEvent;
import com.covoiturage.client.event.MessageEventHandler;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.view.HeaderView;
import com.covoiturage.shared.CovoiturageRequestFactory;
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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HeaderActivity extends AbstractActivity implements
		HeaderView.Presenter {
	private final EventBus eventBus;
	private final HeaderView headerView;
	private final CovoiturageRequestFactory requestFactory;
	private final PlaceController placeController;
	private UserInfoProxy currentUser;

	private final UserServiceAsync userService = GWT.create(UserService.class);

	public HeaderActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.headerView = clientFactory.getHeaderView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {
		userService.getUser(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				UserInfoRequest userReq = requestFactory.userInfoRequest();
				Request<UserInfoProxy> createReq = userReq.findUserInfo(result);
				createReq.fire(new Receiver<UserInfoProxy>() {

					@Override
					public void onSuccess(UserInfoProxy response) {

						currentUser = response;
						headerView.getCurrentUser().setText(
								currentUser.getLogin());
					}
				});

			}

			@Override
			public void onFailure(Throwable caught) {

			}
		});

		headerView.getLogout().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				UserInfoRequest userReq = requestFactory.userInfoRequest();
				Request<Boolean> createReq = userReq.logout(currentUser.getId());
				createReq.fire(new Receiver<Boolean>() {
					@Override
					public void onSuccess(Boolean result) {

						goTo(new LoginPlace(null));
					}

				});
			}
		});
		eventBus.addHandler(MessageEvent.TYPE, new MessageEventHandler() {

			@Override
			public void onMessage(MessageEvent event) {
				headerView.getMessages().setText("Vous avez un message");

				// TODO Jolie Popup
				// TODO lier avec la messageView au clic
			}
		});
	}

	@Override
	public String mayStop() {

		return null;
	}

	@Override
	public void onCancel() {

	}

	@Override
	public void onStop() {

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		headerView.setPresenter(this);
		panel.setWidget(headerView.asWidget());
	}

	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
