package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.VerticalPanel;

public class ReplyMessageViewImpl extends Composite implements ReplyMessageView {

	interface MyUiBinder extends UiBinder<VerticalPanel, ReplyMessageViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	@UiField
	Label subjectLabel;

	@UiField
	Label fromLabel;
	@UiField
	Label dateLabel;
	@UiField
	HtmlEditor messageText;

	@UiField
	Button answerButton;

	@SuppressWarnings("unused")
	private Presenter presenter;

	public ReplyMessageViewImpl() {
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
	public HtmlEditor getMessageText() {
		return messageText;
	}

	@Override
	public Button getAnswerButton() {
		return answerButton;
	}

}
