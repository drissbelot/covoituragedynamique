/*
 * 
 */
package com.covoiturage.client.view;

import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ReplyMessageViewImpl.
 */
public class ReplyMessageViewImpl extends Composite implements ReplyMessageView {

	/**
	 * The Interface MyUiBinder.
	 */
	interface MyUiBinder extends UiBinder<VerticalPanel, ReplyMessageViewImpl> {
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
	HtmlEditor messageText;

	/** The answer button. */
	@UiField
	Button answerButton;

	/** The presenter. */
	@SuppressWarnings("unused")
	private Presenter presenter;

	/**
	 * Instantiates a new reply message view impl.
	 */
	public ReplyMessageViewImpl() {
		initWidget(binder.createAndBindUi(this));

	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ReplyMessageView#setPresenter(com.covoiturage.client.view.ReplyMessageView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ReplyMessageView#getSubjectLabel()
	 */
	@Override
	public Label getSubjectLabel() {
		return subjectLabel;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ReplyMessageView#getFromLabel()
	 */
	@Override
	public Label getFromLabel() {
		return fromLabel;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ReplyMessageView#getDateLabel()
	 */
	@Override
	public Label getDateLabel() {
		return dateLabel;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ReplyMessageView#getMessageText()
	 */
	@Override
	public HtmlEditor getMessageText() {
		return messageText;
	}

	/* (non-Javadoc)
	 * @see com.covoiturage.client.view.ReplyMessageView#getAnswerButton()
	 */
	@Override
	public Button getAnswerButton() {
		return answerButton;
	}

}
