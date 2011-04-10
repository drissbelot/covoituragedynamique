package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.event.MessageEvent;
import com.covoiturage.client.event.MessageEventHandler;
import com.covoiturage.client.view.MessagesView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MessagesActivity extends AbstractActivity implements MessagesView.Presenter{
	private final EventBus eventBus;
	private final MessagesView messageView;
	private CovoiturageRequestFactory requestFactory;
	private PlaceController placeController;
	


	public MessagesActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();
		this.eventBus = clientFactory.getEventBus();
		this.messageView = clientFactory.getMessageView();
		this.placeController = clientFactory.getPlaceController();
	}

	private void bind() {
		
		
		eventBus.addHandler(MessageEvent.TYPE, new MessageEventHandler() {
			
			@Override
			public void onMessage(MessageEvent event) {
				showMessage(event.getMessage());
			}
		});
	}


	protected void showMessage(String message) {
		
		
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
