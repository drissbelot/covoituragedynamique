package com.covoiturage.client.activity;


import com.covoiturage.client.ClientFactory;

import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.place.MessageDetailsPlace;
import com.covoiturage.client.view.MessageDetailsView;

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

public class MessageDetailsActivity extends AbstractActivity implements MessageDetailsView.Presenter{
	private final EventBus eventBus;
	private final MessageDetailsView messagesDetailsView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;

	private UserInfoProxy currentUser;
	private UserInfoDetailsProxy userDetails;
	private MessagesProxy message;
	



	public MessageDetailsActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.messagesDetailsView = clientFactory.getMessageDetailsView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {
		eventBus.addHandler(SendLoginEvent.TYPE, new SendLoginEventHandler() {
			@Override
			public void onSendLogin(SendLoginEvent event) {
				currentUser = event.getCurrentUser();
				userDetails=event.getUserDetails();
			}
		});
		showMessage();
	}


	protected void showMessage() {
		
		
					MessagesRequest requestMessages = requestFactory.messagesRequest();
					Request<MessagesProxy> createReqMessages=requestMessages.findMessages(((MessageDetailsPlace)placeController.getWhere()).getMessageDetailsName());
					createReqMessages.fire(new Receiver<MessagesProxy>() {

						@Override
						public void onSuccess(MessagesProxy response) {
							message=response;
								messagesDetailsView.getFromLabel().setText(message.getFrom());
								messagesDetailsView.getSubjectLabel().setText(message.getSubject());
								messagesDetailsView.getDateLabel().setText(message.getDate().toString());
								messagesDetailsView.getMessageText().setText(message.getMessage());
								
							
						}
						
					});
			
		
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		messagesDetailsView.setPresenter(this);
		panel.setWidget(messagesDetailsView.asWidget());
	}



	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}