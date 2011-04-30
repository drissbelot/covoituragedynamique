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
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.ServerFailure;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ReplyMessageActivity extends AbstractActivity implements
		ReplyMessageView.Presenter {

	private final ReplyMessageView replyMessageView;
	private final CovoiturageRequestFactory requestFactory;
	private final PlaceController placeController;

	private MessagesProxy message;

	public ReplyMessageActivity(ClientFactory clientFactory) {
		this.requestFactory = clientFactory.getRequestFactory();

		this.replyMessageView = clientFactory.getReplyMessageView();
		this.placeController = clientFactory.getPlaceController();
	}

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

	protected void showMessage() {

		MessagesRequest requestMessages = requestFactory.messagesRequest();
		Request<MessagesProxy> createReqMessages = requestMessages
				.findMessages(Long.valueOf(((MessageDetailsPlace) placeController.getWhere())
						.getMessageDetailsName()));
		createReqMessages.fire(new Receiver<MessagesProxy>() {

			@Override
			public void onSuccess(MessagesProxy response) {
				message = response;
				replyMessageView.getFromLabel().setText(message.getFrom());
				replyMessageView.getSubjectLabel()
						.setText(message.getSubject());
				replyMessageView.getDateLabel().setText(
						message.getDate().toString());
				replyMessageView.getMessageText().setText(message.getMessage());

			}

			@Override
			public void onFailure(ServerFailure error) {
				if (error.getMessage().contains("not logged in"))
					goTo(new LoginPlace(null));

			}

		});

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bind();
		replyMessageView.setPresenter(this);
		panel.setWidget(replyMessageView.asWidget());
	}

	@Override
	public void goTo(Place place) {

		placeController.goTo(place);
	}

}
