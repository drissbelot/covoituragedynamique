package com.covoiturage.client.view;

import com.covoiturage.client.i18n.ReplyMessageViewConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ReplyMessageViewImpl extends Composite implements ReplyMessageView {

	interface MyUiBinder extends UiBinder<VerticalPanel, ReplyMessageViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private final ReplyMessageViewConstants constants = (ReplyMessageViewConstants) GWT
			.create(ReplyMessageViewConstants.class);

	@UiField
	Label subjectLabel;

	@UiField
	Label fromLabel;
	@UiField
	Label dateLabel;
	@UiField
	TextArea messageText;

	@UiField
	Button answerButton;

	@SuppressWarnings("unused")
	private Presenter presenter;

	public ReplyMessageViewImpl() {
		initWidget(binder.createAndBindUi(this));
		answerButton.setText(constants.answer());
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Label getSubjectLabel() {
		return subjectLabel;
	}

	@Override
	public Label getFromLabel() {
		return fromLabel;
	}

	@Override
	public Label getDateLabel() {
		return dateLabel;
	}

	@Override
	public TextArea getMessageText() {
		return messageText;
	}

	@Override
	public Button getAnswerButton() {
		return answerButton;
	}

}
