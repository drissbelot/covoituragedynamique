package com.covoiturage.client.view;

import com.covoiturage.client.i18n.HeaderViewConstants;
import com.extjs.gxt.ui.client.widget.Label;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class HeaderViewImpl extends Composite implements HeaderView {

	interface MyUiBinder extends UiBinder<HorizontalPanel, HeaderViewImpl> {
	}

	private static final MyUiBinder binder = GWT.create(MyUiBinder.class);
	private HeaderViewConstants constants = (HeaderViewConstants) GWT
			.create(HeaderViewConstants.class);

	@UiField
	Anchor logout;
	@UiField
	Label currentUser, messages;
	@UiField
	com.google.gwt.user.client.ui.Label titre;
	@UiField
	HorizontalPanel menu;
	@SuppressWarnings("unused")
	private Presenter presenter;

	public HeaderViewImpl() {
		initWidget(binder.createAndBindUi(this));
		messages.setTitle(constants.message());
		titre.setText(constants.title());
		logout.setText(constants.logout());
		currentUser.setTitle(constants.username());
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public HasClickHandlers getLogout() {
		return logout;
	}

	public Label getCurrentUser() {
		return currentUser;
	}

	public Label getMessages() {
		return messages;
	}
}
