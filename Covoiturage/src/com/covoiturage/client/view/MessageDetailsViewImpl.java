package com.covoiturage.client.view;

import com.covoiturage.client.i18n.MessageDetailsViewConstants;
import com.google.gwt.core.client.GWT;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
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
	private MessageDetailsViewConstants constants = (MessageDetailsViewConstants) GWT
			.create(MessageDetailsViewConstants.class);

	@UiField
	Label subjectLabel;

	@UiField
	Label fromLabel;
	@UiField
	Label dateLabel;
	@UiField
	TextArea messageText;

	@SuppressWarnings("unused")
	private Presenter presenter;

	public MessageDetailsViewImpl() {
		initWidget(binder.createAndBindUi(this));

	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public Label getSubjectLabel() {
		return subjectLabel;
	}

	public Label getFromLabel() {
		return fromLabel;
	}

	public Label getDateLabel() {
		return dateLabel;
	}

	public TextArea getMessageText() {
		return messageText;
	}

}
