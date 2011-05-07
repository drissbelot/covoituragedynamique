/*
 * 
 */
package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.MessageDetailsPlace;
import com.covoiturage.client.place.ReplyMessagePlace;
import com.covoiturage.client.view.MessageDetailsView;
import com.covoiturage.shared.CovoiturageRequestFactory;
import com.covoiturage.shared.MessagesProxy;
import com.covoiturage.shared.MessagesRequest;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageDetailsActivity.
 */
public class MessageDetailsActivity extends AbstractActivity implements
		MessageDetailsView.Presenter {

	/** The messages details view. */
	private final MessageDetailsView messagesDetailsView;
	
	/** The request factory. */
	private final CovoiturageRequestFactory requestFactory;
	
	/** The place controller. */
	private final PlaceController placeController;

	/** The message. */
	private MessagesProxy message;

	/**
	 * Instantiates a new message details activity.
	 *
	 * @param clientFactory the client factory
	 */
	public MessageDetailsActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();

		this.messagesDetailsView = clientFactory.getMessageDetailsView();
		this.placeController = clientFactory.getPlaceController();
	}

	/**
	 * Bind.
	 */
	private void bind() {
		showMessage();
		messagesDetailsView.getAnswerButton().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						goTo(new ReplyMessagePlace(message.getId().toString()));

					}
				});
	}

	/**
	 * Show message.
	 */
	protected void showMessage() {

		MessagesRequest requestMessages = requestFactory.messagesRequest();
		Request<MessagesProxy> createReqMessages = requestMessages
				.findMessages(Long
						.valueOf(((MessageDetailsPlace) placeController
								.getWhere()).getMessageDetailsName()));
		createReqMessages.fire(new Receiver<MessagesProxy>() {

			@Override
			public void onSuccess(MessagesProxy response) {
				message = response;
				messagesDetailsView.getFromLabel().setText(message.getFrom());
				messagesDetailsView.getSubjectLabel().setText(
						message.getSubject());
				messagesDetailsView.getDateLabel().setText(
						message.getDate().toString());
				messagesDetailsView.getMessageText().setText(
						message.getMessage());

			}

			@Override
			public void onFailure(ServerFailure error) {
				if (error.getMessage().contains("not logged in"))
					goTo(new LoginPlace(null));

			}

		});

	}

	/* (non-Javadoc)
	 * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget, com.google.gwt.event.shared.EventBus)
	 */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		messagesDetailsView.setPresenter(this);
		panel.setWidget(messagesDetailsView.asWidget());
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessageDetailsView.Presenter#goTo(com.google.gwt.place.shared.Place)
	 */
	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
