/*
 * 
 */
package com.covoiturage.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageDetailsViewImpl.
 */
public class MessageDetailsViewImpl extends Composite implements
		MessageDetailsView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends
			UiBinder<VerticalPanel, MessageDetailsViewImpl> {
	}

	/** The Constant binder. */
	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);

	/** The subject label. */
	@UiField
	Label subjectLabel;

	/** The from label. */
	@UiField
	Label fromLabel;
	
	/** The date label. */
	@UiField
	Label dateLabel;
	
	/** The message text. */
	@UiField
	TextArea messageText;

	/** The answer button. */
	@UiField
	Button answerButton;

	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/**
	 * Instantiates a new message details view impl.
	 */
	public MessageDetailsViewImpl() {
		initWidget(binder.createAndBindUi(this));

	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessageDetailsView#setPresenter(com.covoiturage.client.view.MessageDetailsView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessageDetailsView#getSubjectLabel()
	 */
	@Override
	public Label getSubjectLabel() {
		return subjectLabel;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessageDetailsView#getFromLabel()
	 */
	@Override
	public Label getFromLabel() {
		return fromLabel;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessageDetailsView#getDateLabel()
	 */
	@Override
	public Label getDateLabel() {
		return dateLabel;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessageDetailsView#getMessageText()
	 */
	@Override
	public TextArea getMessageText() {
		return messageText;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.MessageDetailsView#getAnswerButton()
	 */
	@Override
	public Button getAnswerButton() {
		return answerButton;
	}

}
