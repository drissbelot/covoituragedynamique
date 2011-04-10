package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.view.SettingsView;
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
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SettingsActivity extends AbstractActivity implements SettingsView.Presenter{
	

	private SettingsView settingsView;

	private PlaceController placeController;
	private CovoiturageRequestFactory requestFactory;
	private EventBus eventBus;
	private UserInfoProxy currentUser;

	public SettingsActivity(ClientFactory clientFactory) {

		this.settingsView = clientFactory.getSettingsView();
		this.placeController = clientFactory.getPlaceController();
		this.requestFactory=clientFactory.getRequestFactory();
		this.eventBus=clientFactory.getEventBus();
	}
	
	private void bind() {
		eventBus.addHandler(SendLoginEvent.TYPE, new SendLoginEventHandler() {
			@Override
			public void onSendLogin(SendLoginEvent event) {
				currentUser = event.getCurrentUser();
				
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
		
		UserInfoDetailsRequest requestDetails = requestFactory.userInfoDetailsRequest();
		Request<UserInfoDetailsProxy> createRequestDetails = requestDetails.modifyUserInfoDetails(currentUser.getId(),settingsView.getFirstName().getText(),settingsView.getLastName().getText(),settingsView.getLanguage().getItemText(settingsView.getLanguage().getSelectedIndex()));
		createRequestDetails.fire(new Receiver<UserInfoDetailsProxy>() {

			@Override
			public void onSuccess(UserInfoDetailsProxy response) {
							
			}
		});
		UserInfoRequest request = requestFactory.userInfoRequest();
		Request<UserInfoProxy> createRequest = request.modifyUserInfo(currentUser.getId(),settingsView.getNewPassword().getText(), settingsView.getEmailAddress().getText());
		createRequest.fire(new Receiver<UserInfoProxy>() {

			@Override
			public void onSuccess(UserInfoProxy response) {
							
			}
		});
		
	}

	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		settingsView.setPresenter(this);
        panel.setWidget(settingsView.asWidget());
	}



	public void goTo(Place place) {
		placeController.goTo(place);
	}

}
