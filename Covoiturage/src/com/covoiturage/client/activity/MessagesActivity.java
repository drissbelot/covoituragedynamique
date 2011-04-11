package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;

import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.view.MessagesView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.MessagesProxy;
import com.covoiturage.shared.MessagesRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MessagesActivity extends AbstractActivity implements MessagesView.Presenter{
	private final EventBus eventBus;
	private final MessagesView messageView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;

	private UserInfoProxy currentUser;
	private UserInfoDetailsProxy userDetails;
	private List<MessagesProxy> messages= new ArrayList<MessagesProxy>();
	



	public MessagesActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.messageView = clientFactory.getMessageView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {
		eventBus.addHandler(SendLoginEvent.TYPE, new SendLoginEventHandler() {
			@Override
			public void onSendLogin(SendLoginEvent event) {
				currentUser = event.getCurrentUser();

			}
		});
		showMessages();
	}


	protected void showMessages() {
		UserInfoDetailsRequest request = requestFactory.userInfoDetailsRequest();
		Request<UserInfoDetailsProxy> createReq = request.findPassengerFromUser(currentUser.getId());

		createReq.fire(new Receiver<UserInfoDetailsProxy>() {
			@Override
			public void onSuccess(UserInfoDetailsProxy response) {
				userDetails=response;
				for (String message : userDetails.getMessages()) {
					MessagesRequest requestMessages = requestFactory.messagesRequest();
					Request<MessagesProxy> createReqMessages=requestMessages.findMessages(message);
					createReqMessages.fire(new Receiver<MessagesProxy>() {

						@Override
						public void onSuccess(MessagesProxy response) {
							messages.add(response);
							//TODO maintenant qu'on a les messages, les afficher
						}
						
					});
				}
				
			}
		});

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		messageView.setPresenter(this);
		panel.setWidget(messageView.asWidget());
	}



	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
