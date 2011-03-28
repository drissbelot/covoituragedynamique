package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;

import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.MapPlace;
import com.covoiturage.client.place.SettingsPlace;

import com.covoiturage.client.view.HeaderView;
import com.covoiturage.client.view.MenuView;

import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.UserInfoProxy;
import com.covoiturage.shared.UserInfoRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HeaderActivity extends AbstractActivity implements HeaderView.Presenter{
	private final EventBus eventBus;
	private final HeaderView headerView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;
	private UserInfoProxy currentUser;

	public HeaderActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.headerView = clientFactory.getHeaderView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {
		eventBus.addHandler(SendLoginEvent.TYPE, new SendLoginEventHandler() {
			@Override
			public void onSendLogin(SendLoginEvent event) {
				currentUser = event.getCurrentUser();
				headerView.getCurrentUser().setContents(currentUser.getLogin());
			}
		});
		headerView.getLogout().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				UserInfoRequest userReq = requestFactory.userInfoRequest();
				Request<Boolean> createReq = userReq.logout(currentUser.getId());
				createReq.fire(new Receiver<Boolean>(){
					@Override
					public void onSuccess(Boolean result) {

						goTo(new LoginPlace(null));
					}


				});
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
