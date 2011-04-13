package com.covoiturage.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.UserService;
import com.covoiturage.client.UserServiceAsync;
import com.covoiturage.client.place.MessageDetailsPlace;
import com.covoiturage.client.view.MessagesListView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.MessagesProxy;
import com.covoiturage.shared.MessagesRequest;
import com.covoiturage.shared.UserInfoDetailsProxy;
import com.covoiturage.shared.UserInfoDetailsRequest;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.maps.client.overlay.HasMarker.Event;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MessagesListActivity extends AbstractActivity implements MessagesListView.Presenter{

	private final MessagesListView messagesListView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;

	private String currentUser;
	private UserInfoDetailsProxy userDetails;
	private List<MessagesProxy> messages= new ArrayList<MessagesProxy>();
	private final UserServiceAsync userService = GWT.create(UserService.class);



	public MessagesListActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();

		this.messagesListView = clientFactory.getMessagesListView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {
		userService.getUser(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {

				currentUser=result;
				showMessages();
			}

			@Override
			public void onFailure(Throwable caught) {


			}
		});
		messagesListView.getDeleteButton().addListener(Events.Select, new Listener<ButtonEvent>(){

			@Override
			public void handleEvent(ButtonEvent be) {
				if(messagesListView.getListGrid().getSelectionModel().getSelectedItems()!=null){
					
				}
				
			}
			
		});

	}


	protected void showMessages() {
		UserInfoDetailsRequest requestDetails = requestFactory.userInfoDetailsRequest();
		Request<UserInfoDetailsProxy> createReqDatails=requestDetails.findDetailsFromUser(currentUser);
		createReqDatails.fire(new Receiver<UserInfoDetailsProxy>() {
			@Override
			public void onSuccess(UserInfoDetailsProxy response) {
				userDetails=response;
				messagesListView.getListGrid().getStore().removeAll();
				for (String message : userDetails.getMessages()) {

					MessagesRequest requestMessages = requestFactory.messagesRequest();
					Request<MessagesProxy> createReqMessages=requestMessages.findMessages(message);
					createReqMessages.fire(new Receiver<MessagesProxy>() {

						@Override
						public void onSuccess(MessagesProxy response) {
							BaseModelData rec = new BaseModelData();
							messages.add(response);
							rec.set("from", response.getFrom());
							rec.set("subject", response.getSubject());
							rec.set("date", response.getDate());
							rec.set("messageId", response.getId());

							messagesListView.getListGrid().getStore().add(rec); 
						}

					});

				}


			}
		});


		messagesListView.getListGrid().addListener(Events.RowClick, new Listener<GridEvent<BaseModelData>>() {

			@Override
			public void handleEvent(GridEvent<BaseModelData> be) {
				goTo(new MessageDetailsPlace(be.getModel().get("messageId").toString()));

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
