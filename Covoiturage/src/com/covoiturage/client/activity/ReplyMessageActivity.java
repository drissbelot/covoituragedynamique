/*
 * 
 */
package com.covoiturage.client.activity;

import com.covoiturage.client.ClientFactory;
import com.covoiturage.client.place.LoginPlace;
import com.covoiturage.client.place.MessageDetailsPlace;
import com.covoiturage.client.place.ReplyMessagePlace;
import com.covoiturage.client.view.ReplyMessageView;
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
 * The Class ReplyMessageActivity.
 */
public class ReplyMessageActivity extends AbstractActivity implements
		ReplyMessageView.Presenter {

	/** The reply message view. */
	private final ReplyMessageView replyMessageView;
	
	/** The request factory. */
	private final CovoiturageRequestFactory requestFactory;
	
	/** The place controller. */
	private final PlaceController placeController;

	/** The message. */
	private MessagesProxy message;

	/**
	 * Instantiates a new reply message activity.
	 *
	 * @param clientFactory the client factory
	 */
	public ReplyMessageActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();

		this.replyMessageView = clientFactory.getReplyMessageView();
		this.placeController = clientFactory.getPlaceController();
	}

	/**
	 * Bind.
	 */
	private void bind() {
		showMessage();
		replyMessageView.getAnswerButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				goTo(new ReplyMessagePlace(
						((MessageDetailsPlace) placeController.getWhere())
								.getMessageDetailsName()));

			}
		});
	}

	/**
	 * Show message.
	 */
	protected void showMessage() {

		MessagesRequest requestMessages = requestFactory.messagesRequest();

		Request<MessagesProxy> createReqMessages = requestMessages
				.findMessages(Long.valueOf(((ReplyMessagePlace) placeController
						.getWhere()).getReplyMessagesName()));
		createReqMessages.fire(new Receiver<MessagesProxy>() {

			@Override
			public void onSuccess(MessagesProxy response) {
				message = response;
				// TODO on doit pouvoir inverser les champs
				replyMessageView.getFromLabel().setText(message.getFrom());
				replyMessageView.getSubjectLabel()
						.setText(message.getSubject());
				replyMessageView.getDateLabel().setText(
						message.getDate().toString());

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
		replyMessageView.setPresenter(this);
		panel.setWidget(replyMessageView.asWidget());
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ReplyMessageView.Presenter#goTo(com.google.gwt.place.shared.Place)
	 */
	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
