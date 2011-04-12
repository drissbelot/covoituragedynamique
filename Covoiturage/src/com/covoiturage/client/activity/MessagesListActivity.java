package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;

import com.covoiturage.client.event.SendLoginEvent;
import com.covoiturage.client.event.SendLoginEventHandler;
import com.covoiturage.client.place.MessageDetailsPlace;
import com.covoiturage.client.view.MessagesListView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.MessagesProxy;
import com.covoiturage.shared.MessagesRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.covoiturage.shared.UserInfoProxy;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MessagesListActivity extends AbstractActivity implements MessagesListView.Presenter{
	private final EventBus eventBus;
	private final MessagesListView messagesListView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;

	private UserInfoProxy currentUser;
	private UserInfoDetailsProxy userDetails;
	private List<MessagesProxy> messages= new ArrayList<MessagesProxy>();
	



	public MessagesListActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.messagesListView = clientFactory.getMessagesListView();
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
		showMessages();
	}


	protected void showMessages() {
		
				final List<BaseModelData> listRecords = new ArrayList<BaseModelData>();
				
				final BaseModelData rec = new BaseModelData();
				for (String message : userDetails.getMessages()) {
					MessagesRequest requestMessages = requestFactory.messagesRequest();
					Request<MessagesProxy> createReqMessages=requestMessages.findMessages(message);
					createReqMessages.fire(new Receiver<MessagesProxy>() {

						@Override
						public void onSuccess(MessagesProxy response) {
							messages.add(response);
								rec.set("from", response.getFrom());
								rec.set("subject", response.getSubject());
								rec.set("date", response.getDate());
								rec.set("messageId", response.getId());
								
								
								listRecords.add(rec );

							
							
							messagesListView.getListGrid().getStore().add(listRecords); 
							
						}
						
					});
				}
				
		
		messagesListView.getListGrid().addListener(Events.RowClick, new Listener<GridEvent<BaseModelData>>() {

			@Override
			public void handleEvent(GridEvent<BaseModelData> be) {
				goTo(new MessageDetailsPlace(be.getRecord().get("id").toString()));
				
			}

		
		});
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		messagesListView.setPresenter(this);
		panel.setWidget(messagesListView.asWidget());
	}



	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
