package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MessageDetailsViewImpl extends Composite implements
		MessageDetailsView {

	interface MyUiBinder extends
			UiBinder<VerticalPanel, MessageDetailsViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

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

	public MessageDetailsViewImpl() {
		initWidget(binder.createAndBindUi(this));

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
